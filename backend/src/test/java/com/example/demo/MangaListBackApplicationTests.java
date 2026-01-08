package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test") // <--- Dit à Spring d'utiliser application-test.yml
class MangaListBackApplicationTests {

	@Test
	void testPourInitialiserASupprimerPlusTard() {
		assertTrue(true);
	}

}
