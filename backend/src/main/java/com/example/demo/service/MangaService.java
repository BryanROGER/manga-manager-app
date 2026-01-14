package com.example.demo.service;


import com.example.demo.bo.Manga;

import java.util.List;

public interface MangaService {

    /**
     * Permet de récupérer l'ensemble des mangas
     * @return liste de mangas
     */
    List<Manga> getAllManga();
}
