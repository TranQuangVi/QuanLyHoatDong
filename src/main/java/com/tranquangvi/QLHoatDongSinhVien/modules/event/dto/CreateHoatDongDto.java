package com.tranquangvi.QLHoatDongSinhVien.modules.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.LoaiHoatDongEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.TieuChiEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class CreateHoatDongDto {
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
    @Size(max = 255)
    private String moTa;
    private String tieuChiId;
    private String loaiHoatDongId;




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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTieuChiId() {
        return tieuChiId;
    }

    public void setTieuChiId(String tieuChiId) {
        this.tieuChiId = tieuChiId;
    }

    public String getLoaiHoatDongId() {
        return loaiHoatDongId;
    }

    public void setLoaiHoatDongId(String loaiHoatDongId) {
        this.loaiHoatDongId = loaiHoatDongId;
    }
}
