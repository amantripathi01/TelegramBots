package org.telegram.telegrambots.bots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DefaultAbsSender_execute_62947df605_Test {

    @InjectMocks
    private DefaultAbsSender defaultAbsSender;

    @Mock
    private SendPhoto sendPhoto;

    @Mock
    private Message message;

    @Test
    public void testExecute_success() throws TelegramApiException {
        when(sendPhoto.getChatId()).thenReturn("chatId");
        when(defaultAbsSender.execute(sendPhoto)).thenReturn(message);

        Message result = defaultAbsSender.execute(sendPhoto);

        assertEquals(message, result);
    }

    @Test
    public void testExecute_throwException() throws TelegramApiException {
        when(sendPhoto.getChatId()).thenReturn("chatId");
        when(defaultAbsSender.execute(sendPhoto)).thenThrow(TelegramApiException.class);

        assertThrows(TelegramApiException.class, () -> {
            defaultAbsSender.execute(sendPhoto);
        });
    }
}
