package com.tranquangvi.QLHoatDongSinhVien.modules.event.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoaihoatdongDTO {
    private String maLoaiHoatDong;
    private String tenLoaiHoatDong;

    public String getMaLoaiHoatDong() {
        return maLoaiHoatDong;
    }

    public void setMaLoaiHoatDong(String maLoaiHoatDong) {
        this.maLoaiHoatDong = maLoaiHoatDong;
    }

    public String getTenLoaiHoatDong() {
        return tenLoaiHoatDong;
    }

    public void setTenLoaiHoatDong(String tenLoaiHoatDong) {
        this.tenLoaiHoatDong = tenLoaiHoatDong;
    }
}
