package com.tranquangvi.QLHoatDongSinhVien.modules.event.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tieuchi")
public class TieuChiEntity {

    @Id
    @Column( name = "matieuchi")
    private String maTieuChi;
    @Column( name = "tentieuchi")
    private String tenTieuChi;

//    @OneToMany(mappedBy = "tieuchi", cascade = CascadeType.ALL)
//    private List<HoatDongEntity> hoatdongs;

    public TieuChiEntity(String maTieuChi, String tenTieuChi) {
        this.maTieuChi = maTieuChi;
        this.tenTieuChi = tenTieuChi;
    }

    public TieuChiEntity() {
    }

    public String getMaTieuChi() {
        return maTieuChi;
    }

    public void setMaTieuChi(String maTieuChi) {
        this.maTieuChi = maTieuChi;
    }

    public String getTenTieuChi() {
        return tenTieuChi;
    }

    public void setTenTieuChi(String tenTieuChi) {
        this.tenTieuChi = tenTieuChi;
    }
}
