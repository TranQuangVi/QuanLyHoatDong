package com.tranquangvi.QLHoatDongSinhVien.modules.event.controller;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.*;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.DSSinhVienDangKyEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.service.DSSinhVienDangKyService;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.service.HoatDongService;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.service.NoiDungToChucService;
import com.tranquangvi.QLHoatDongSinhVien.share.Response;
import io.swagger.v3.core.util.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/hoat-dong")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HoatDongController {
    @Autowired
    private HoatDongService hoatDongService;
    @Autowired
    private NoiDungToChucService noiDungToChucService;
    @Autowired
    private DSSinhVienDangKyService dsSinhVienDangKyService;

    //@PreAuthorize("isAuthenticated()")
    @GetMapping()
    public ResponseEntity<Page<GetAllHoatDongDto>> getAll(Pageable pageable) {
        Page<GetAllHoatDongDto> page = hoatDongService.getAll(pageable);
        return ResponseEntity.ok().body(page);
    }

    @PostMapping()
    public ResponseEntity<Void> save(@RequestBody CreateHoatDongDto hoatDongDto) {
        hoatDongService.add(hoatDongDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HoatDongDto> findById(@PathVariable("id") String id) {
        HoatDongDto hoatDong = hoatDongService.findById(id);
        return ResponseEntity.ok().body(hoatDong);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        Optional.ofNullable(hoatDongService.findById(id))
                .orElseThrow(() -> {
                    return new RuntimeException();
                });
        hoatDongService.deleteById(id);
        return ResponseEntity.ok().build();
    }

//    @GetMapping("/page-query")
//    public ResponseEntity<Page<HoatDongDto>> pageQuery(HoatDongDto hoatDongDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
//        Page<HoatDongDto> hoatDongPage = hoatDongService.findByCondition(hoatDongDto, pageable);
//        return ResponseEntity.ok(hoatDongPage);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody HoatDongDto hoatDongDto, @PathVariable("id") String id) {
        hoatDongService.update(hoatDongDto, id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/noi-dung/{maHoatDong}")
    public ResponseEntity<List<NoiDungToChucDto>> getByHoatdongId(@PathVariable("maHoatDong") String maHoatDong) {
        List<NoiDungToChucDto> result = noiDungToChucService.getByMaHoatDong(maHoatDong);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/noi-dung/{id}")
    public ResponseEntity deleteNoiDung(@PathVariable("id") String id) {
        noiDungToChucService.delete(id);
        return ResponseEntity.ok().build();

    }

    @PutMapping("/noi-dung")
    public ResponseEntity updateNoiDung(@RequestBody NoiDungToChucDto dto) {
        //dto.setNoiDung("abc");
        noiDungToChucService.update(dto);
        return ResponseEntity.ok().build();

    }

    @PostMapping("/noi-dung")
    public ResponseEntity<NoiDungToChucDto> insert(@RequestBody NoiDungToChucDto dto) {
        if (dto.getTenNoiDung() != "") {
            String maNoiDung = removeVietnameseDiacritics(dto.getTenNoiDung()).replaceAll("\\s+", "").toUpperCase() + dto.getMaHoatDong().toUpperCase();
            dto.setMaNoiDung(maNoiDung);
            noiDungToChucService.add(dto);
            return ResponseEntity.ok().build();
        }
        throw new RuntimeException("Tên nội dung không được bỏ trống!");
        // return ResponseEntity.ok().build();
    }

    public static String removeVietnameseDiacritics(String input) {
        // Chuyển các ký tự tiếng Việt có dấu thành không dấu
        String result = input.replaceAll("đ", "d");
        result = result.replaceAll("Đ", "D");

        String normalized = java.text.Normalizer.normalize(result, java.text.Normalizer.Form.NFD);
        return normalized.replaceAll("[^\\p{ASCII}]", "");
    }

    @GetMapping("/danh-sach-dang-ky/{maHoatDong}")
    public ResponseEntity<List<DSSinhVienDangKyEntity>> getDSDangKy(@PathVariable("maHoatDong") String maHoatDong) {
        return ResponseEntity.ok(dsSinhVienDangKyService.getDSDangKy(maHoatDong));
    }

    @PostMapping("/dang-ky")
    public ResponseEntity postSinhVienDangKy(@RequestBody SinhVienDangKyDto dto) {

        dsSinhVienDangKyService.dangKyHoatDong(dto);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/diem-danh")
    public ResponseEntity<?> postDiemDanh(@RequestBody SinhVienDangKyDto dto) {

        dsSinhVienDangKyService.diemDanh(dto);
        return new ResponseEntity<>("Điểm danh thành công thành công!", HttpStatus.OK);
    }
}
