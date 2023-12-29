package com.tranquangvi.QLHoatDongSinhVien.modules.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

public class CTNoiDungToChucDto {
    private String vaiTro;
    private String linkBaiTrinhBay;
    private Integer thoiLuongTrinhBay;
    private String qua;
    private String ghiChu;
    private String tenTaiKhoan;
    private String maTaiKhoan;

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public CTNoiDungToChucDto(String vaiTro, String linkBaiTrinhBay, Integer thoiLuongTrinhBay, String qua, String ghiChu, String tenTaiKhoan, String maTaiKhoan) {
        this.vaiTro = vaiTro;
        this.linkBaiTrinhBay = linkBaiTrinhBay;
        this.thoiLuongTrinhBay = thoiLuongTrinhBay;
        this.qua = qua;
        this.ghiChu = ghiChu;
        this.tenTaiKhoan = tenTaiKhoan;
        this.maTaiKhoan = maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public CTNoiDungToChucDto() {
    }

    public CTNoiDungToChucDto(String vaiTro, String linkBaiTrinhBay, Integer thoiLuongTrinhBay, String qua, String ghiChu, String tenTaiKhoan) {
        this.vaiTro = vaiTro;
        this.linkBaiTrinhBay = linkBaiTrinhBay;
        this.thoiLuongTrinhBay = thoiLuongTrinhBay;
        this.qua = qua;
        this.ghiChu = ghiChu;
        this.tenTaiKhoan = tenTaiKhoan;
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

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }
}
