package com.tranquangvi.QLHoatDongSinhVien.modules.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

public class HoatDongAcceptedDTO {
    private String maHoatDong;
    private String tenHoatDong;
    @DateTimeFormat(pattern = "HH:mm dd-MM-yyyy")
    @JsonFormat(pattern = "HH:mm dd-MM-yyyy")
    private LocalDateTime thoiGianBatDau;
    @DateTimeFormat(pattern = "HH:mm dd-MM-yyyy")
    @JsonFormat(pattern = "HH:mm dd-MM-yyyy")
    private LocalDateTime thoiGianKetThuc;
    private String diaChi;
    private Integer soLuongSinhVien;
    private String yeuCau;
    private String hinh;
    private String trangThai;
    private String moTa;
    private String tenTieuChi;
    private String tenLoaiHoatDong;
    private List<GetAllNoiDungToChucDto> noiDungToChuc;

    public HoatDongAcceptedDTO() {
    }

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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTenTieuChi() {
        return tenTieuChi;
    }

    public void setTenTieuChi(String tenTieuChi) {
        this.tenTieuChi = tenTieuChi;
    }

    public String getTenLoaiHoatDong() {
        return tenLoaiHoatDong;
    }

    public void setTenLoaiHoatDong(String tenLoaiHoatDong) {
        this.tenLoaiHoatDong = tenLoaiHoatDong;
    }

    public List<GetAllNoiDungToChucDto> getNoiDungToChuc() {
        return noiDungToChuc;
    }

    public void setNoiDungToChuc(List<GetAllNoiDungToChucDto> noiDungToChuc) {
        this.noiDungToChuc = noiDungToChuc;
    }

    public HoatDongAcceptedDTO(String maHoatDong, String tenHoatDong, LocalDateTime thoiGianBatDau, LocalDateTime thoiGianKetThuc, String diaChi, Integer soLuongSinhVien, String yeuCau, String hinh, String trangThai, String moTa, String tenTieuChi, String tenLoaiHoatDong, List<GetAllNoiDungToChucDto> noiDungToChuc) {
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
        this.tenTieuChi = tenTieuChi;
        this.tenLoaiHoatDong = tenLoaiHoatDong;
        this.noiDungToChuc = noiDungToChuc;
    }
}
