package com.tranquangvi.QLHoatDongSinhVien.modules.event.service;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.DSSinhVienDangKyDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.SinhVienDangKyDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.DSSinhVienDangKyEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.HoatDongEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.compositeKey.DSSinhVienDangKyKey;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.mapper.DSSinhVienDangKyMapper;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.repository.DSSinhVienDangKyRepository;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.entity.TaiKhoanEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.services.TaiKhoanService;
import com.tranquangvi.QLHoatDongSinhVien.util.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DSSinhVienDangKyService {
    @Autowired
    private DSSinhVienDangKyRepository dsSinhVienDangKyRepository;
    @Autowired
    private HoatDongService hoatDongService;

    @Autowired
    private TaiKhoanService taiKhoanService;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private DSSinhVienDangKyMapper dsSinhVienDangKyMapper;
    public List<DSSinhVienDangKyEntity> getDSDangKy(String maHoatDong) {
        return dsSinhVienDangKyRepository.findByMaHoatDong(maHoatDong);
    }

    public DSSinhVienDangKyEntity getByKey(DSSinhVienDangKyKey key) {
        Optional<DSSinhVienDangKyEntity> optional = dsSinhVienDangKyRepository.findById(key);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException("Không tìm thấy thông tin đăng ký!");
    }

    public void dangKyHoatDong(String maHoatDong, String token) {
        String maSo = jwtService.extractUser(token);
        DSSinhVienDangKyKey key = new DSSinhVienDangKyKey(maHoatDong, maSo);
        if (dsSinhVienDangKyRepository.findById(key).isPresent()) {
            throw new RuntimeException("Thông tin đăng ký đã tồn tại!");
        }
        HoatDongEntity hoatDong = hoatDongService.getById(maHoatDong);
        TaiKhoanEntity taiKhoan = taiKhoanService.findById(maSo);
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        DSSinhVienDangKyEntity dsSinhVienDangKy = new DSSinhVienDangKyEntity(key, hoatDong, taiKhoan, date, null);
        dsSinhVienDangKyRepository.save(dsSinhVienDangKy);
    }

    public void huyDangKyHoatDong(String maHoatDong, String token) {
        String maSo = jwtService.extractUser(token);
        DSSinhVienDangKyKey key = new DSSinhVienDangKyKey(maHoatDong, maSo);
        if (dsSinhVienDangKyRepository.findById(key).isPresent()) {
            dsSinhVienDangKyRepository.deleteById(key);
        }
        else
            throw new RuntimeException("Thông tin đăng ký chưa tồn tại!");

    }

    public String diemDanh(String maHoatDong, String maSo){
        //String maSo = jwtService.extractUser(dto.getJwtToken());
        DSSinhVienDangKyKey key = new DSSinhVienDangKyKey(maHoatDong, maSo);
        DSSinhVienDangKyEntity dsSinhVienDangKy = getByKey(key);
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        dsSinhVienDangKy.setGioDiemDanh(date);
        dsSinhVienDangKyRepository.save(dsSinhVienDangKy);
        return dsSinhVienDangKy.getTaiKhoan().getHoTen();
    }

    public List<DSSinhVienDangKyDto> getAllByMaHoatDong(String maHoatDong){
        List<DSSinhVienDangKyEntity> entities = dsSinhVienDangKyRepository.findByMaHoatDong(maHoatDong);
        List<DSSinhVienDangKyDto> dtoList = new ArrayList<>();
        for (var item :entities){
            DSSinhVienDangKyDto dto = dsSinhVienDangKyMapper.toDto(item);
            dto.setMaSo(item.getKey().getMaSo());
            dto.setTenTaiKhoan(item.getTaiKhoan().getHoTen());
            dtoList.add(dto);
        }
        return dtoList;
    }


}
