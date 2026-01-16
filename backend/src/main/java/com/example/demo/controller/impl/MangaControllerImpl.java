package com.example.demo.controller.impl;

import com.example.demo.bo.Manga;
import com.example.demo.controller.MangaController;
import com.example.demo.service.impl.MangaServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/mangas")
@RequiredArgsConstructor
@RestController
@Tag(name = "Manga API", description = "Gestion du catalogue de mangas")
public class MangaControllerImpl implements MangaController {

    private final MangaServiceImpl mangaService;

    @Transactional(readOnly = true)
    @Operation(summary = "Récupérer tous les mangas", description = "Renvoie une liste de manga")
    @ApiResponse(responseCode = "200", description = "Manga trouvé")
    @GetMapping("")
    @Override
    public ResponseEntity<List<Manga>> getAllManga() {
        var mangas = mangaService.getAllManga();
        return new ResponseEntity<>(mangas, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @Operation(summary = "Récupérer le manga de l'id passé en paramètre", description = "Renvoie un manga")
    @ApiResponse(responseCode = "200", description = "Manga trouvé")
    @ApiResponse(responseCode = "404", description = "Manga non trouvé, mauvais ID")
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Manga> getMangaById(@PathVariable("id") Integer mangaId) {
        var manga = mangaService.getMangaById(mangaId);
        return new ResponseEntity<>(manga, HttpStatus.OK);
    }
}
