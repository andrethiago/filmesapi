package br.com.andrethiago.filmesapi.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@ComponentScan(basePackages = "br.com.andrethiago.filmesapi")
@EnableWebMvc
public class AppConfig {

}
