package com.tranquangvi.QLHoatDongSinhVien.modules.user.custom;

import com.tranquangvi.QLHoatDongSinhVien.modules.user.entity.TaiKhoanEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.repositories.TaiKhoanRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CustomUserDetail implements UserDetails  {
    private final TaiKhoanEntity taikhoan;
    private final TaiKhoanRepository taiKhoanRepository;
    public CustomUserDetail(TaiKhoanEntity taikhoan, TaiKhoanRepository userRepository){

        this.taikhoan = taikhoan;
        this.taiKhoanRepository = userRepository;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        String[] roles = taiKhoanRepository.getRolesOfUser(taikhoan.getMaSo());
        for(String role : roles)
       {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return taikhoan.getMatKhau();
    }

    @Override
    public String getUsername() {
        return taikhoan.getMaSo().toString();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
