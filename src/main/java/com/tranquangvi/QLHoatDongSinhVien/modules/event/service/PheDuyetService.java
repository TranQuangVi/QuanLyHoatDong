package com.tranquangvi.QLHoatDongSinhVien.modules.event.service;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.HoatDongDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.PhieuDangKyCreateDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.PhieuDangKyDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.PhieuDangKyGetAllDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.PhieuDangKyEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.mapper.PhieuDangKyCreateMapper;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.mapper.PhieuDangKyGetAllMapper;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.mapper.PhieuDangKyMapper;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.repository.PheDuyetRepository;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.services.TaiKhoanService;
import com.tranquangvi.QLHoatDongSinhVien.util.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PheDuyetService {
    @Autowired
    private PheDuyetRepository pheDuyetRepository;
    @Autowired
    private PhieuDangKyMapper phieuDangKyMapper;
    @Autowired
    private PhieuDangKyGetAllMapper phieuDangKyGetAllMapper;
    @Autowired
    private TaiKhoanService taiKhoanService;
    @Autowired
    private PhieuDangKyCreateMapper phieuDangKyCreateMapper;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private NoiDungToChucService noiDungToChucService;
    @Autowired
    private HoatDongService hoatDongService;

    public List<PhieuDangKyGetAllDto> findAll() {
        List<PhieuDangKyEntity> list = pheDuyetRepository.findAll();
        List<PhieuDangKyGetAllDto> listDto = new ArrayList<>();
        for (var item : list) {
            PhieuDangKyGetAllDto dto = phieuDangKyGetAllMapper.toDto(item);
            dto.setTenTaiKhoan(taiKhoanService.getTaiKhoanById(item.getMaSo()).getHoTen());
            listDto.add(dto);
        }
        return listDto;
    }

    public PhieuDangKyDto findById(String maPhieu) {
        PhieuDangKyEntity entity = pheDuyetRepository.findById(maPhieu)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hoạt động với mã số: " + maPhieu));
        PhieuDangKyDto dto = phieuDangKyMapper.toDto(entity);
        dto.setHoatDong(noiDungToChucService.getHoatDongAccepted(entity.getMaHoatDong()));
        return dto;
    }

    public void add(PhieuDangKyCreateDto dto, String jwt) {
        try {
            dto.setNgayDuyet(null);
            PhieuDangKyEntity entity = phieuDangKyCreateMapper.toEntity(dto);
            entity.setMaSo(jwtService.extractUser(jwt));
            entity.setTrangThai("Chờ duyệt");
            pheDuyetRepository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void putTrangThaiDuyet(String maPhieu, String trangThai) {
        PhieuDangKyEntity entity = pheDuyetRepository.findById(maPhieu)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Phiếu duyệt với mã phiếu: " + maPhieu));
        entity.setTrangThai(trangThai);
        Date date= new Date();

        entity.setNgayDuyet(date);
        if (trangThai.equals("Đã duyệt"))
            hoatDongService.putTrangThai("Chưa triển khai", entity.getMaHoatDong());
        pheDuyetRepository.save(entity);

    }
}
