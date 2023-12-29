package com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.compositeKey;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class ChiTietNoiDungKey implements Serializable {

    @Column(name = "manoidung")
    private String maNoiDung;
    @Column(name = "maso")
    private String maSo;

    public String getMaNoiDung() {
        return maNoiDung;
    }

    public void setMaNoiDung(String maNoiDung) {
        this.maNoiDung = maNoiDung;
    }

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }
    public ChiTietNoiDungKey() {
    }
    public ChiTietNoiDungKey(String maNoiDung, String maSo) {
        this.maNoiDung = maNoiDung;
        this.maSo = maSo;
    }
}
