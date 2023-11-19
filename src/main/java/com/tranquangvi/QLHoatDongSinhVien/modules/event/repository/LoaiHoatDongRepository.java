package com.tranquangvi.QLHoatDongSinhVien.modules.event.repository;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.LoaiHoatDongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiHoatDongRepository extends JpaRepository<LoaiHoatDongEntity, String>, JpaSpecificationExecutor<LoaiHoatDongEntity> {
}