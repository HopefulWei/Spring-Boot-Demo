package com.example.demoformbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demoformbs.mapper")
public class DemoformbsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoformbsApplication.class, args);
    }


}
