package com.example.demo;

import com.example.demo.repository.MangaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class MangaListBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MangaListBackApplication.class, args);


    }

    @Bean
    CommandLineRunner start(MangaRepository mangaRepository) {
        return args -> {
            log.info("Nombre de mangas en base : {}", mangaRepository.count());
            mangaRepository.findAll().stream()
                    .limit(5)
                    .forEach(m -> log.info(m.getTitle()));
        };


    }
}
