package com.tranquangvi.QLHoatDongSinhVien.modules.event.repository;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.DSSinhVienDangKyEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.HoatDongEntity;
import com.tranquangvi.QLHoatDongSinhVien.util.DateTimeUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HoatDongRepository extends JpaRepository<HoatDongEntity, String>, JpaSpecificationExecutor<HoatDongEntity> {
    @Query("SELECT e FROM HoatDongEntity e WHERE e.trangThai = ?1")
    List<HoatDongEntity> findByTrangThai(String trangThai);
    @Query("SELECT e.hoatDong FROM DSSinhVienDangKyEntity e WHERE e.taiKhoan.maSo = ?1 and e.hoatDong.trangThai='Đang triển khai'")
    List<HoatDongEntity> dsSinhVienDk(String maSo);
    @Query("SELECT e.hoatDong FROM DSSinhVienDangKyEntity e WHERE e.taiKhoan.maSo = ?1 and e.gioDiemDanh!=null ")
    List<HoatDongEntity> dsSinhVienThamGia(String maSo);
    @Query("SELECT e FROM HoatDongEntity e WHERE e.taiKhoan.maSo = ?1")
    List<HoatDongEntity> findByMaSo(String maSo);

    //    @Query("SELECT e FROM HoatDongEntity e WHERE DateTimeUtils.getMonth(e.thoiGianBatDau) = :mm AND DateTimeUtils.getYear(e.thoiGianBatDau) = :yyyy")
//    List<HoatDongEntity> findByMonth(@Param("mm") Integer mm, @Param("yyyy") Integer yyyy);
    @Query("SELECT e FROM HoatDongEntity e WHERE e.tieuChi.maTieuChi = ?1 and e.trangThai='Đang triển khai'")
    List<HoatDongEntity> findByTieuChi(String maTieuChi);
    @Query("SELECT e FROM HoatDongEntity e WHERE e.loaiHoatDong.maLoaiHoatDong = ?1 and e.trangThai='Đang triển khai'")
    List<HoatDongEntity> findByLoai(String maLoai);
}