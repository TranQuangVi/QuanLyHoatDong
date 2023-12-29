package com.tranquangvi.QLHoatDongSinhVien.modules.event.controller;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.PhieuDangKyCreateDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.PhieuDangKyDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.PhieuDangKyGetAllDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.PhieuDangKyEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.service.HoatDongService;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.service.NoiDungToChucService;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.service.PheDuyetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/phieu-phe-duyet")
@CrossOrigin(origins = "http://localhost:4200")

public class PhieuPheDuyetController {
    @Autowired
    private PheDuyetService pheDuyetService;
//    @Autowired
//    private HoatDongService hoatDongService;
@Autowired
private NoiDungToChucService noiDungToChucService;
    @GetMapping
    public ResponseEntity getAll() {
        try {
            List<PhieuDangKyGetAllDto> list = pheDuyetService.findAll();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }

    }
    @GetMapping("/hoat-dong/{maHoatDong}")
    public ResponseEntity findById(@PathVariable("maHoatDong") String maHoatDong) {
        try {
            return ResponseEntity.ok(noiDungToChucService.getHoatDongAccepted((maHoatDong)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
//    @GetMapping("/{maPhieu}")
//    public ResponseEntity findById(String maPhieu) {
//        try {
//            return ResponseEntity.ok(pheDuyetService.findById(maPhieu));
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(e);
//        }
//    }

    @PostMapping()
    public ResponseEntity add(@RequestBody PhieuDangKyCreateDto dto, @RequestHeader HttpHeaders headers) {
        try {
            final String authHeader = headers.getFirst("Authorization");
            String jwt = authHeader.substring(7);
            pheDuyetService.add(dto, jwt);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
    @PutMapping("/duyet-phieu/{maPhieu}")
    public ResponseEntity putTrangThaiDuyet(@PathVariable("maPhieu") String maPhieu, String trangThai){
        try{
            pheDuyetService.putTrangThaiDuyet(maPhieu,trangThai);

            return ResponseEntity.ok().build();
        }
        catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Đã sảy ra lỗi không xác định!");
        }
    }
}
