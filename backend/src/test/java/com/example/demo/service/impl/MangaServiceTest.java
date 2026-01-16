package com.example.demo.service.impl;

import com.example.demo.bo.Manga;
import com.example.demo.repository.MangaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MangaServiceTest {

    @Mock
    MangaRepository mangaRepository;

    @InjectMocks
    MangaServiceImpl mangaService;

    @Test
    void testFindAll(){
        var mangas = List.of(Manga.builder().animeId(1).build(), Manga.builder().animeId(2).build());

        when(mangaRepository.findAll()).thenReturn(mangas);

        var result = mangaService.getAllManga();

        assertNotNull(result);
        assertEquals(mangas.size(), result.size());
        verify(mangaRepository, times(1)).findAll();
    }

    @Test
    void testFindById(){
        var mangaId = 1;
        var manga = Optional.of(Manga.builder().animeId(mangaId).build());

        when(mangaRepository.findById(mangaId)).thenReturn(manga);

        var result = mangaService.getMangaById(mangaId);

        assertNotNull(result);
        assertEquals(mangaId, result.getAnimeId());
    }
}