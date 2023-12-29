package com.tranquangvi.QLHoatDongSinhVien.modules.event.mapper;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.PhieuDangKyGetAllDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.PhieuDangKyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhieuDangKyGetAllMapper extends EntityMapper<PhieuDangKyGetAllDto, PhieuDangKyEntity>{
}
