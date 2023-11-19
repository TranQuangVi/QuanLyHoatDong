package com.tranquangvi.QLHoatDongSinhVien.modules.event.controller;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.HoatDongDto;

import java.util.Collections;
import java.util.List;

 class HoatDongBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static HoatDongDto getDto() {
        HoatDongDto dto = new HoatDongDto();
        dto.setMaHoatDong("1");
        return dto;
    }
}
