package com.tranquangvi.QLHoatDongSinhVien;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Quan Ly Hoat Dong API ",
				description = "This is project for Do An Chuyen Nganh",
				version = "1.0.0",
				contact = @Contact (name = "Tran Quang Vi", url = "https://github.com/TranQuangVi")
		)
)
public class QlHoatDongSinhVienApplication {
	public static void main(String[] args) {
		SpringApplication.run(QlHoatDongSinhVienApplication.class, args);
	}


}
