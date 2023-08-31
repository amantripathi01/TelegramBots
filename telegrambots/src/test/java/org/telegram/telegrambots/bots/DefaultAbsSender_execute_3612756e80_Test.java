package org.telegram.telegrambots.bots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.telegram.telegrambots.meta.api.methods.stickers.UploadStickerFile;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiValidationException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DefaultAbsSender_execute_3612756e80_Test {

    @InjectMocks
    private DefaultAbsSender defaultAbsSender;

    @Mock
    private UploadStickerFile uploadStickerFile;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void execute_success() throws TelegramApiException {
        when(uploadStickerFile.getUserId()).thenReturn("123456789");
        when(uploadStickerFile.getStickerFormat()).thenReturn("png");
        when(uploadStickerFile.deserializeResponse(any())).thenReturn(new File());

        File file = defaultAbsSender.execute(uploadStickerFile);

        assertNotNull(file);
        verify(uploadStickerFile, times(1)).validate();
    }

    @Test
    void execute_validationException() {
        when(uploadStickerFile.getUserId()).thenReturn("123456789");
        when(uploadStickerFile.getStickerFormat()).thenReturn("png");
        doThrow(TelegramApiValidationException.class).when(uploadStickerFile).validate();

        assertThrows(TelegramApiValidationException.class, () -> defaultAbsSender.execute(uploadStickerFile));
        verify(uploadStickerFile, times(1)).validate();
    }

    @Test
    void execute_telegramApiException() throws TelegramApiException {
        when(uploadStickerFile.getUserId()).thenReturn("123456789");
        when(uploadStickerFile.getStickerFormat()).thenReturn("png");
        when(uploadStickerFile.deserializeResponse(any())).thenThrow(new TelegramApiException("Unable to upload new sticker file"));

        assertThrows(TelegramApiException.class, () -> defaultAbsSender.execute(uploadStickerFile));
        verify(uploadStickerFile, times(1)).validate();
    }
}
