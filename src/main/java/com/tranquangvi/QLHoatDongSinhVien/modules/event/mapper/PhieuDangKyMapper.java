package com.tranquangvi.QLHoatDongSinhVien.modules.event.mapper;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.NoiDungToChucDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.PhieuDangKyDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.NoiDungToChucEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.PhieuDangKyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhieuDangKyMapper extends EntityMapper<PhieuDangKyDto, PhieuDangKyEntity>{
}
