package com.tranquangvi.QLHoatDongSinhVien.modules.event.controller;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.LoaihoatdongDTO;

import java.util.Collections;
import java.util.List;

class LoaiHoatDongBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static LoaihoatdongDTO getDto() {
        LoaihoatdongDTO dto = new LoaihoatdongDTO();
        dto.setMaLoaiHoatDong("1");
        return dto;
    }
}
