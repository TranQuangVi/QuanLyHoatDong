package com.tranquangvi.QLHoatDongSinhVien.modules.event.dto;

public class SearchDto {
    public String key;
    public String value;

    public SearchDto() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public SearchDto(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
