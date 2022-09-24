package com.ems.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ems.core","com.ems.commons"})
public class EmsApplication {

    public static void main(String[] args){
        SpringApplication.run(EmsApplication.class,args);
    }
}
