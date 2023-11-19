package com.tranquangvi.QLHoatDongSinhVien.modules.event.mapper;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.HoatDongDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.NoiDungToChucDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.HoatDongEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.NoiDungToChucEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoiDungToChucMapper extends EntityMapper<NoiDungToChucDto, NoiDungToChucEntity>{
}
