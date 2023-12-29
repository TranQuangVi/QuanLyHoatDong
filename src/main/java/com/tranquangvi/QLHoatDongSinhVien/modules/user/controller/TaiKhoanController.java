package com.tranquangvi.QLHoatDongSinhVien.modules.user.controller;

import com.tranquangvi.QLHoatDongSinhVien.modules.event.dto.LoaihoatdongDTO;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.dto.AuthResponse;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.dto.LoginDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.dto.SignUpDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.dto.TaiKhoanDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.entity.TaiKhoanEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.mapper.SignUpMapper;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.services.TaiKhoanService;
import com.tranquangvi.QLHoatDongSinhVien.util.JwtService;
import com.tranquangvi.QLHoatDongSinhVien.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/tai-khoan")
public class TaiKhoanController {

    @Autowired
    private TaiKhoanService taiKhoanService;
    @Autowired
    private JwtService jwtService;

    @GetMapping("/danh-sach/{chucVu}")
    public ResponseEntity getAllTaiKhoanByRole(@PathVariable("chucVu") String chucVu, Pageable pageable) {
        try {
            Page<TaiKhoanDto> dto = taiKhoanService.getByRole(chucVu, pageable);
            return ResponseEntity.ok(dto);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/sign-in")
    public ResponseEntity<AuthResponse> authenticateUser(@RequestBody LoginDto loginDto) {
        try {
//            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                    loginDto.getMaSo(), loginDto.getMatKhau()));
//
//            SecurityContextHolder.getContext().setAuthentication(authentication);

            AuthResponse authResponse = taiKhoanService.login(loginDto);
            return new ResponseEntity<>(authResponse, HttpStatus.OK);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }


    }

    @PostMapping("/sign-up")
    public ResponseEntity signUp(@RequestBody SignUpDto signUpDto) {
        try {
            taiKhoanService.addNewTaiKhoan(signUpDto);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    @PutMapping("/update/{maSo}")
    public ResponseEntity updateTaiKhoan(@PathVariable("maSo") String maSo, @RequestBody TaiKhoanDto taiKhoanDto) {
        try {
            taiKhoanService.updateTaiKhoan(maSo,taiKhoanDto);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    @GetMapping("/{token}")
    public ResponseEntity<TaiKhoanDto> getTaiKhoan(@PathVariable("token") String jwt) {
        TaiKhoanDto taiKhoanEntity = taiKhoanService.getTaiKhoanById(jwtService.extractUser(jwt));

        return new ResponseEntity<>(taiKhoanEntity, HttpStatus.OK);
    }

    @GetMapping("/thong-tin/{maSo}")
    public ResponseEntity<?> getTenTaiKhoanByMaSo(@PathVariable("maSo") String maSo) {
        try {
            // Gọi phương thức service để lấy thông tin
            String tenTaiKhoan = taiKhoanService.getTenByMaSo(maSo);
            // Trả về dữ liệu thành công
            return ResponseEntity.ok().body(Map.of("tenTaiKhoan", tenTaiKhoan));
        } catch (RuntimeException e) {
            // Trả về lỗi với thông điệp
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage().substring(27)));
        } catch (Exception e) {
            // Trả về lỗi không xác định
            return ResponseEntity.badRequest().body(Map.of("error", "Đã sảy ra lỗi không xác định!"));
        }
    }


}
