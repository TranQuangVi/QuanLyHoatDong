package com.tranquangvi.QLHoatDongSinhVien.modules.event.controller;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.*;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.DSSinhVienDangKyEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.entity.compositeKey.ChiTietNoiDungKey;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.service.DSSinhVienDangKyService;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.service.HoatDongService;
import com.tranquangvi.QLHoatDongSinhVien.modules.event.service.NoiDungToChucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.sasl.AuthenticationException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping()
    public ResponseEntity<Page<GetAllHoatDongDto>> getAll(Pageable pageable) {
        Page<GetAllHoatDongDto> page = hoatDongService.getAll(pageable);
        return ResponseEntity.ok().body(page);
    }

    @PostMapping("/update")
    public ResponseEntity<?> save(@RequestBody CreateHoatDongDto hoatDongDto, @RequestHeader HttpHeaders headers) {
        try {
            final String authHeader = headers.getFirst("Authorization");
            String jwt = authHeader.substring(7);
            hoatDongService.add(hoatDongDto, jwt);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<HoatDongDto> findById(@PathVariable("id") String id) {
        HoatDongDto hoatDong = hoatDongService.findById(id);
        return ResponseEntity.ok().body(hoatDong);
    }

    @GetMapping("/{month}/{year}")
    public ResponseEntity findByThang(@PathVariable("month") int month, @PathVariable("year") int year
            , @RequestHeader HttpHeaders headers) {
        try {
            final String authHeader = headers.getFirst("Authorization");
            String jwt = authHeader.substring(7);
            List<GetAllHoatDongDto> dto = hoatDongService.findByThang(month, year, jwt);
            //  hoatDongService.add(hoatDongDto, jwt);
            return ResponseEntity.ok(dto);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {
        try {
            hoatDongService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (DataIntegrityViolationException e) {
            // Bắt lỗi khi có ràng buộc khóa ngoại (foreign key constraint)
            // Xử lý hoặc throw lại một ngoại lệ khác tùy vào yêu cầu của bạn
            // throw new RuntimeException("Không thể xóa hoạt động vì có ràng buộc khóa ngoại.", e);
            return ResponseEntity.badRequest().body("Đã có sinh viên đăng ký, không thể xóa!");

        } catch (RuntimeException e) {

            return ResponseEntity.badRequest().body(e.getMessage().substring(27));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Đã sảy ra lỗi không xác định!");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody HoatDongDto hoatDongDto,
                                       @RequestHeader HttpHeaders headers,
                                       @PathVariable("id") String id) {
        final String authHeader = headers.getFirst("Authorization");
        String jwt = authHeader.substring(7);
        hoatDongService.update(hoatDongDto, id, jwt);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/cap-nhat-trang-thai/{maHoatDong}")
    public ResponseEntity<Void> putTrangThai(@PathVariable("maHoatDong") String maHoatDong, String trangThai) {
        hoatDongService.putTrangThai(trangThai, maHoatDong);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/noi-dung/{maHoatDong}")
    public ResponseEntity<List<NoiDungToChucDto>> getByHoatdongId(@PathVariable("maHoatDong") String maHoatDong) {
        List<NoiDungToChucDto> result = noiDungToChucService.getByMaHoatDong(maHoatDong);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/noi-dung/chi-tiet/{maNoiDung}")
    public ResponseEntity getCTNoiDung(@PathVariable("maNoiDung") String maNoiDung) {
        try {
            List<GetAllNoiDungToChucDto> result = noiDungToChucService.getAllCTNoiDung(maNoiDung);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/accepted/{maHoatDong}")
    public ResponseEntity<HoatDongAcceptedDTO> getHoatDongAccepted(@PathVariable("maHoatDong") String maHoatDong) {
        HoatDongAcceptedDTO result = noiDungToChucService.getHoatDongAccepted(maHoatDong);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/noi-dung/{id}")
    public ResponseEntity deleteNoiDung(@PathVariable("id") String id) {
        noiDungToChucService.delete(id);
        return ResponseEntity.ok().build();

    }

    @PutMapping("/noi-dung")
    public ResponseEntity updateNoiDung(@RequestBody NoiDungToChucDto dto) {
        try {
            noiDungToChucService.update(dto);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
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

    @PostMapping("/noi-dung/chi-tiet/{maNoiDung}")
    public ResponseEntity postCTNoiDung(@PathVariable("maNoiDung") String maNoiDung,
                                        @RequestBody CTNoiDungToChucDto dto) {
        try {
            CTNoiDungToChucDto res = noiDungToChucService.createCtNoiDung(dto, maNoiDung);
            return ResponseEntity.ok(res);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/noi-dung/chi-tiet/{maNoiDung}/{maSo}")
    public ResponseEntity putCTNoiDung(@PathVariable("maNoiDung") String maNoiDung,
                                       @PathVariable("maSo") String maSo,
                                       @RequestBody CTNoiDungToChucDto dto) {
        try {
            ChiTietNoiDungKey key = new ChiTietNoiDungKey(maNoiDung, maSo);
            CTNoiDungToChucDto res = noiDungToChucService.updateCtNoiDung(dto, key);
            return ResponseEntity.ok(res);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/noi-dung/chi-tiet/{maNoiDung}/{maSo}")
    public ResponseEntity delCTNoiDung(@PathVariable("maNoiDung") String maNoiDung,
                                       @PathVariable("maSo") String maSo) {
        try {
            ChiTietNoiDungKey key = new ChiTietNoiDungKey(maNoiDung, maSo);
            noiDungToChucService.delCtNoiDung(key);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public static String removeVietnameseDiacritics(String input) {
        // Chuyển các ký tự tiếng Việt có dấu thành không dấu
        String result = input.replaceAll("đ", "d");
        result = result.replaceAll("Đ", "D");

        String normalized = java.text.Normalizer.normalize(result, java.text.Normalizer.Form.NFD);
        return normalized.replaceAll("[^\\p{ASCII}]", "");
    }

    @GetMapping("/danh-sach-dang-ky/{maHoatDong}")
    public ResponseEntity getDSDangKy(@PathVariable("maHoatDong") String maHoatDong) {
        return ResponseEntity.ok(dsSinhVienDangKyService.getAllByMaHoatDong(maHoatDong));
    }

    @PostMapping("/dang-ky/{maHoatDong}")
    public ResponseEntity postSinhVienDangKy(@RequestHeader HttpHeaders headers, @PathVariable("maHoatDong") String maHoatDong) {
        try {
            final String authHeader = headers.getFirst("Authorization");
            String token = authHeader.substring(7);
            dsSinhVienDangKyService.dangKyHoatDong(maHoatDong, token);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/diem-danh/{maHoatDong}")
    public ResponseEntity postDiemDanh(@PathVariable("maHoatDong") String maHoatDong, String maSo) {
        try {
            String hoTen = dsSinhVienDangKyService.diemDanh(maHoatDong, maSo);
            return ResponseEntity.ok(Map.of("tenTaiKhoan", hoTen));
        } catch (RuntimeException e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Đã sảy ra lỗi không xác định!");
        }
    }

    @GetMapping("/trang-thai")
    public ResponseEntity<List<GetAllHoatDongDto>> getByTrangThai(String trangThai) {
        List<GetAllHoatDongDto> list = hoatDongService.getByTrangThai(trangThai);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/search")
    public ResponseEntity searchByString(SearchDto dto) {
        try {
            List<GetAllHoatDongDto> list = hoatDongService.search(dto);
            return ResponseEntity.ok(list);
        } catch (RuntimeException e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Đã sảy ra lỗi không xác định!");
        }
    }
    @GetMapping("/sinh-vien-dang-ky")
    public ResponseEntity getHoatDongSVDK(@RequestHeader HttpHeaders headers) {
        try {
            final String authHeader = headers.getFirst("Authorization");
            String token = authHeader.substring(7);
            List<GetAllHoatDongDto> list = hoatDongService.getHoatDongSVDK(token);
            return ResponseEntity.ok(list);
        } catch (RuntimeException e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Đã sảy ra lỗi không xác định!");
        }
    }

    @GetMapping("/sinh-vien-tham-gia")
    public ResponseEntity getHoatDongSVThamGia(@RequestHeader HttpHeaders headers) {
        try {
            final String authHeader = headers.getFirst("Authorization");
            String token = authHeader.substring(7);
            List<GetAllHoatDongDto> list = hoatDongService.getHoatDongSVThamGia(token);
            return ResponseEntity.ok(list);
        } catch (RuntimeException e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Đã sảy ra lỗi không xác định!");
        }
    }

}
