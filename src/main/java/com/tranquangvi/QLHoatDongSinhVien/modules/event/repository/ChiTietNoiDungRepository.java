package com.tranquangvi.QLHoatDongSinhVien.modules.event.repository;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.ChitietNoiDungEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.DSSinhVienDangKyEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.compositeKey.ChiTietNoiDungKey;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.compositeKey.DSSinhVienDangKyKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Repository
public interface ChiTietNoiDungRepository extends JpaRepository<ChitietNoiDungEntity, ChiTietNoiDungKey> {
    @Query("SELECT e FROM ChitietNoiDungEntity e WHERE e.noiDungToChuc.maNoiDung = ?1")
    List<ChitietNoiDungEntity> findByMaNoiDung(String maNoiDung);

    @Query("SELECT e FROM ChitietNoiDungEntity e WHERE e.noiDungToChuc.maNoiDung = :maNoiDung and e.taiKhoan.maSo=:maSo ")
    Optional<ChitietNoiDungEntity> findByKey(@Param("maNoiDung") String maNoiDung, @Param("maSo") String maSo);


}