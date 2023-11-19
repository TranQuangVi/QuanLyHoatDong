package com.tranquangvi.QLHoatDongSinhVien.modules.user.controller;

import com.tranquangvi.QLHoatDongSinhVien.modules.user.dto.ListTaiKhoanByChucVuDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.entity.ChucVuEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.services.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chuc-vu")
@CrossOrigin(origins = "*")
public class ChucVuController {
    @Autowired
    private ChucVuService chucVuService;

    @PostMapping
    public ResponseEntity postChucVu(@RequestBody ChucVuEntity chucVu){
        chucVuService.addChucVu(chucVu);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ChucVuEntity>> getAllChucVu(){
        List<ChucVuEntity> list=chucVuService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity getChucVuById(String id)
    {
        //TODO:
        return ResponseEntity.ok().build();
    }
}
