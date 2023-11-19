package com.tranquangvi.QLHoatDongSinhVien.modules.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "taikhoan")
public class TaiKhoanEntity {
    @Id
    @Column( name = "maso")
    private String maSo;

    @Column( name = "matkhau")
    private String matKhau;

    @Column( name = "hoten")
    private String hoTen;

    @Column( name = "gioitinh")
    private Boolean gioiTinh;

    @Column( name = "ngaysinh")
   // @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySinh;

    @Column( name = "email")
    private String email;

    @Column( name = "sdt")
    private Character sdt;

    @Column( name = "diachi")
    private String diaChi;

    @Column( name = "hinh")
    private String hinh;
    @ManyToMany
    @JoinTable(name ="chitietchucvu",
            joinColumns = @JoinColumn(name ="maso"),
            inverseJoinColumns = @JoinColumn(name = "machucvu"))
    private Set<ChucVuEntity> chucvus = new HashSet<>();
//    @ManyToOne
//    @JoinColumn(name = "machucvu")
//    private ChucVuEntity chucVu;

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

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getSdt() {
        return sdt;
    }

    public void setSdt(Character sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public TaiKhoanEntity() {
    }

    public TaiKhoanEntity(String maSo, String matKhau, String hoTen, Boolean gioiTinh, Date ngaySinh, String email, Character sdt, String diaChi, String hinh) {
        this.maSo = maSo;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.hinh = hinh;
    }
}
