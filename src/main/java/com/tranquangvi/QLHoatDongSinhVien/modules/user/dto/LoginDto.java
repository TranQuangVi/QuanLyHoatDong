package com.tranquangvi.QLHoatDongSinhVien.modules.user.dto;

public class LoginDto {
    private String maSo;
    private String matKhau;

    public LoginDto(String maSo, String matKhau) {
        this.maSo = maSo;
        this.matKhau = matKhau;
    }

    public LoginDto() {
    }

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}
