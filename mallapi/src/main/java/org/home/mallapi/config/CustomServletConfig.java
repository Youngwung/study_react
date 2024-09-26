package org.home.mallapi.config;

import org.home.mallapi.controller.formatter.LocalDateFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class CustomServletConfig implements WebMvcConfigurer {

	@Override
	public void addFormatters(FormatterRegistry registry) {
		log.info("---------------------------------");
		log.info("addFormatters");
		registry.addFormatter(new LocalDateFormatter());
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {

		// 어떤 경로에 Cors를 적용할 거임?
		registry.addMapping("/**") // 필수
				.maxAge(500) // 너무 오래걸리는 요청은 무시함.
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 이 방식 요청은 허락함.
				// OPTIONS는 요청이 유효한 지 미리 실행해볼 때 사용하는 주소라 허락해두어야함.

				.allowedOrigins("*"); // ====> 필수
		// 어디에서 들어오는 걸 허락해 줄거임? => 모든 곳에서

	}

}