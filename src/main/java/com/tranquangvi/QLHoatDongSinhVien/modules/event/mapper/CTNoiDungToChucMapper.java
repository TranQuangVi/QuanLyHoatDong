package com.tranquangvi.QLHoatDongSinhVien.modules.event.mapper;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.CTNoiDungToChucDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.NoiDungToChucDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.ChitietNoiDungEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.NoiDungToChucEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CTNoiDungToChucMapper extends EntityMapper<CTNoiDungToChucDto, ChitietNoiDungEntity>{
}