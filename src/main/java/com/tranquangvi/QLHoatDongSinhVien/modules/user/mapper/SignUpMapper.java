package com.tranquangvi.QLHoatDongSinhVien.modules.user.mapper;

import com.tranquangvi.QLHoatDongSinhVien.modules.user.mapper.EntityMapper;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.dto.SignUpDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.entity.TaiKhoanEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SignUpMapper extends EntityMapper<SignUpDto, TaiKhoanEntity> {
}
