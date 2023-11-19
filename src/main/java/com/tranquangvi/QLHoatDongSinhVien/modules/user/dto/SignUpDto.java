package com.tranquangvi.QLHoatDongSinhVien.modules.user.dto;

public class SignUpDto {
    private String maSo;
    private String matKhau;
    private String hoTen;
    private String maChucVu;

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

    public SignUpDto(String maSo, String matKhau, String hoTen, String maChucVu) {
        this.maSo = maSo;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.maChucVu = maChucVu;
    }
}
