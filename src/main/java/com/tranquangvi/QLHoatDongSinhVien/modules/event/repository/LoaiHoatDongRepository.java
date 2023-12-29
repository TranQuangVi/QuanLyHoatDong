package com.tranquangvi.QLHoatDongSinhVien.modules.event.repository;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.LoaiHoatDongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LoaiHoatDongRepository extends JpaRepository<LoaiHoatDongEntity, String>, JpaSpecificationExecutor<LoaiHoatDongEntity> {
    @Transactional
    @Modifying
    @Query("UPDATE LoaiHoatDongEntity tc SET tc.maLoaiHoatDong = :newMaLoaiHoatDong, tc.tenLoaiHoatDong = :newTenLoaiHoatDong WHERE tc.maLoaiHoatDong = :oldMaLoaiHoatDong")
    void updateLoai(@Param("oldMaLoaiHoatDong") String oldMaLoaiHoatDong,
                       @Param("newMaLoaiHoatDong") String newMaLoaiHoatDong,
                       @Param("newTenLoaiHoatDong") String newTenLoaiHoatDong);
}