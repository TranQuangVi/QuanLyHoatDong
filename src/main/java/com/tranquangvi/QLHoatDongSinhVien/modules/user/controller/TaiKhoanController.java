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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;

@RestController
@CrossOrigin
@RequestMapping("/tai-khoan")
public class TaiKhoanController {

    @Autowired
    private TaiKhoanService taiKhoanService;
    @Autowired
    private JwtService jwtService;



    @PostMapping("/sign-in")
    public ResponseEntity<AuthResponse> authenticateUser(@RequestBody LoginDto loginDto) {
        try{
//            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                    loginDto.getMaSo(), loginDto.getMatKhau()));
//
//            SecurityContextHolder.getContext().setAuthentication(authentication);

            AuthResponse authResponse = taiKhoanService.login(loginDto);
            return new ResponseEntity<>(authResponse, HttpStatus.OK);
        }catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }


    }

    @PostMapping("/sign-up")
    public ResponseEntity<AuthResponse> signUp(@RequestBody SignUpDto signUpDto) {
        AuthResponse authResponse = taiKhoanService.addNewTaiKhoan(signUpDto);
        return ResponseEntity.ok(authResponse);
    }

    @GetMapping("/{token}")
    public ResponseEntity<TaiKhoanDto> getTaiKhoan(@PathVariable("token") String jwt) {
        TaiKhoanDto taiKhoanEntity = taiKhoanService.getTaiKhoanById(jwtService.extractUser(jwt));

        return new ResponseEntity<>(taiKhoanEntity, HttpStatus.OK);
    }


}
