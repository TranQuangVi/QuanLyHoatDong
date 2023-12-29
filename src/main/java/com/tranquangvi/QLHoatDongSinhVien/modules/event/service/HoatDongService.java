package com.tranquangvi.QLHoatDongSinhVien.modules.event.service;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.*;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.HoatDongEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.mapper.*;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.repository.DSSinhVienDangKyRepository;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.repository.HoatDongRepository;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.repository.LoaiHoatDongRepository;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.repository.TieuChiRepository;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.repositories.TaiKhoanRepository;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.services.TaiKhoanService;
import com.tranquangvi.QLHoatDongSinhVien.util.JwtService;
import com.tranquangvi.QLHoatDongSinhVien.util.JwtTokenFilter;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class HoatDongService {
    @Autowired
    private HoatDongRepository repository;
    @Autowired
    private HoatDongMapperImpl hoatDongMapper;
    @Autowired
    private GetAllHoatDongMapperImpl getAllHoatDongMapper;
    @Autowired
    private CreateHoatDongMapperImpl createHoatDongMapper;
    @Autowired
    private TieuChiRepository tieuChiRepository;
    @Autowired
    private LoaiHoatDongRepository loaiHoatDongRepository;
    @Autowired
    private TaiKhoanService taiKhoanService;
    @Autowired
    private DSSinhVienDangKyRepository dsSinhVienDangKyRepository;
    @Autowired
    private JwtService jwtService;

    public Page<GetAllHoatDongDto> getAll(Pageable pageable) {
        Page<HoatDongEntity> pageContent = repository.findAll(pageable);
        List<HoatDongEntity> entities = pageContent.getContent();
        List<GetAllHoatDongDto> listDto = new ArrayList<>();
        for (HoatDongEntity item : entities) {
            GetAllHoatDongDto dtoContent = getAllHoatDongMapper.toDto(item);
            dtoContent.setTenTieuChi(item.getTieuChi().getTenTieuChi());
            dtoContent.setTenLoaiHoatDong(item.getLoaiHoatDong().getTenLoaiHoatDong());
            dtoContent.setTenTaiKhoan(item.getTaiKhoan().getHoTen());
            try {
                dtoContent.setSoLuongDangKy(dsSinhVienDangKyRepository.findByMaHoatDong(item.getMaHoatDong()).size());
            } catch (Exception e) {
                dtoContent.setSoLuongDangKy(0);
            }

            listDto.add(dtoContent);
        }

        Page<GetAllHoatDongDto> pageDtos = new PageImpl<>(listDto, pageable, pageContent.getTotalElements());
        return pageDtos;
    }

    public void add(CreateHoatDongDto dto, String jwt) {
        if (repository.findById(dto.getMaHoatDong()).isPresent()) {
            throw new RuntimeException("Mã hoạt đã tồn tại!");
        } else {
            HoatDongEntity entity = createHoatDongMapper.toEntity(dto);
            entity.setTaiKhoan(taiKhoanService.findByToken(jwt));
            entity.setLoaiHoatDong(loaiHoatDongRepository.findById(dto.getLoaiHoatDongId())
                    .orElseThrow(() -> new RuntimeException("Ma loai hoat dong not found!")));
            entity.setTieuChi(tieuChiRepository.findById(dto.getTieuChiId())
                    .orElseThrow(() -> new RuntimeException("Ma tieu chi not found!")));
            entity.setTrangThai("Chưa mở");
            repository.save(entity);
        }
    }

    public void deleteById(String id) {
        try {
            HoatDongEntity hoatDong = repository.findById(id).orElseThrow(() -> new RuntimeException("Hoạt động không tồn tại!"));
            if (hoatDong.getTrangThai().toString().equals("Đang triển khai")) {
                throw new RuntimeException("Hoạt động đang triển khai, không thể xóa!");
            } else
                repository.deleteById(id);
        } catch (Exception e) {
            // Bắt các lỗi khác (nếu có)
            // Xử lý hoặc throw lại một ngoại lệ khác tùy vào yêu cầu của bạn
            throw new RuntimeException(e);
        }
    }

    public List<GetAllHoatDongDto> findByTaiKhoan(String jwt) {
        String maSo = jwtService.extractUser(jwt);
        List<HoatDongEntity> all = repository.findByMaSo(maSo);
        List<GetAllHoatDongDto> res = new ArrayList<>();
        for (var item : all) {
            GetAllHoatDongDto dtoContent = getAllHoatDongMapper.toDto(item);
            dtoContent.setTenTieuChi(item.getTieuChi().getTenTieuChi());
            dtoContent.setTenLoaiHoatDong(item.getLoaiHoatDong().getTenLoaiHoatDong());
            dtoContent.setTenTaiKhoan(item.getTaiKhoan().getHoTen());
            res.add(dtoContent);

        }
        return res;
    }

    public List<GetAllHoatDongDto> findByThang(int month, int year, String jwt) {
        //List<GetAllHoatDongDto> all = findByTaiKhoan(jwt);
        List<GetAllHoatDongDto> all = getByTrangThai("Đã hoàn thành");
        List<GetAllHoatDongDto> res = new ArrayList<>();
        for (var item : all) {
            if (item.getThoiGianBatDau().getMonth().getValue() == month && item.getThoiGianBatDau().getYear() == year) {
                res.add(item);
            }
        }
        return res;
    }

    public HoatDongDto findById(String id) {
        HoatDongEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hoat dong not found with id: " + id));
        HoatDongDto dto = hoatDongMapper.toDto(entity);
        dto.setMaLoaiHoatDong(entity.getLoaiHoatDong().getMaLoaiHoatDong());
        dto.setMaTieuChi(entity.getTieuChi().getMaTieuChi());
        return dto;
    }

    public HoatDongEntity getById(String id) {
        HoatDongEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hoạt động với mã số: " + id));
        return entity;
    }


    public void update(HoatDongDto hoatDongDto, String id, String jwt) {
        //Authentication authentication = authenticationManager.
        HoatDongEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Hoat dong not found with id: " + id));
        HoatDongEntity data = hoatDongMapper.toEntity(hoatDongDto);
        data.setTaiKhoan(taiKhoanService.findByToken(jwt));
        data.setTieuChi(tieuChiRepository.findById(hoatDongDto.getMaTieuChi()).orElseThrow(() -> new RuntimeException("Tieu chi not found with id: " + hoatDongDto.getMaTieuChi())));
        data.setLoaiHoatDong(loaiHoatDongRepository.findById(hoatDongDto.getMaLoaiHoatDong()).orElseThrow(() -> new RuntimeException("Hoat dong not found with id: " + hoatDongDto.getMaLoaiHoatDong())));
        var trangThai = entity.getTrangThai();
        BeanUtils.copyProperties(data, entity);
        entity.setTrangThai(trangThai);
        repository.save(entity);
    }

    public void putTrangThai(String trangThai, String maHoatDong) {
        HoatDongEntity entity = repository.findById(maHoatDong).orElseThrow(() -> new RuntimeException("Hoat dong not found with id: " + maHoatDong));
        entity.setTrangThai(trangThai);
        repository.save(entity);
    }

    public List<GetAllHoatDongDto> getByTrangThai(String trangThai) {
        List<HoatDongEntity> listE = repository.findByTrangThai(trangThai);
        List<GetAllHoatDongDto> listDto = new ArrayList<>();
        for (HoatDongEntity item : listE) {
            GetAllHoatDongDto dtoContent = getAllHoatDongMapper.toDto(item);
            dtoContent.setTenTieuChi(item.getTieuChi().getTenTieuChi());
            dtoContent.setTenLoaiHoatDong(item.getLoaiHoatDong().getTenLoaiHoatDong());
            dtoContent.setTenTaiKhoan(item.getTaiKhoan().getHoTen());
            try {
                dtoContent.setSoLuongDangKy(dsSinhVienDangKyRepository.findByMaHoatDong(item.getMaHoatDong()).size());
            } catch (Exception e) {
                dtoContent.setSoLuongDangKy(0);
            }
            listDto.add(dtoContent);
        }
        return listDto;

    }

    public List<GetAllHoatDongDto> search(SearchDto dto) {
        List<HoatDongEntity> listE = new ArrayList<>();
        switch (dto.key) {
            case "tieuchi": {
                listE = repository.findByTieuChi(dto.value);
                break;
            }
            case "loai": {
                listE = repository.findByLoai(dto.value);
                break;
            }
            case "sort": {
                listE = repository.findByTrangThai("Đang triển khai");
                break;
            }
            default: {
                listE = repository.findByTrangThai("Đang triển khai");
                break;
            }
        }
        List<GetAllHoatDongDto> listDto = new ArrayList<>();
        for (HoatDongEntity item : listE) {
            GetAllHoatDongDto dtoContent = getAllHoatDongMapper.toDto(item);
            dtoContent.setTenTieuChi(item.getTieuChi().getTenTieuChi());
            dtoContent.setTenLoaiHoatDong(item.getLoaiHoatDong().getTenLoaiHoatDong());
            dtoContent.setTenTaiKhoan(item.getTaiKhoan().getHoTen());
            try {
                dtoContent.setSoLuongDangKy(dsSinhVienDangKyRepository.findByMaHoatDong(item.getMaHoatDong()).size());
            } catch (Exception e) {
                dtoContent.setSoLuongDangKy(0);
            }
            listDto.add(dtoContent);
        }
        return listDto;
    }

    public List<GetAllHoatDongDto> getHoatDongSVDK(String token){
        String maSo=jwtService.extractUser(token);
        List<HoatDongEntity> listE = repository.dsSinhVienDk(maSo);
        List<GetAllHoatDongDto> listDto = new ArrayList<>();
        for (HoatDongEntity item : listE) {
            GetAllHoatDongDto dtoContent = getAllHoatDongMapper.toDto(item);
            dtoContent.setTenTieuChi(item.getTieuChi().getTenTieuChi());
            dtoContent.setTenLoaiHoatDong(item.getLoaiHoatDong().getTenLoaiHoatDong());
            dtoContent.setTenTaiKhoan(item.getTaiKhoan().getHoTen());
            try {
                dtoContent.setSoLuongDangKy(dsSinhVienDangKyRepository.findByMaHoatDong(item.getMaHoatDong()).size());
            } catch (Exception e) {
                dtoContent.setSoLuongDangKy(0);
            }
            listDto.add(dtoContent);
        }
        return listDto;
    }
    public List<GetAllHoatDongDto> getHoatDongSVThamGia(String token){
        String maSo=jwtService.extractUser(token);
        List<HoatDongEntity> listE = repository.dsSinhVienThamGia(maSo);
        List<GetAllHoatDongDto> listDto = new ArrayList<>();
        for (HoatDongEntity item : listE) {
            GetAllHoatDongDto dtoContent = getAllHoatDongMapper.toDto(item);
            dtoContent.setTenTieuChi(item.getTieuChi().getTenTieuChi());
            dtoContent.setTenLoaiHoatDong(item.getLoaiHoatDong().getTenLoaiHoatDong());
            dtoContent.setTenTaiKhoan(item.getTaiKhoan().getHoTen());
            try {
                dtoContent.setSoLuongDangKy(dsSinhVienDangKyRepository.findByMaHoatDong(item.getMaHoatDong()).size());
            } catch (Exception e) {
                dtoContent.setSoLuongDangKy(0);
            }
            listDto.add(dtoContent);
        }
        return listDto;
    }
}
