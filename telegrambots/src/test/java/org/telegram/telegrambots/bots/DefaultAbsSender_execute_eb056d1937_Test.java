package org.telegram.telegrambots.bots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.telegram.telegrambots.meta.api.methods.stickers.SetStickerSetThumb;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DefaultAbsSender_execute_eb056d1937_Test {

    @Mock
    private SetStickerSetThumb setStickerSetThumb;

    @Mock
    private DefaultAbsSender defaultAbsSender;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testExecuteWithValidThumb() throws TelegramApiException {
        when(setStickerSetThumb.getUserId()).thenReturn("123456789");
        when(setStickerSetThumb.getName()).thenReturn("stickerSetName");
        when(setStickerSetThumb.getThumb()).thenReturn("validThumb");
        when(defaultAbsSender.execute(setStickerSetThumb)).thenReturn(true);

        assertTrue(defaultAbsSender.execute(setStickerSetThumb));
    }

    @Test
    public void testExecuteWithNullThumb() throws TelegramApiException {
        when(setStickerSetThumb.getUserId()).thenReturn("123456789");
        when(setStickerSetThumb.getName()).thenReturn("stickerSetName");
        when(setStickerSetThumb.getThumb()).thenReturn(null);
        when(defaultAbsSender.execute(setStickerSetThumb)).thenReturn(true);

        assertTrue(defaultAbsSender.execute(setStickerSetThumb));
    }

    @Test
    public void testExecuteWithIOException() throws TelegramApiException {
        when(setStickerSetThumb.getUserId()).thenReturn("123456789");
        when(setStickerSetThumb.getName()).thenReturn("stickerSetName");
        when(setStickerSetThumb.getThumb()).thenReturn("validThumb");
        when(defaultAbsSender.execute(setStickerSetThumb)).thenThrow(TelegramApiException.class);

        assertThrows(TelegramApiException.class, () -> defaultAbsSender.execute(setStickerSetThumb));
    }
}
