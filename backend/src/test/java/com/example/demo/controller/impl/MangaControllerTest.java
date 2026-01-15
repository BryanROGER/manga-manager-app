package com.example.demo.controller.impl;

import com.example.demo.bo.Manga;
import com.example.demo.service.impl.MangaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MangaControllerTest {

    @Mock
    MangaServiceImpl mangaService;

    @InjectMocks
    MangaControllerImpl mangaController;

    @Test
    void testGetAll(){
        var mangas = List.of(Manga.builder().animeId(1).build(), Manga.builder().animeId(2).build());

        when(mangaService.getAllManga()).thenReturn(mangas);

        var result = mangaController.getAllManga();

        assertNotNull(result);
        assertNotNull(result.getBody());
        assertEquals(mangas.size(), result.getBody().size());

        verify(mangaService, times(1)).getAllManga();
    }
}