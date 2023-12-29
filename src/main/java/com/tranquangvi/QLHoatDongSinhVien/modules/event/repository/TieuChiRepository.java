package com.tranquangvi.QLHoatDongSinhVien.modules.event.repository;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.TieuChiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TieuChiRepository extends JpaRepository<TieuChiEntity, String> {

    @Transactional
    @Modifying
    @Query("UPDATE TieuChiEntity tc SET tc.maTieuChi = :newMaTieuChi, tc.tenTieuChi = :newTenTieuChi WHERE tc.maTieuChi = :oldMaTieuChi")
    void updateTieuChi(@Param("oldMaTieuChi") String oldMaTieuChi,
                       @Param("newMaTieuChi") String newMaTieuChi,
                       @Param("newTenTieuChi") String newTenTieuChi);
}
