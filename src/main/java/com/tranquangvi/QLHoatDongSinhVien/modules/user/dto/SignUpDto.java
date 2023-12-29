package com.tranquangvi.QLHoatDongSinhVien.modules.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class SignUpDto {
    private String maSo;
    private String matKhau;
    private String hoTen;
    private String maChucVu;
    private String gioiTinh;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ngaySinh;

    private String email;

    private String sdt;

    private String diaChi;

    private String hinh;

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

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setMaChucVu(String maChucVu) {
        this.maChucVu = maChucVu;
    }

    public String getMaSo() {
        return maSo;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getMaChucVu() {
        return maChucVu;
    }

    public SignUpDto() {
    }

    public SignUpDto(String maSo, String matKhau, String hoTen, String maChucVu, String gioiTinh, Date ngaySinh, String email, String sdt, String diaChi, String hinh) {
        this.maSo = maSo;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.maChucVu = maChucVu;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.hinh = hinh;
    }
}
