package com.tranquangvi.QLHoatDongSinhVien.modules.event.controller;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.LoaihoatdongDTO;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.LoaiHoatDongEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.TieuChiEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.mapper.LoaiHoatDongMapper;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.service.LoaiHoatDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/loai-hoat-dong")
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class LoaiHoatDongController {
    @Autowired
    private LoaiHoatDongService loaiHoatDongService;
    @Autowired
    private LoaiHoatDongMapper loaiHoatDongMapper;
    @GetMapping()
    public ResponseEntity<Page<LoaiHoatDongEntity>> getAll(Pageable pageable) {
        Page<LoaiHoatDongEntity> page = loaiHoatDongService.getAll(pageable);
        return ResponseEntity.ok().body(page);
    }
    @PostMapping
    public ResponseEntity save(@RequestBody LoaihoatdongDTO dto) {
        try{
            loaiHoatDongService.save(loaiHoatDongMapper.toEntity(dto));
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e);

        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<LoaiHoatDongEntity> findById(@PathVariable("id") String id) {

        LoaiHoatDongEntity loaiHoatDong = loaiHoatDongService.getById(id);
        return ResponseEntity.ok(loaiHoatDong);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {
        try{
            loaiHoatDongService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e);

        }

    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody LoaihoatdongDTO dto, @PathVariable("id") String id) {
        try{
            loaiHoatDongService.update(loaiHoatDongMapper.toEntity(dto), id);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e);

        }

    }


}
