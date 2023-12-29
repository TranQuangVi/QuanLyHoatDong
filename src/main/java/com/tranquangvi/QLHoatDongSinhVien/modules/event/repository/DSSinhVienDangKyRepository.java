package com.tranquangvi.QLHoatDongSinhVien.modules.event.repository;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.DSSinhVienDangKyEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.NoiDungToChucEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.compositeKey.DSSinhVienDangKyKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DSSinhVienDangKyRepository extends JpaRepository<DSSinhVienDangKyEntity, DSSinhVienDangKyKey> {
    @Query("SELECT e FROM DSSinhVienDangKyEntity e WHERE e.hoatDong.maHoatDong = ?1")
    List<DSSinhVienDangKyEntity> findByMaHoatDong(String maHoatDong);
}