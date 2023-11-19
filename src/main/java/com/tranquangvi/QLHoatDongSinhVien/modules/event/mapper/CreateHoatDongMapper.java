package com.tranquangvi.QLHoatDongSinhVien.modules.event.mapper;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.CreateHoatDongDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.HoatDongEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateHoatDongMapper extends EntityMapper<CreateHoatDongDto, HoatDongEntity>{
}
