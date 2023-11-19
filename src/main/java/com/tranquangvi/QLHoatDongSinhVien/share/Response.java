package com.tranquangvi.QLHoatDongSinhVien.share;

import io.swagger.v3.core.util.Json;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    public String status;
    public Json message;

    public Response(String status, Json message) {
        this.status = status;
        this.message = message;
    }

    public Response() {
    }
}
