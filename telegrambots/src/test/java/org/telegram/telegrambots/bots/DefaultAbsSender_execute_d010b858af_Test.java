package org.telegram.telegrambots.bots;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class DefaultAbsSender_execute_d010b858af_Test {

    @Mock
    private SendAnimation sendAnimation;

    @InjectMocks
    private DefaultAbsSender defaultAbsSender;

    @Test
    public void testExecuteSendAnimation_Success() throws TelegramApiException {
        Message message = new Message();
        when(sendAnimation.deserializeResponse(any())).thenReturn(message);

        Message result = defaultAbsSender.execute(sendAnimation);

        assertEquals(message, result);
    }

    @Test
    public void testExecuteSendAnimation_Failure() throws TelegramApiException {
        when(sendAnimation.deserializeResponse(any())).thenThrow(IOException.class);

        assertThrows(TelegramApiException.class, () -> defaultAbsSender.execute(sendAnimation));
    }
}
