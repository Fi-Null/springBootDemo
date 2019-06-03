package com.springboot.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;

@SpringBootApplication
//spring boot 1.5以后的版本不支持Vm模板，需要手动配置vm解析
@ImportResource({"classpath:velocityConfig.xml"})
//必须手动加上注解，不然swagger2不生效
@EnableSwagger2
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}


	@RestController
	class HelloController {

		@PostMapping("/userLocalDate")
		public UserDto user(@RequestBody UserDto userDto) throws Exception {
			return userDto;
		}

	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	static class UserDto {

		private String userName;
		private LocalDate birthday;

	}

	@Bean
	public ObjectMapper serializingObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		objectMapper.registerModule(new JavaTimeModule());
		return objectMapper;
	}

}
