package com.tranquangvi.QLHoatDongSinhVien.modules.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class DSSinhVienDangKyDto {
    private String maSo;
    private String tenTaiKhoan;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ngayDangKy;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gioDiemDanh;

    public DSSinhVienDangKyDto() {
    }

    public DSSinhVienDangKyDto(String maSo, String tenTaiKhoan, Date ngayDangKy, Date gioDiemDanh) {
        this.maSo = maSo;
        this.tenTaiKhoan = tenTaiKhoan;
        this.ngayDangKy = ngayDangKy;
        this.gioDiemDanh = gioDiemDanh;
    }

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public Date getGioDiemDanh() {
        return gioDiemDanh;
    }

    public void setGioDiemDanh(Date gioDiemDanh) {
        this.gioDiemDanh = gioDiemDanh;
    }
}
