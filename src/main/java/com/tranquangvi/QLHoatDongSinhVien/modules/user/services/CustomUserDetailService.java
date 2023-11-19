package com.tranquangvi.QLHoatDongSinhVien.modules.user.services;

import com.tranquangvi.QLHoatDongSinhVien.modules.user.custom.CustomUserDetail;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.entity.TaiKhoanEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.repositories.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    @Override
    public CustomUserDetail loadUserByUsername(String maso) throws UsernameNotFoundException {
        Optional<TaiKhoanEntity> tk = taiKhoanRepository.findById(maso);
        if(tk.isPresent()){
            return new CustomUserDetail(tk.get(), taiKhoanRepository) ;
        }
        else
            throw new UsernameNotFoundException("Không tìm thấy người dùng");
    }
}