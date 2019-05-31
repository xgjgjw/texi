package com.mj.texi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mj.texi.book.mapper")
public class TexiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TexiApplication.class, args);
    }

}
