package com.tranquangvi.QLHoatDongSinhVien.modules.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
    private String gioiTinh;

    @Column( name = "ngaysinh")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date ngaySinh;

    @Column( name = "email")
    private String email;

    @Column( name = "sdt")
    private String sdt;

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

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
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

    public TaiKhoanEntity(String maSo, String matKhau, String hoTen, String gioiTinh, Date ngaySinh, String email, String sdt, String diaChi, String hinh) {
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
