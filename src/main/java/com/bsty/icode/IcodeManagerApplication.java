package com.bsty.icode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.bsty.icode.dao")
public class IcodeManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(IcodeManagerApplication.class, args);
    }

}
