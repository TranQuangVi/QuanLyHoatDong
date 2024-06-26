package com.tranquangvi.QLHoatDongSinhVien.config;

import com.tranquangvi.QLHoatDongSinhVien.modules.user.custom.CustomUserDetail;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.repositories.TaiKhoanRepository;
import com.tranquangvi.QLHoatDongSinhVien.modules.user.services.CustomUserDetailService;
import com.tranquangvi.QLHoatDongSinhVien.util.JwtTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor

public class SecurityConfig {
    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailService();
    }

    //    @Bean
//    public UserDetailsService userDetailsService() {
//        return username -> customUserDetailService.loadUserByUsername(username)
//        throw(() -> new UsernameNotFoundException("User not found"));
//    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    private static final String[] WHITE_LIST_URL = {"/api/v1/auth/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/webjars/**",
            "/swagger-ui.html",
            "/tai-khoan/sign-in/**", "/tai-khoan/sign-in",
            "/hoat-dong/dang-ky", "/hoat-dong/dang-ky/**"
        //    "/**"
    };
    private static final String[] SINHVIEN_REQUEST_URL = {
            "/hoat-dong/dang-ky", "/hoat-dong/dang-ky/**",

    };
    private static final String[] GIANGVIEN_REQUEST_URL = {
            "/phieu-phe-duyet",
            "/tieu-chi","/tieu-chi/**",
            "/hoat-dong/noi-dung/chi-tiet/",
         //   "/hoat-dong/noi-dung",
            "/hoat-dong/update","/hoat-dong/update/**",
            "/hoat-dong/cap-nhat-trang-thai",
    };

    private static final String[] ADMIN_REQUEST = {
            "/phieu-phe-duyet",
            "/phieu-phe-duyet/duyet-phieu","/phieu-phe-duyet/duyet-phieu/**",
            "/tieu-chi","/tieu-chi/**",
            "/hoat-dong/noi-dung/chi-tiet/",
          //  "/hoat-dong/noi-dung",
            "/hoat-dong/update","/hoat-dong/update/**",
            "/hoat-dong/cap-nhat-trang-thai",
    };




    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(WHITE_LIST_URL)

                .permitAll()
                .requestMatchers(SINHVIEN_REQUEST_URL)
                .hasAnyAuthority("SINHVIEN")

                .requestMatchers(GIANGVIEN_REQUEST_URL)
                .hasAnyAuthority("GIANGVIEN","ADMIN")

                .requestMatchers( ADMIN_REQUEST)
                .hasAnyAuthority("ADMIN")

                .anyRequest()
               //         .permitAll()
                .authenticated()

        );

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authenticationProvider(authenticationProvider());
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        http.cors();

//                .exceptionHandling(exceptionHandling ->
//                        exceptionHandling.accessDeniedPage("/403"));

        return http.build();
    }

}
