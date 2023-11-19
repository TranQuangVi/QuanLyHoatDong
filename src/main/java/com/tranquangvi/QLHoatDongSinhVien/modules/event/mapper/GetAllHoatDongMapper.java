package com.tranquangvi.QLHoatDongSinhVien.modules.event.mapper;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.GetAllHoatDongDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.HoatDongEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetAllHoatDongMapper extends EntityMapper<GetAllHoatDongDto, HoatDongEntity>{
}
