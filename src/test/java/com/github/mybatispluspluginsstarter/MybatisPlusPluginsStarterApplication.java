package com.github.mybatispluspluginsstarter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.github.mybatispluspluginsstarter.mapper")
public class MybatisPlusPluginsStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisPlusPluginsStarterApplication.class, args);
	}

}
