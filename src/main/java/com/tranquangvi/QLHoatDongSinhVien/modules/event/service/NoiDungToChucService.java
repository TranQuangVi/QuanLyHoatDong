package com.tranquangvi.QLHoatDongSinhVien.modules.event.service;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.CTNoiDungToChucDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.GetAllNoiDungToChucDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.HoatDongAcceptedDTO;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.NoiDungToChucDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.ChitietNoiDungEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.HoatDongEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.NoiDungToChucEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.compositeKey.ChiTietNoiDungKey;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.mapper.CTNoiDungToChucMapper;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.mapper.GetAllNoiDungToChucMapper;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.mapper.HoatDongAcceptedMapper;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.mapper.NoiDungToChucMapperImpl;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.repository.ChiTietNoiDungRepository;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.repository.NoiDungToChucRepository;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.entity.TaiKhoanEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.services.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class NoiDungToChucService {
    @Autowired
    private NoiDungToChucRepository noiDungToChucRepository;
    @Autowired
    private NoiDungToChucMapperImpl noiDungToChucMapper;
    @Autowired
    private HoatDongService hoatDongService;
    @Autowired
    private HoatDongAcceptedMapper hoatDongAcceptedMapper;
    @Autowired
    private ChiTietNoiDungRepository chiTietNoiDungRepository;
    @Autowired
    private CTNoiDungToChucMapper ctNoiDungToChucMapper;
    @Autowired
    private GetAllNoiDungToChucMapper getAllnoiDungToChucMapper;
    @Autowired
    private TaiKhoanService taiKhoanService;

    public List<NoiDungToChucDto> getAll() {
        List<NoiDungToChucEntity> noiDungToChucs = noiDungToChucRepository.findAll();
        List<NoiDungToChucDto> listDto = new ArrayList<NoiDungToChucDto>();
        for (NoiDungToChucEntity noiDung : noiDungToChucs) {
            NoiDungToChucDto dto = noiDungToChucMapper.toDto(noiDung);
            dto.setMaHoatDong(noiDung.getHoatDong().getMaHoatDong());
            listDto.add(dto);
        }
        return listDto;
    }

//    public List<NoiDungToChucDto>  getByHoatdongId(String maHoatDong){
//        List<NoiDungToChucEntity> noiDungToChucs = noiDungToChucRepository.findAll();
//        return  noiDungToChucs;
//    }

    public NoiDungToChucDto getById(String maNoiDung) {
        Optional<NoiDungToChucEntity> entity = noiDungToChucRepository.findById(maNoiDung);
        if (entity.isPresent()) {
            NoiDungToChucDto dto = noiDungToChucMapper.toDto(entity.get());
            return dto;
        }
        throw new RuntimeException("Ma noi dung not found!");
    }

    public List<NoiDungToChucDto> getByMaHoatDong(String maHoatDong) {
        List<NoiDungToChucDto> list = noiDungToChucMapper.toDto(noiDungToChucRepository.findByMaHoatDong(maHoatDong));
        for (NoiDungToChucDto item : list) {
            item.setMaHoatDong(maHoatDong);
        }
        return list;
    }

    public void add(NoiDungToChucDto dto) {
        if (noiDungToChucRepository.findById(dto.getMaNoiDung()).isPresent()) {
            throw new RuntimeException("Tên nội dung đã tồn tại!");
        }
        NoiDungToChucEntity entity = noiDungToChucMapper.toEntity(dto);
        entity.setHoatDong(hoatDongService.getById(dto.getMaHoatDong()));
        noiDungToChucRepository.save(entity);

    }

    public void delete(String id) {
        Optional<NoiDungToChucEntity> entity = noiDungToChucRepository.findById(id);
        if (entity.isPresent()) {
            noiDungToChucRepository.deleteById(id);
        } else {
            throw new RuntimeException("Ma noi dung not found!");

        }
    }

    public void update(NoiDungToChucDto dto) {
        try {
            Optional<NoiDungToChucEntity> entity = noiDungToChucRepository.findById(dto.getMaNoiDung());
            if (entity.isPresent()) {
                NoiDungToChucEntity noidung = noiDungToChucMapper.toEntity(dto);
                noidung.setHoatDong(hoatDongService.getById(dto.getMaHoatDong()));
                noiDungToChucRepository.save(noidung);
            } else {
                throw new RuntimeException("Không tìm thấy mã nội dung: " + dto.getMaNoiDung());
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public HoatDongAcceptedDTO getHoatDongAccepted(String maHoatDong) {
        HoatDongEntity hoatDong = hoatDongService.getById(maHoatDong);
        HoatDongAcceptedDTO hoatDongAcceptedDTO = hoatDongAcceptedMapper.toDto(hoatDong);
        hoatDongAcceptedDTO.setTenTieuChi(hoatDong.getTieuChi().getTenTieuChi());
        hoatDongAcceptedDTO.setTenLoaiHoatDong(hoatDong.getLoaiHoatDong().getTenLoaiHoatDong());
        hoatDongAcceptedDTO.setNoiDungToChuc(getAllCTNoiDung(maHoatDong));
        return hoatDongAcceptedDTO;
    }

    public List<GetAllNoiDungToChucDto> getAllCTNoiDung(String maHoatDong) {
        List<GetAllNoiDungToChucDto> list = getAllnoiDungToChucMapper.toDto(noiDungToChucRepository.findByMaHoatDong(maHoatDong));
        for (GetAllNoiDungToChucDto item : list) {
            item.setMaHoatDong(maHoatDong);
            item.setCtNoidungToChuc(getCTNoiDung(item.getMaNoiDung()));

        }
        return list;
    }

    public List<CTNoiDungToChucDto> getCTNoiDung(String maNoiDung) {
        List<ChitietNoiDungEntity> list = chiTietNoiDungRepository.findByMaNoiDung(maNoiDung);
        List<CTNoiDungToChucDto> dtoList = new ArrayList<CTNoiDungToChucDto>();
        for (ChitietNoiDungEntity noidung : list
        ) {
            CTNoiDungToChucDto toChucDto = ctNoiDungToChucMapper.toDto(noidung);
            toChucDto.setTenTaiKhoan(noidung.getTaiKhoan().getHoTen());
            toChucDto.setMaTaiKhoan(noidung.getTaiKhoan().getMaSo());
            dtoList.add(toChucDto);
        }
        return dtoList;
    }

    public CTNoiDungToChucDto createCtNoiDung(CTNoiDungToChucDto dto, String maNoiDung) {

        ChiTietNoiDungKey newKey = new ChiTietNoiDungKey();
        newKey.setMaSo(dto.getMaTaiKhoan());
        newKey.setMaNoiDung(maNoiDung);

        Optional<ChitietNoiDungEntity> op = chiTietNoiDungRepository.findByKey(newKey.getMaNoiDung(), newKey.getMaSo());
        if (op.isPresent()) {
            throw new RuntimeException("Người này đã có");
        } else {
            ChitietNoiDungEntity newEntity = ctNoiDungToChucMapper.toEntity((dto));
            newEntity.setKey(newKey);
            newEntity.setTaiKhoan(taiKhoanService.findById(newKey.getMaSo()));
            newEntity.setNoiDungToChuc(noiDungToChucRepository.findById(newKey.getMaNoiDung()).get());
            chiTietNoiDungRepository.save(newEntity);
            dto.setTenTaiKhoan(newEntity.getTaiKhoan().getHoTen());
            return dto;

        }

    }

    public CTNoiDungToChucDto updateCtNoiDung(CTNoiDungToChucDto dto, ChiTietNoiDungKey oldKey) {

        ChiTietNoiDungKey newKey = new ChiTietNoiDungKey();
        newKey.setMaSo(dto.getMaTaiKhoan());
        newKey.setMaNoiDung(oldKey.getMaNoiDung());

        Optional<ChitietNoiDungEntity> op = chiTietNoiDungRepository.findByKey(oldKey.getMaNoiDung(), oldKey.getMaSo());

        if (op.isPresent()) {
            ChitietNoiDungEntity oldEntity = op.get();
            if (oldKey.getMaSo().equals(newKey.getMaSo()) && oldKey.getMaNoiDung().equals(newKey.getMaNoiDung())) {
                oldEntity.setQua(dto.getQua());
                oldEntity.setGhiChu(dto.getGhiChu());
                oldEntity.setVaiTro(dto.getVaiTro());
                oldEntity.setLinkBaiTrinhBay(dto.getLinkBaiTrinhBay());
                oldEntity.setThoiLuongTrinhBay(dto.getThoiLuongTrinhBay());
                // save oldE
                chiTietNoiDungRepository.save(oldEntity);
                dto.setTenTaiKhoan(oldEntity.getTaiKhoan().getHoTen());
                return dto;
            }
            //khác nhau
            else {
                //có rồi
                Optional<ChitietNoiDungEntity> op2 = chiTietNoiDungRepository.findByKey(newKey.getMaNoiDung(), newKey.getMaSo());
                if (op2.isPresent()) {
                    throw new RuntimeException("Nội dung này đã tồn tại!");
                } else {
                    ChitietNoiDungEntity newEntity = ctNoiDungToChucMapper.toEntity((dto));
                    newEntity.setTaiKhoan(taiKhoanService.findById(dto.getMaTaiKhoan()));
                    newEntity.setNoiDungToChuc(oldEntity.getNoiDungToChuc());
                    newEntity.setKey(newKey);
                    //delete oldE
                    chiTietNoiDungRepository.deleteById(oldKey);
                    //create newE
                    chiTietNoiDungRepository.save(newEntity);
                    dto.setTenTaiKhoan(newEntity.getTaiKhoan().getHoTen());
                    return dto;
                }
            }
        } else {
            throw new RuntimeException("Không tìm thấy chi tiết nội dung với " + "mã nội dung: " + oldKey.getMaNoiDung() + " ,mã tài khoản: " + oldKey.getMaSo());
        }
    }

    public void delCtNoiDung(ChiTietNoiDungKey key) {
        try {
            Optional<ChitietNoiDungEntity> optional = chiTietNoiDungRepository.findByKey(key.getMaNoiDung(), key.getMaSo());
            if (optional.isPresent())
                chiTietNoiDungRepository.deleteById(key);
            else
                throw new RuntimeException("Không tìm thấy nôi dung với mã nội dung: " + key.getMaNoiDung() + " ,mã số: " + key.getMaSo());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
