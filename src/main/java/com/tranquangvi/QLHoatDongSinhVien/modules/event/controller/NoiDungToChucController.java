package com.tranquangvi.QLHoatDongSinhVien.modules.event.controller;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.NoiDungToChucDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.service.NoiDungToChucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/hoatdong/noidung")
//@CrossOrigin(origins="http://localhost:4200")
public class NoiDungToChucController {
    @Autowired
    private NoiDungToChucService noiDungToChucService;

    //GetAll
    //@GetMapping
    public ResponseEntity<List<NoiDungToChucDto>> getAll(){
        List<NoiDungToChucDto> result = noiDungToChucService.getAll();
        return ResponseEntity.ok(result);
    }

    //GetByHoatDongId
    @GetMapping("{maHoatDong}")
    public ResponseEntity<List<NoiDungToChucDto>> getByHoatdongId(@PathVariable("maHoatDong") String maHoatDong){
        List<NoiDungToChucDto> result = noiDungToChucService.getByMaHoatDong(maHoatDong);
        return ResponseEntity.ok(result);
    }
    //GetById
    //Post
    @PostMapping
    public ResponseEntity<NoiDungToChucDto> insert(@RequestBody NoiDungToChucDto dto){
        noiDungToChucService.add(dto);
        return ResponseEntity.ok().build();
    }
    //Put
    //Delete
}
