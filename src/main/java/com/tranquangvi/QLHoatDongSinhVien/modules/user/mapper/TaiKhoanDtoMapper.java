package com.tranquangvi.QLHoatDongSinhVien.modules.user.mapper;

import com.tranquangvi.QLHoatDongSinhVien.modules.user.dto.SignUpDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.dto.TaiKhoanDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.entity.TaiKhoanEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface TaiKhoanDtoMapper extends EntityMapper<TaiKhoanDto, TaiKhoanEntity> {
}