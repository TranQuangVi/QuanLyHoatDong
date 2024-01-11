package com.tranquangvi.QLHoatDongSinhVien.modules.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
@Getter
@Setter
public class GetAllHoatDongDto {
    @Size(max = 255)
    private String maHoatDong;
    @Size(max = 255)
    private String tenLoaiHoatDong;
    @Size(max = 255)
    private String tenTaiKhoan;
    private String hinhTaiKhoan;
    @Size(max = 255)
    private String tenTieuChi;
    @Size(max = 255)
    private String tenHoatDong;
    @DateTimeFormat(pattern = "HH:mm dd-MM-yyyy")
    @JsonFormat(pattern = "HH:mm dd-MM-yyyy")
    private LocalDateTime thoiGianBatDau;
    @DateTimeFormat(pattern = "HH:mm dd-MM-yyyy")
    @JsonFormat(pattern = "HH:mm dd-MM-yyyy")
    private LocalDateTime thoiGianKetThuc;
    @Size(max = 255)
    private String diaChi;
    @Max(Integer.MAX_VALUE)
    private Integer soLuongSinhVien;
    private Integer soLuongDangKy;
    @Size(max = 255)
    private String yeuCau;
    @Size(max = 255)
    private String hinh;
    private String trangThai;
    @Size(max = 255)
    private String moTa;
    private Boolean dangKy;
    public GetAllHoatDongDto(String maHoatDong, String tenLoaiHoatDong, String tenTaiKhoan, String hinhTaiKhoan, String tenTieuChi, String tenHoatDong, LocalDateTime thoiGianBatDau, LocalDateTime thoiGianKetThuc, String diaChi, Integer soLuongSinhVien, Integer soLuongDangKy, String yeuCau, String hinh, String trangThai, String moTa, Boolean dangKy) {
        this.maHoatDong = maHoatDong;
        this.tenLoaiHoatDong = tenLoaiHoatDong;
        this.tenTaiKhoan = tenTaiKhoan;
        this.hinhTaiKhoan = hinhTaiKhoan;
        this.tenTieuChi = tenTieuChi;
        this.tenHoatDong = tenHoatDong;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.diaChi = diaChi;
        this.soLuongSinhVien = soLuongSinhVien;
        this.soLuongDangKy = soLuongDangKy;
        this.yeuCau = yeuCau;
        this.hinh = hinh;
        this.trangThai = trangThai;
        this.moTa = moTa;
        this.dangKy = dangKy;
    }

    public GetAllHoatDongDto() {
    }

    public String getHinhTaiKhoan() {
        return hinhTaiKhoan;
    }

    public void setHinhTaiKhoan(String hinhTaiKhoan) {
        this.hinhTaiKhoan = hinhTaiKhoan;
    }

    public Boolean getDangKy() {
        return dangKy;
    }

    public void setDangKy(Boolean dangKy) {
        this.dangKy = dangKy;
    }

    public Integer getSoLuongDangKy() {
        return soLuongDangKy;
    }

    public void setSoLuongDangKy(Integer soLuongDangKy) {
        this.soLuongDangKy = soLuongDangKy;
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

    public String getTenLoaiHoatDong() {
        return tenLoaiHoatDong;
    }

    public void setTenLoaiHoatDong(String tenLoaiHoatDong) {
        this.tenLoaiHoatDong = tenLoaiHoatDong;
    }

    public String getTenTieuChi() {
        return tenTieuChi;
    }

    public void setTenTieuChi(String tenTieuChi) {
        this.tenTieuChi = tenTieuChi;
    }

    public String getTenHoatDong() {
        return tenHoatDong;
    }

    public void setTenHoatDong(String tenHoatDong) {
        this.tenHoatDong = tenHoatDong;
    }

    public LocalDateTime getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(LocalDateTime thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public LocalDateTime getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(LocalDateTime thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Integer getSoLuongSinhVien() {
        return soLuongSinhVien;
    }

    public void setSoLuongSinhVien(Integer soLuongSinhVien) {
        this.soLuongSinhVien = soLuongSinhVien;
    }

    public String getYeuCau() {
        return yeuCau;
    }

    public void setYeuCau(String yeuCau) {
        this.yeuCau = yeuCau;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
