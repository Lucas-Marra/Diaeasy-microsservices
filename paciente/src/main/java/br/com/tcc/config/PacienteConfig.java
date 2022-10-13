package br.com.tcc.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PacienteConfig {

    @Bean
    public ModelMapper obterModelMapper() {
        return new ModelMapper();
    }
}
