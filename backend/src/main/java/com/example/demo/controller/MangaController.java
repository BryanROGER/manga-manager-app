package com.example.demo.controller;

import com.example.demo.bo.Manga;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface MangaController {

    ResponseEntity<List<Manga>> getAllManga();

    ResponseEntity<Manga> getMangaById(Integer mangaId);
}
