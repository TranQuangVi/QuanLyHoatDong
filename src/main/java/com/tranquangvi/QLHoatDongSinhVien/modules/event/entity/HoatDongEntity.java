package com.tranquangvi.QLHoatDongSinhVien.modules.event.entity;

import com.tranquangvi.QLHoatDongSinhVien.modules.user.entity.TaiKhoanEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "hoatdong")
@Getter
@Setter
public class HoatDongEntity {
    @Id
    @Column(name = "mahoatdong")
    private String maHoatDong;

    @Column(name = "tenhoatdong")
    private String tenHoatDong;

    @Column(name = "thoigianbatdau", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime thoiGianBatDau;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "thoigianketthuc", nullable = true)
    private LocalDateTime thoiGianKetThuc;

    @Column(name = "diachi")
    private String diaChi;

    @Column(name = "soluongsinhvien")
    private Integer soLuongSinhVien;

    @Column(name = "yeucau")
    private String yeuCau;

    @Column(name = "hinh")
    private String hinh;

    @Column(name = "trangthai", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean trangThai;

    @Column(name = "mota")
    private String moTa;

    @ManyToOne
    @JoinColumn(name = "matieuchi")
    private TieuChiEntity tieuChi;

    @ManyToOne
    @JoinColumn(name = "maloaihoatdong")
    private LoaiHoatDongEntity loaiHoatDong;
    @ManyToOne
    @JoinColumn(name = "maso")
    private TaiKhoanEntity taiKhoan;
//    @OneToMany(mappedBy = "hoatDong")
//    Set<DSSinhVienDangKyEntity> sinhVienDangKys;

    public HoatDongEntity(String maHoatDong, String tenHoatDong, LocalDateTime thoiGianBatDau, LocalDateTime thoiGianKetThuc, String diaChi, Integer soLuongSinhVien, String yeuCau, String hinh, Boolean trangThai, String moTa, TieuChiEntity tieuChi, LoaiHoatDongEntity loaiHoatDong, TaiKhoanEntity taiKhoan) {
        this.maHoatDong = maHoatDong;
        this.tenHoatDong = tenHoatDong;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.diaChi = diaChi;
        this.soLuongSinhVien = soLuongSinhVien;
        this.yeuCau = yeuCau;
        this.hinh = hinh;
        this.trangThai = trangThai;
        this.moTa = moTa;
        this.tieuChi = tieuChi;
        this.loaiHoatDong = loaiHoatDong;
        this.taiKhoan=taiKhoan;
    }

    public HoatDongEntity() {
    }

    public TaiKhoanEntity getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoanEntity taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMaHoatDong() {
        return maHoatDong;
    }

    public void setMaHoatDong(String maHoatDong) {
        this.maHoatDong = maHoatDong;
    }

    public String getTenHoatDong() {
        return tenHoatDong;
    }

    public void setTenHoatDong(String tenHoatDong) {
        this.tenHoatDong = tenHoatDong;
    }

    public LocalDateTime getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(LocalDateTime thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public LocalDateTime getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(LocalDateTime thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Integer getSoLuongSinhVien() {
        return soLuongSinhVien;
    }

    public void setSoLuongSinhVien(Integer soLuongSinhVien) {
        this.soLuongSinhVien = soLuongSinhVien;
    }

    public String getYeuCau() {
        return yeuCau;
    }

    public void setYeuCau(String yeuCau) {
        this.yeuCau = yeuCau;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public TieuChiEntity getTieuChi() {
        return tieuChi;
    }

    public void setTieuChi(TieuChiEntity tieuChi) {
        this.tieuChi = tieuChi;
    }

    public LoaiHoatDongEntity getLoaiHoatDong() {
        return loaiHoatDong;
    }

    public void setLoaiHoatDong(LoaiHoatDongEntity loaiHoatDong) {
        this.loaiHoatDong = loaiHoatDong;
    }


}
