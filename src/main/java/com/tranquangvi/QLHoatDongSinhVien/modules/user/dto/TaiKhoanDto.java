package com.tranquangvi.QLHoatDongSinhVien.modules.user.dto;

import lombok.Value;

import java.io.Serializable;
import java.sql.Date;

/**
 * DTO for {@link com.tranquangvi.QLHoatDongSinhVien.modules.user.entity.TaiKhoanEntity}
 */
public class TaiKhoanDto {
    public String maSo;
    public String hoTen;
    public Boolean gioiTinh;
    public Date ngaySinh;
    public String email;
    public Character sdt;
    public String diaChi;
    public String hinh;

    public TaiKhoanDto() {
    }

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getSdt() {
        return sdt;
    }

    public void setSdt(Character sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public TaiKhoanDto(String maSo, String hoTen, Boolean gioiTinh, Date ngaySinh, String email, Character sdt, String diaChi, String hinh) {
        this.maSo = maSo;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.hinh = hinh;
    }
}