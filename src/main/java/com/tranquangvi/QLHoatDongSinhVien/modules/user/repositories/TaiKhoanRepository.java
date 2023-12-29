package com.tranquangvi.QLHoatDongSinhVien.modules.user.repositories;

import com.tranquangvi.QLHoatDongSinhVien.modules.user.entity.TaiKhoanEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoanEntity, String> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO chitietchucvu (maSo, maChucVu)" + "VALUE (?1, ?2)", nativeQuery = true)
    void addRoleToUser(String maSo, String maChucVu);

    @Query(value = "SELECT cv.machucvu FROM chucvu cv INNER JOIN chitietchucvu ct ON cv.machucvu = ct.machucvu WHERE ct.maSo =?1", nativeQuery = true)
    String[] getRolesOfUser(String maSo);

    @Query(value = "SELECT tk.maso FROM taikhoan tk INNER JOIN chitietchucvu ct ON tk.maso = ct.maso WHERE ct.machucvu = ?1 ", nativeQuery = true)
    String[] getAllUserByRole(String role);
}
