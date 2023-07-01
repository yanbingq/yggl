package com.rt.yggl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.rt.yggl.mapper"})
public class ygglApplication {
    public static void main(String[] args) {
        SpringApplication.run(ygglApplication.class, args);
    }
}
