package com.tranquangvi.QLHoatDongSinhVien.modules.event.controller;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.TieuChiEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.service.TieuChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tieuchi")
@CrossOrigin(origins="http://localhost:4200")

public class TieuChiController {
    @Autowired
    private TieuChiService tieuChiService;
    @PreAuthorize("isAuthenticated()")
    @GetMapping()
    public ResponseEntity<Page<TieuChiEntity>> getAll(Pageable pageable) {
        Page<TieuChiEntity> page = tieuChiService.getAll(pageable);
        return ResponseEntity.ok().body(page);
    }

    @PostMapping()
    public ResponseEntity<TieuChiEntity> insert(String maTieuChi, String tenTieuChi){
        TieuChiEntity tieuChi = new TieuChiEntity();
        tieuChi.setMaTieuChi(maTieuChi);
        tieuChi.setTenTieuChi(tenTieuChi);
        tieuChiService.save(tieuChi);
        return ResponseEntity.ok().body(tieuChi);
    }

    @GetMapping("/getById")
    public ResponseEntity<TieuChiEntity> getById(String id){
        TieuChiEntity tieuChi = tieuChiService.getById(id);
        return ResponseEntity.ok().body(tieuChi);
    }

}
