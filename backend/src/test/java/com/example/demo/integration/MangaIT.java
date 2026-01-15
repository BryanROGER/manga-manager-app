package com.example.demo.integration;

import com.example.demo.bo.Manga;
import com.example.demo.repository.MangaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test") // <--- Dit à Spring d'utiliser application-test.yml
@AutoConfigureMockMvc
@Transactional // Très important : nettoie la BDD après le test
class MangaIT {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private MangaRepository mangaRepository;

	@Test
	void testGetAllManga_FullStack() throws Exception {
		mangaRepository.save(Manga.builder().animeId(1).title("Berserk").build());

		mockMvc.perform(get("/mangas"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].title").value("Berserk"));
	}
}
