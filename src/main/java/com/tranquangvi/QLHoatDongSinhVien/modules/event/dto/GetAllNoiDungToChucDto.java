package com.tranquangvi.QLHoatDongSinhVien.modules.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class GetAllNoiDungToChucDto {
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
    private List<CTNoiDungToChucDto> ctNoidungToChuc;

    public GetAllNoiDungToChucDto() {
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

    public String getMaHoatDong() {
        return maHoatDong;
    }

    public void setMaHoatDong(String maHoatDong) {
        this.maHoatDong = maHoatDong;
    }

    public List<CTNoiDungToChucDto> getCtNoidungToChuc() {
        return ctNoidungToChuc;
    }

    public void setCtNoidungToChuc(List<CTNoiDungToChucDto> ctNoidungToChuc) {
        this.ctNoidungToChuc = ctNoidungToChuc;
    }

    public GetAllNoiDungToChucDto(String maNoiDung, String tenNoiDung, LocalDateTime thoiGianBatDau, Date thoiGianKetThuc, String noiDung, String ghiChu, String maHoatDong, List<CTNoiDungToChucDto> ctNoidungToChuc) {
        this.maNoiDung = maNoiDung;
        this.tenNoiDung = tenNoiDung;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.noiDung = noiDung;
        this.ghiChu = ghiChu;
        this.maHoatDong = maHoatDong;
        this.ctNoidungToChuc = ctNoidungToChuc;
    }
}
