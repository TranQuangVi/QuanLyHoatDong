package com.tranquangvi.QLHoatDongSinhVien.modules.event.repository;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.NoiDungToChucDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.NoiDungToChucEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoiDungToChucRepository extends JpaRepository<NoiDungToChucEntity, String> {
    @Query("SELECT e FROM NoiDungToChucEntity e WHERE e.hoatDong.maHoatDong = ?1")
    List<NoiDungToChucEntity> findByMaHoatDong(String maHoatDong);
}