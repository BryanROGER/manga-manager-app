package com.example.demo.exception;

import com.example.demo.bo.Manga;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BLLExceptionTest {

    @Test
    @DisplayName("Devrait stocker le errorCode et formater le message correctement")
    void shouldFormatMessageAndStoreErrorCode() {
        String code = "MANGA_NOT_FOUND";
        String pattern = "Le {} avec l'id {} n'existe pas";

        BLLException exception = new BLLException(code, pattern, "Manga", 42);

        assertAll(
                () -> assertThat(exception.getErrorCode()).isEqualTo("MANGA_NOT_FOUND"),
                () -> assertThat(exception.getMessage()).isEqualTo("Le Manga avec l'id 42 n'existe pas")
        );
    }

    @Test
    @DisplayName("Devrait retourner le message brut s'il n'y a pas d'arguments")
    void shouldReturnRawMessageWhenNoArgs() {
        String message = "Une erreur est survenue";

        BLLException exception = new BLLException("ERR_001", message);

        assertThat(exception.getMessage()).isEqualTo(message);
    }

    @Test
    @DisplayName("Devrait gérer les cas où il y a plus d'arguments que de balises {}")
    void shouldHandleMoreArgsThanPlaceholders() {
        String pattern = "Bonjour {}";

        BLLException exception = new BLLException("CODE", pattern, "John", "Doe");

        assertThat(exception.getMessage()).isEqualTo("Bonjour John");
    }

    @Test
    @DisplayName("Vérifie l'extraction du nom de classe simple et la conversion de l'ID")
    void shouldHandleClassSimpleNameAndIdToString() {
        String code = "NOT_FOUND";
        String pattern = "Erreur sur {} avec l'id {}";

        String simpleName = Manga.class.getSimpleName();
        var id = 150;
        String idString = Integer.toString(id);

        BLLException exception = new BLLException(code, pattern, simpleName, idString);

        assertThat(exception.getMessage()).contains("Manga");
        assertThat(exception.getMessage()).doesNotContain("com.example.demo");
        assertThat(exception.getMessage()).contains("150");
        assertThat(exception.getMessage()).isEqualTo("Erreur sur Manga avec l'id 150");
    }
}