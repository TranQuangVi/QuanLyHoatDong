package com.tranquangvi.QLHoatDongSinhVien.modules.event.mapper;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.HoatDongAcceptedDTO;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.HoatDongEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HoatDongAcceptedMapper extends EntityMapper<HoatDongAcceptedDTO, HoatDongEntity> {
}