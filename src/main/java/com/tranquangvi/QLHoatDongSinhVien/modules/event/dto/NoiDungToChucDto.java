package com.tranquangvi.QLHoatDongSinhVien.modules.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.HoatDongEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.NoiDungToChucEntity;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;


public class NoiDungToChucDto  {

    private String maNoiDung;

    private String tenNoiDung;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime thoiGianBatDau;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date thoiGianKetThuc;

    private String noiDung;

    private String ghiChu;

    private String maHoatDong;


    public NoiDungToChucDto() {
    }

    public String getMaNoiDung() {
        return maNoiDung;
    }

    public void setMaNoiDung(String maNoiDung) {
        this.maNoiDung = maNoiDung;
    }

    public String getTenNoiDung() {
        return tenNoiDung;
    }

    public void setTenNoiDung(String tenNoiDung) {
        this.tenNoiDung = tenNoiDung;
    }

    public LocalDateTime getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(LocalDateTime thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public Date getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Date thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public NoiDungToChucDto(String maNoiDung, String tenNoiDung, LocalDateTime thoiGianBatDau, Date thoiGianKetThuc, String noiDung, String ghiChu, String maHoatDong) {
        this.maNoiDung = maNoiDung;
        this.tenNoiDung = tenNoiDung;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.noiDung = noiDung;
        this.ghiChu = ghiChu;
        this.maHoatDong = maHoatDong;
    }

    public String getMaHoatDong() {
        return maHoatDong;
    }

    public void setMaHoatDong(String maHoatDong) {
        this.maHoatDong = maHoatDong;
    }
}
