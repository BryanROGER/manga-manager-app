package com.example.demo.exception;

import com.example.demo.enumeration.LogMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GlobalExceptionHandlerUnitTest {

    private final GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();

    @Test
    void handleBLLException_ShouldReturnCorrectBody() {
        // Given
        String expectedMessage = LogMessage.ERROR_ID_INEXISTANT;
        String expectedCode = LogMessage.MANGA_NOT_FOUND;
        var argClassName = "ClassName";
        var argIdManga = "1";
        BLLException exception = new BLLException(expectedCode, expectedMessage, argClassName, argIdManga);

        // When
        ResponseEntity<Map<String, Object>> response = exceptionHandler.handleBLLException(exception);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(expectedCode, response.getBody().get("code"));
        assertNotNull(response.getBody().get("timestamp"));
        assertThat(response.getBody().get("message").toString()).contains(argClassName, argIdManga);

    }
}