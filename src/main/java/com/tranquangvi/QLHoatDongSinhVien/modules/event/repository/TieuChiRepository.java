package com.tranquangvi.QLHoatDongSinhVien.modules.event.repository;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.TieuChiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TieuChiRepository extends JpaRepository<TieuChiEntity, String> {
}
