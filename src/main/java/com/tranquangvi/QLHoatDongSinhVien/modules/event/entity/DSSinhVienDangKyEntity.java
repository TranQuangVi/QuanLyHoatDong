package com.tranquangvi.QLHoatDongSinhVien.modules.event.entity;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.compositeKey.DSSinhVienDangKyKey;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.entity.TaiKhoanEntity;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "dssinhviendangky")
public class DSSinhVienDangKyEntity {
    @EmbeddedId
    private DSSinhVienDangKyKey key;
    @ManyToOne
    @MapsId("mahoatdong")
    @JoinColumn(name = "mahoatdong")
    private HoatDongEntity hoatDong;
    @ManyToOne
    @MapsId("maso")
    @JoinColumn(name = "maso")
    private TaiKhoanEntity taiKhoan;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "ngaydangky")
    private Date ngayDangKy;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "giodiemdanh")
    private Date gioDiemDanh;

    public DSSinhVienDangKyEntity() {
    }

    public DSSinhVienDangKyEntity(DSSinhVienDangKyKey key, HoatDongEntity hoatDong, TaiKhoanEntity taiKhoan, Date ngayDangKy, Date gioDiemDanh) {
        this.key = key;
        this.hoatDong = hoatDong;
        this.taiKhoan = taiKhoan;
        this.ngayDangKy = ngayDangKy;
        this.gioDiemDanh = gioDiemDanh;
    }

    public DSSinhVienDangKyKey getKey() {
        return key;
    }

    public void setKey(DSSinhVienDangKyKey key) {
        this.key = key;
    }

    public HoatDongEntity getHoatDong() {
        return hoatDong;
    }

    public void setHoatDong(HoatDongEntity hoatDong) {
        this.hoatDong = hoatDong;
    }

    public TaiKhoanEntity getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoanEntity taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public Date getGioDiemDanh() {
        return gioDiemDanh;
    }

    public void setGioDiemDanh(Date gioDiemDanh) {
        this.gioDiemDanh = gioDiemDanh;
    }
}
