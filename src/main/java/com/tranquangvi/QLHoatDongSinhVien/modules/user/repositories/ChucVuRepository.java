package com.tranquangvi.QLHoatDongSinhVien.modules.user.repositories;

import com.tranquangvi.QLHoatDongSinhVien.modules.user.entity.ChucVuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVuEntity, String> {
}
