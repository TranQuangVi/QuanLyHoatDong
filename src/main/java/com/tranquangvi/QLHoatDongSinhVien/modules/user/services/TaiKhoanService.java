package com.tranquangvi.QLHoatDongSinhVien.modules.user.services;

import com.tranquangvi.QLHoatDongSinhVien.modules.user.custom.CustomUserDetail;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.dto.AuthResponse;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.dto.LoginDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.dto.SignUpDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.dto.TaiKhoanDto;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.entity.TaiKhoanEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.mapper.SignUpMapper;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.mapper.TaiKhoanDtoMapper;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.mapper.TaiKhoanDtoMapperImpl;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.repositories.TaiKhoanRepository;
import com.tranquangvi.QLHoatDongSinhVien.util.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaiKhoanService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    @Autowired
    private ChucVuService chucVuService;
    @Autowired
    private SignUpMapper signUpMapper;
    @Autowired
    private TaiKhoanDtoMapper taiKhoanDtoMapper;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    public void addNewTaiKhoan(SignUpDto signUpDto) {
        Optional<TaiKhoanEntity> optional = taiKhoanRepository.findById(signUpDto.getMaSo());
        if (optional.isPresent()) {
            throw new RuntimeException("Mã số đã tồn tại!");
        } else {

            TaiKhoanEntity taiKhoan = signUpMapper.toEntity(signUpDto);
            if (taiKhoan.getHinh() == null)
                taiKhoan.setHinh("https://png.pngtree.com/png-clipart/20221207/ourmid/pngtree-business-man-avatar-png-image_6514640.png");
            taiKhoan.setMatKhau(new BCryptPasswordEncoder().encode(taiKhoan.getMatKhau()));
            taiKhoanRepository.save(taiKhoan);
            taiKhoanRepository.addRoleToUser(signUpDto.getMaSo(), signUpDto.getMaChucVu());

//        CustomUserDetail userDetail = new CustomUserDetail(taiKhoan, taiKhoanRepository);
//        var jwtToken = jwtService.generateToken(userDetail);
//        AuthResponse authResponse = new AuthResponse();
//        authResponse.setAccessToken(jwtToken);
//        return authResponse;
        }
    }

    public TaiKhoanDto getTaiKhoanById(String id) {
        Optional<TaiKhoanEntity> optional = taiKhoanRepository.findById(id);
        if (optional.isPresent()) {

            return taiKhoanDtoMapper.toDto(optional.get());
        }
        throw new RuntimeException("Mã số không chính sát!");
    }

    public TaiKhoanEntity findById(String id) {
        Optional<TaiKhoanEntity> optional = taiKhoanRepository.findById(id);
        if (optional.isPresent()) {

            return optional.get();
        }

        throw new RuntimeException("Mã số tài khoản không chính sát!");
    }

    public AuthResponse login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getMaSo(), loginDto.getMatKhau()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        TaiKhoanEntity taiKhoanEntity = findById(loginDto.getMaSo());
        CustomUserDetail userDetail = new CustomUserDetail(taiKhoanEntity, taiKhoanRepository);

        var jwtToken = jwtService.generateToken(userDetail);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setAccessToken(jwtToken);
        return authResponse;
    }

    public TaiKhoanEntity findByToken(String token) {
        return taiKhoanRepository.findById(jwtService.extractUser(token)).get();
    }

    public String getTenByMaSo(String maSo) {
        TaiKhoanDto taiKhoan = getTaiKhoanById(maSo);
        return taiKhoan.getHoTen();
    }

    public void updateTaiKhoan(String maSo, TaiKhoanDto taiKhoanDto) {
        Optional<TaiKhoanEntity> optional = taiKhoanRepository.findById(maSo);
        if (optional.isPresent()) {
            TaiKhoanEntity old=optional.get();
            TaiKhoanEntity entity = taiKhoanDtoMapper.toEntity(taiKhoanDto);
            entity.setMatKhau(old.getMatKhau());
            taiKhoanRepository.save(entity);
        } else
            throw new RuntimeException("Mã số tài khoản không chính sát!");
    }

    public Page<TaiKhoanDto> getByRole(String role, Pageable pageable) {
        String[] entities = taiKhoanRepository.getAllUserByRole(role);

        List<TaiKhoanDto> dtos = new ArrayList<>();

        for (var maso : entities) {
            TaiKhoanDto dto = getTaiKhoanById(maso);
            dtos.add(dto);
        }

        return new PageImpl<>(dtos, pageable, dtos.size());
    }
}
