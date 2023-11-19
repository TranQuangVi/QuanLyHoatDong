package com.tranquangvi.QLHoatDongSinhVien.modules.event.entity;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.NoiDungToChucDto;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.executable.ValidateOnExecution;
import jakarta.websocket.OnError;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "noidungtochuc")
@Getter
@Setter
public class NoiDungToChucEntity {
    @Id
    @Column( name = "manoidung")
    private String maNoiDung;

    @Column( name = "tennoidung")
    @NotBlank(message = "Tên nội dung đã tồn tại!")
    private String tenNoiDung;

    @Column( name = "thoigianbatdau")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime thoiGianBatDau;

    @Column( name = "thoigianketthuc")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime thoiGianKetThuc;

    @Column( name = "noidung")
    private String noiDung;

    @Column( name = "ghichu")
    private String ghiChu;

    @ManyToOne
    @JoinColumn(name = "mahoatdong")
    private HoatDongEntity hoatDong;

    public NoiDungToChucEntity() {
    }

    public NoiDungToChucEntity(String maNoiDung, String tenNoiDung, LocalDateTime thoiGianBatDau, LocalDateTime thoiGianKetThuc, String noiDung, String ghiChu, HoatDongEntity hoatDong) {
        this.maNoiDung = maNoiDung;
        this.tenNoiDung = tenNoiDung;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.noiDung = noiDung;
        this.ghiChu = ghiChu;
        this.hoatDong = hoatDong;
    }

    public String getMaNoiDung() {
        return maNoiDung;
    }

    public void setMaNoiDung(String maNoiDung) {
        this.maNoiDung = maNoiDung;
    }

    public String getTenNoiDung() {
        return tenNoiDung;
    }

    public void setTenNoiDung(String tenNoiDung) {
        this.tenNoiDung = tenNoiDung;
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

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public HoatDongEntity getHoatDong() {
        return hoatDong;
    }

    public void setHoatDong(HoatDongEntity hoatDong) {
        this.hoatDong = hoatDong;
    }


}
