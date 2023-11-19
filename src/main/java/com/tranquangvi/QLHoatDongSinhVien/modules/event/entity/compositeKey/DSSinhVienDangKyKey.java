package com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.compositeKey;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class DSSinhVienDangKyKey implements Serializable {

    @Column(name = "mahoatdong")
    private String maHoatDong;
    @Column(name = "maso")
    private String maSo;

    public DSSinhVienDangKyKey() {
    }

    public DSSinhVienDangKyKey(String maHoatDong, String maSo) {
        this.maHoatDong = maHoatDong;
        this.maSo = maSo;
    }

    public String getMaHoatDong() {
        return maHoatDong;
    }

    public void setMaHoatDong(String maHoatDong) {
        this.maHoatDong = maHoatDong;
    }

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }
}
