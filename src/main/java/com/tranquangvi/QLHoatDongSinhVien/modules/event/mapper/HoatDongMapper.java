package com.tranquangvi.QLHoatDongSinhVien.modules.event.mapper;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.HoatDongDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.HoatDongEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HoatDongMapper extends EntityMapper<HoatDongDto, HoatDongEntity> {
}