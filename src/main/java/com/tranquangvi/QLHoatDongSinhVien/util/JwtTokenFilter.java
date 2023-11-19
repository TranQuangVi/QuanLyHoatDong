package com.tranquangvi.QLHoatDongSinhVien.util;

import com.tranquangvi.QLHoatDongSinhVien.modules.user.custom.CustomUserDetail;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.entity.TaiKhoanEntity;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.services.CustomUserDetailService;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.services.TaiKhoanService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {
    @Autowired
    private CustomUserDetailService customUserDetailService;
    @Autowired
    private JwtService jwtService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String maSo;
        if (authHeader==null || !authHeader.startsWith("Bearer")) {
            filterChain.doFilter(request, response);
            return;
        }
        jwt= authHeader.substring(7);
        maSo= jwtService.extractUser(jwt);

        if (maSo != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            CustomUserDetail userDetails = customUserDetailService.loadUserByUsername(maSo);
//            var isTokenValid = tokenRepository.findByToken(jwt)
//                    .map(t -> !t.isExpired() && !t.isRevoked())
//                    .orElse(false);
            if (jwtService.isTokenValid(jwt, userDetails) ) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);

    }

}
