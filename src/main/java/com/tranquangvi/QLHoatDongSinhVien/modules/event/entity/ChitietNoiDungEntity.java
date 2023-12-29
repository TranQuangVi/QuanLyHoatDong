package com.tranquangvi.QLHoatDongSinhVien.modules.event.entity;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.compositeKey.ChiTietNoiDungKey;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.entity.TaiKhoanEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "chitietnoidung")
public class ChitietNoiDungEntity {
    @EmbeddedId
    private ChiTietNoiDungKey key;
    @ManyToOne
    @MapsId("manoidung")
    @JoinColumn(name = "manoidung")
    private NoiDungToChucEntity noiDungToChuc;
    @ManyToOne
    @MapsId("maso")
    @JoinColumn(name = "maso")
    private TaiKhoanEntity taiKhoan;
    @Column(name = "vaitro")
    private String vaiTro;
    @Column(name = "linkbaitrinhbay")
    private String linkBaiTrinhBay;
    @Column(name = "thoiluongtrinhbay")
    private Integer thoiLuongTrinhBay;
    @Column(name = "qua")
    private String qua;
    @Column(name = "ghichu")
    private String ghiChu;

    public ChitietNoiDungEntity() {
    }

    public ChiTietNoiDungKey getKey() {
        return key;
    }

    public void setKey(ChiTietNoiDungKey key) {
        this.key = key;
    }

    public NoiDungToChucEntity getNoiDungToChuc() {
        return noiDungToChuc;
    }

    public void setNoiDungToChuc(NoiDungToChucEntity noiDungToChuc) {
        this.noiDungToChuc = noiDungToChuc;
    }

    public TaiKhoanEntity getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoanEntity taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getLinkBaiTrinhBay() {
        return linkBaiTrinhBay;
    }

    public void setLinkBaiTrinhBay(String linkBaiTrinhBay) {
        this.linkBaiTrinhBay = linkBaiTrinhBay;
    }

    public Integer getThoiLuongTrinhBay() {
        return thoiLuongTrinhBay;
    }

    public void setThoiLuongTrinhBay(Integer thoiLuongTrinhBay) {
        this.thoiLuongTrinhBay = thoiLuongTrinhBay;
    }

    public String getQua() {
        return qua;
    }

    public void setQua(String qua) {
        this.qua = qua;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public ChitietNoiDungEntity(ChiTietNoiDungKey key, NoiDungToChucEntity noiDungToChuc, TaiKhoanEntity taiKhoan, String vaiTro, String linkBaiTrinhBay, Integer thoiLuongTrinhBay, String qua, String ghiChu) {
        this.key = key;
        this.noiDungToChuc = noiDungToChuc;
        this.taiKhoan = taiKhoan;
        this.vaiTro = vaiTro;
        this.linkBaiTrinhBay = linkBaiTrinhBay;
        this.thoiLuongTrinhBay = thoiLuongTrinhBay;
        this.qua = qua;
        this.ghiChu = ghiChu;
    }
}
