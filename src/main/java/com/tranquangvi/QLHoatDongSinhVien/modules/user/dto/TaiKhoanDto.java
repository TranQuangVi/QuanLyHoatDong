package com.tranquangvi.QLHoatDongSinhVien.modules.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;

/**
 * DTO for {@link com.tranquangvi.QLHoatDongSinhVien.modules.user.entity.TaiKhoanEntity}
 */
public class TaiKhoanDto {
    public String maSo;
    public String hoTen;
    public String gioiTinh;
//    @DateTimeFormat(pattern = "dd-MM-yyyy")
//    @JsonFormat(pattern = "dd-MM-yyyy")
    public Date ngaySinh;
    public String email;
    public String sdt;
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

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
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

    public TaiKhoanDto(String maSo, String hoTen, String gioiTinh, Date ngaySinh, String email, String sdt, String diaChi, String hinh) {
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