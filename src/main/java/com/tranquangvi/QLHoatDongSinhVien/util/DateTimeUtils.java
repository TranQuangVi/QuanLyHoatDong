package com.tranquangvi.QLHoatDongSinhVien.util;

import java.time.LocalDateTime;

public class DateTimeUtils {
    public static Integer getMonth(LocalDateTime dateTime) {
        return dateTime.getMonthValue();
    }

    public static Integer getYear(LocalDateTime dateTime) {
        return dateTime.getYear();
    }
}
