package com.tranquangvi.QLHoatDongSinhVien.modules.user.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "chucvu")
public class ChucVuEntity {
    @Id
    @Column( name = "machucvu")
    private String maChucVu;
    @Column( name = "tenchucvu")
    private String tenChucVu;

    @ManyToMany(mappedBy = "chucvus")
    private Set<TaiKhoanEntity> taikhoans = new HashSet<>();
    public String getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(String maChucVu) {
        this.maChucVu = maChucVu;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    public ChucVuEntity(String maChucVu, String tenChucVu) {
        this.maChucVu = maChucVu;
        this.tenChucVu = tenChucVu;
    }

    public ChucVuEntity() {
    }
}
