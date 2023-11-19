package com.tranquangvi.QLHoatDongSinhVien.modules.event.mapper;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.LoaihoatdongDTO;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.LoaiHoatDongEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LoaiHoatDongMapper extends EntityMapper<LoaihoatdongDTO, LoaiHoatDongEntity> {

}