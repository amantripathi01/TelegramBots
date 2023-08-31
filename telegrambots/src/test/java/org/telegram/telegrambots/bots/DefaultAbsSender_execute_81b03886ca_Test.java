package org.telegram.telegrambots.bots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendVoice;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class DefaultAbsSender_execute_88e9f15b5e_Test {

    private DefaultAbsSender sender;

    @BeforeEach
    public void setUp() {
        sender = Mockito.mock(DefaultAbsSender.class);
    }

    @Test
    public void testExecuteSendVoiceSuccess() throws TelegramApiException {
        SendVoice sendVoice = new SendVoice();
        sendVoice.setChatId("chatId");
        sendVoice.setVoice("voice");

        Message message = new Message();
        when(sender.execute(any(SendVoice.class))).thenReturn(message);

        Message result = sender.execute(sendVoice);

        assertEquals(message, result);
    }

    @Test
    public void testExecuteSendVoiceFailure() throws TelegramApiException {
        SendVoice sendVoice = new SendVoice();
        sendVoice.setChatId("chatId");
        sendVoice.setVoice("voice");

        when(sender.execute(any(SendVoice.class))).thenThrow(new TelegramApiException("Unable to send voice"));

        assertThrows(TelegramApiException.class, () -> sender.execute(sendVoice));
    }
}
