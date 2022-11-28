package br.com.tcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MedicoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MedicoApplication.class, args);
    }
}
