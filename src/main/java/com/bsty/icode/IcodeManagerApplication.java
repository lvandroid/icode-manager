package com.bsty.icode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bsty.icode.dao")
public class IcodeManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(IcodeManagerApplication.class, args);
    }

}
