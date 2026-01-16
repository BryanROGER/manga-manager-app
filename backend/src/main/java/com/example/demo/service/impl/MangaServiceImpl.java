package com.example.demo.service.impl;

import com.example.demo.bo.Manga;
import com.example.demo.enumeration.LogMessage;
import com.example.demo.exception.BLLException;
import com.example.demo.repository.MangaRepository;
import com.example.demo.service.MangaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class MangaServiceImpl implements MangaService {

    private final MangaRepository mangaRepository;

    @Override
    public List<Manga> getAllManga() {
        log.info(LogMessage.INFO_RECUPERATION_TOUS, Manga.class.getSimpleName());
        return mangaRepository.findAll();
    }

    @Override
    public Manga getMangaById(Integer mangaId) {
        return mangaRepository.findById(mangaId)
                .orElseThrow(() -> new BLLException(
                        LogMessage.MANGA_NOT_FOUND,
                        LogMessage.ERROR_ID_INEXISTANT,
                        Manga.class.getSimpleName(),
                        mangaId.toString()
                ));
    }
}
