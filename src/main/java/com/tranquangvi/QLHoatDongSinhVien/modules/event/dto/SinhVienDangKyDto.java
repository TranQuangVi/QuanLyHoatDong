package com.tranquangvi.QLHoatDongSinhVien.modules.event.dto;

public class SinhVienDangKyDto {
    private String maHoatDong;
    private String jwtToken;

    public String getMaHoatDong() {
        return maHoatDong;
    }

    public void setMaHoatDong(String maHoatDong) {
        this.maHoatDong = maHoatDong;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
