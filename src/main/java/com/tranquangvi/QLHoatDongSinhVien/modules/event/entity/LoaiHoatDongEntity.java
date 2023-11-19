package com.tranquangvi.QLHoatDongSinhVien.modules.event.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "loaihoatdong")
@Getter
@Setter
public class LoaiHoatDongEntity {
    @Id
    @Column( name = "maloaihoatdong")
    private String maLoaiHoatDong;
    @Column(name ="tenloaihoatdong")
    private String tenLoaiHoatDong;

    public LoaiHoatDongEntity(String maLoaiHoatDong, String tenLoaiHoatDong) {
        this.maLoaiHoatDong = maLoaiHoatDong;
        this.tenLoaiHoatDong = tenLoaiHoatDong;
    }

    public LoaiHoatDongEntity() {
    }

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
