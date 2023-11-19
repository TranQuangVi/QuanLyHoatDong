package com.tranquangvi.QLHoatDongSinhVien.modules.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.LoaiHoatDongEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.TieuChiEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class HoatDongDto {
    @Size(max = 255)
    private String maHoatDong;
    @Size(max = 255)
    private String tenHoatDong;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime thoiGianBatDau;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime thoiGianKetThuc;
    @Size(max = 255)
    private String diaChi;
    @Max(Integer.MAX_VALUE)
    private Integer soLuongSinhVien;
    @Size(max = 255)
    private String yeuCau;
    @Size(max = 255)
    private String hinh;
    private Boolean trangThai;
    @Size(max = 255)
    private String moTa;
    private String maTieuChi;
    private String maLoaiHoatDong;

    public String getMaHoatDong() {
        return maHoatDong;
    }

    public void setMaHoatDong(String maHoatDong) {
        this.maHoatDong = maHoatDong;
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

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getMaTieuChi() {
        return maTieuChi;
    }

    public void setMaTieuChi(String maTieuChi) {
        this.maTieuChi = maTieuChi;
    }

    public String getMaLoaiHoatDong() {
        return maLoaiHoatDong;
    }

    public void setMaLoaiHoatDong(String maLoaiHoatDong) {
        this.maLoaiHoatDong = maLoaiHoatDong;
    }

    public HoatDongDto() {
    }

    public HoatDongDto(String maHoatDong, String tenHoatDong, LocalDateTime thoiGianBatDau, LocalDateTime thoiGianKetThuc, String diaChi, Integer soLuongSinhVien, String yeuCau, String hinh, Boolean trangThai, String moTa, String maTieuChi, String maLoaiHoatDong) {
        this.maHoatDong = maHoatDong;
        this.tenHoatDong = tenHoatDong;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.diaChi = diaChi;
        this.soLuongSinhVien = soLuongSinhVien;
        this.yeuCau = yeuCau;
        this.hinh = hinh;
        this.trangThai = trangThai;
        this.moTa = moTa;
        this.maTieuChi = maTieuChi;
        this.maLoaiHoatDong = maLoaiHoatDong;
    }
}