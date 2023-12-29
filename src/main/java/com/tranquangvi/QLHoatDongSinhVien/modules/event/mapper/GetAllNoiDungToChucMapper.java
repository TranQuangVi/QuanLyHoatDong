package com.tranquangvi.QLHoatDongSinhVien.modules.event.mapper;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.GetAllNoiDungToChucDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.HoatDongAcceptedDTO;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.HoatDongEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.NoiDungToChucEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetAllNoiDungToChucMapper extends EntityMapper<GetAllNoiDungToChucDto, NoiDungToChucEntity> {
}