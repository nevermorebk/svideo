package com.minori.svideo.rest.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:application-config.xml")
@EnableAutoConfiguration()
public class SvideoGateway {
  public static void main(String[] args) {
    SpringApplication.run(SvideoGateway.class, args);
  }
}
