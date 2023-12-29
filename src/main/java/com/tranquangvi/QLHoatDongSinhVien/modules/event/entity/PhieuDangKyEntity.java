package com.tranquangvi.QLHoatDongSinhVien.modules.event.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Entity
@Table(name = "phieudangky")
public class PhieuDangKyEntity {
    @Id
    @Column(name = "maphieu")
    private String maPhieu;
    @Column(name = "maso")
    private String maSo;
    @Column(name = "mahoatdong")
    private String maHoatDong;
    @Column(name = "tenphieu")
    private String tenPhieu;
    @DateTimeFormat(pattern = " HH:mm:ss dd-MMM-yyyy")
    @Column(name = "ngaygui")
    private Date ngayGui;
    @DateTimeFormat(pattern = " HH:mm:ss dd-MMM-yyyy")
    @Column(name = "ngayduyet")
    private Date ngayDuyet;
    @Column(name = "trangthai")
    private String trangThai;
    @Column(name = "ghichu")
    private String ghiChu;

    public PhieuDangKyEntity() {
    }

    public PhieuDangKyEntity(String maPhieu, String maSo, String maHoatDong, String tenPhieu, Date ngayGui, Date ngayDuyet, String trangThai, String ghiChu) {
        this.maPhieu = maPhieu;
        this.maSo = maSo;
        this.maHoatDong = maHoatDong;
        this.tenPhieu = tenPhieu;
        this.ngayGui = ngayGui;
        this.ngayDuyet = ngayDuyet;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
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

    public Date getNgayDuyet() {
        return ngayDuyet;
    }

    public void setNgayDuyet(Date ngayDuyet) {
        this.ngayDuyet = ngayDuyet;
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
