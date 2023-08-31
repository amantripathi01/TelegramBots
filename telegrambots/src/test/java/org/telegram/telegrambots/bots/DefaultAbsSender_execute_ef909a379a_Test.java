package org.telegram.telegrambots.bots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class DefaultAbsSender_execute_ef909a379a_Test {

    @Mock
    private SendSticker sendSticker;
    
    @Mock
    private DefaultAbsSender defaultAbsSender;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testExecute_Success() throws TelegramApiException {
        Message expectedMessage = new Message();
        when(sendSticker.getChatId()).thenReturn("testChatId");
        when(defaultAbsSender.execute(sendSticker)).thenReturn(expectedMessage);

        Message actualMessage = defaultAbsSender.execute(sendSticker);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testExecute_Failure() throws TelegramApiException {
        when(sendSticker.getChatId()).thenReturn("testChatId");
        when(defaultAbsSender.execute(sendSticker)).thenThrow(TelegramApiException.class);

        assertThrows(TelegramApiException.class, () -> defaultAbsSender.execute(sendSticker));
    }
}
