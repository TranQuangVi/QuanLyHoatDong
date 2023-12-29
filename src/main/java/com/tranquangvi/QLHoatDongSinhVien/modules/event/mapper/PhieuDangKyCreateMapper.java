package com.tranquangvi.QLHoatDongSinhVien.modules.event.mapper;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.PhieuDangKyCreateDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.PhieuDangKyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhieuDangKyCreateMapper extends EntityMapper<PhieuDangKyCreateDto, PhieuDangKyEntity>{
}
