package com.tranquangvi.QLHoatDongSinhVien.modules.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class PhieuDangKyGetAllDto {
    private  String maPhieu;
    private  String tenTaiKhoan;
    private  String maHoatDong;
    private  String tenPhieu;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ngayGui;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private  Date ngayDuyet;
    private  String trangThai;
    private  String ghiChu;

    public PhieuDangKyGetAllDto() {
    }

    public PhieuDangKyGetAllDto(String maPhieu, String tenTaiKhoan, String maHoatDong, String tenPhieu, Date ngayGui, Date ngayDuyet, String trangThai, String ghiChu) {
        this.maPhieu = maPhieu;
        this.tenTaiKhoan = tenTaiKhoan;
        this.maHoatDong = maHoatDong;
        this.tenPhieu = tenPhieu;
        this.ngayGui = ngayGui;
        this.ngayDuyet = ngayDuyet;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
    }

    public Date getNgayDuyet() {
        return ngayDuyet;
    }

    public void setNgayDuyet(Date ngayDuyet) {
        this.ngayDuyet = ngayDuyet;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMaHoatDong() {
        return maHoatDong;
    }

    public void setMaHoatDong(String maHoatDong) {
        this.maHoatDong = maHoatDong;
    }

    public String getTenPhieu() {
        return tenPhieu;
    }

    public void setTenPhieu(String tenPhieu) {
        this.tenPhieu = tenPhieu;
    }

    public Date getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(Date ngayGui) {
        this.ngayGui = ngayGui;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
