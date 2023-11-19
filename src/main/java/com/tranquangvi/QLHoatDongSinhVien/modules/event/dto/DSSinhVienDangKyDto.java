package com.tranquangvi.QLHoatDongSinhVien.modules.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class DSSinhVienDangKyDto {
    private String maHoatDong;
    private String tenHoatDong;
    private String maSo;
    private String tenTaiKhoan;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ngayDangKy;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gioDiemDanh;


}
