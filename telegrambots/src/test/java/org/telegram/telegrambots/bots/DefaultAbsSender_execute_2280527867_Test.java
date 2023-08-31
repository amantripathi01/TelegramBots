package org.telegram.telegrambots.bots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.telegram.telegrambots.meta.api.methods.stickers.AddStickerToSet;
import org.telegram.telegrambots.meta.api.objects.stickers.InputSticker;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DefaultAbsSender_execute_2280527867_Test {

    @InjectMocks
    private DefaultAbsSender defaultAbsSender;

    @Mock
    private AddStickerToSet addStickerToSet;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testExecute_AddStickerToSetSuccess() throws TelegramApiException {
        when(addStickerToSet.getUserId()).thenReturn("12345");
        when(addStickerToSet.getName()).thenReturn("stickerSetName");
        when(addStickerToSet.getSticker()).thenReturn(new InputSticker());

        boolean result = defaultAbsSender.execute(addStickerToSet);
        assertTrue(result);
    }

    @Test
    public void testExecute_AddStickerToSetFailure() throws TelegramApiException {
        when(addStickerToSet.getUserId()).thenReturn("12345");
        when(addStickerToSet.getName()).thenReturn("stickerSetName");
        when(addStickerToSet.getSticker()).thenReturn(null);

        assertThrows(TelegramApiException.class, () -> defaultAbsSender.execute(addStickerToSet));
    }
}
