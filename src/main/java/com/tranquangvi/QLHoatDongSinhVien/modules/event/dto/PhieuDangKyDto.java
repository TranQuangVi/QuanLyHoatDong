package com.tranquangvi.QLHoatDongSinhVien.modules.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.PhieuDangKyEntity}
 */

public class PhieuDangKyDto {
    private  String maPhieu;
    private  String maSo;
    private  HoatDongAcceptedDTO hoatDong;
    private  String tenPhieu;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private  Date ngayGui;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private  Date ngayDuyet;
    private  String trangThai;
    private  String ghiChu;

    public PhieuDangKyDto() {
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }


    public void setTenPhieu(String tenPhieu) {
        this.tenPhieu = tenPhieu;
    }

    public void setNgayGui(Date ngayGui) {
        this.ngayGui = ngayGui;
    }

    public void setNgayDuyet(Date ngayDuyet) {
        this.ngayDuyet = ngayDuyet;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public String getMaSo() {
        return maSo;
    }

    public HoatDongAcceptedDTO getHoatDong() {
        return hoatDong;
    }

    public void setHoatDong(HoatDongAcceptedDTO hoatDong) {
        this.hoatDong = hoatDong;
    }

    public String getTenPhieu() {
        return tenPhieu;
    }

    public Date getNgayGui() {
        return ngayGui;
    }

    public Date getNgayDuyet() {
        return ngayDuyet;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public PhieuDangKyDto(String maPhieu, String maSo, HoatDongAcceptedDTO hoatDong, String tenPhieu, Date ngayGui, Date ngayDuyet, String trangThai, String ghiChu) {
        this.maPhieu = maPhieu;
        this.maSo = maSo;
        this.hoatDong = hoatDong;
        this.tenPhieu = tenPhieu;
        this.ngayGui = ngayGui;
        this.ngayDuyet = ngayDuyet;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
    }
}