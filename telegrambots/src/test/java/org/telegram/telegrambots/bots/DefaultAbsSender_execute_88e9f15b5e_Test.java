package org.telegram.telegrambots.bots;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendVoice;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class DefaultAbsSender_execute_88e9f15b5e_Test {

    @Test
    public void testExecuteSendVoiceSuccess() throws TelegramApiException {
        // Mocking SendVoice object
        SendVoice sendVoice = Mockito.mock(SendVoice.class);
        ChatIdType chatIdType = new ChatIdType(); // replace with actual type and value
        VoiceType voiceType = new VoiceType(); // replace with actual type and value
        when(sendVoice.getChatId()).thenReturn(chatIdType);
        when(sendVoice.getVoice()).thenReturn(voiceType);

        // Mocking DefaultAbsSender object
        DefaultAbsSender defaultAbsSender = Mockito.mock(DefaultAbsSender.class);
        when(defaultAbsSender.execute(sendVoice)).thenReturn(new Message());

        // Calling method under test
        Message result = defaultAbsSender.execute(sendVoice);

        // Assertion
        assertNotNull(result, "The returned Message object should not be null");
    }

    @Test
    public void testExecuteSendVoiceFailure() throws TelegramApiException {
        // Mocking SendVoice object
        SendVoice sendVoice = Mockito.mock(SendVoice.class);
        when(sendVoice.getChatId()).thenReturn(null);
        VoiceType voiceType = new VoiceType(); // replace with actual type and value
        when(sendVoice.getVoice()).thenReturn(voiceType);

        // Mocking DefaultAbsSender object
        DefaultAbsSender defaultAbsSender = Mockito.mock(DefaultAbsSender.class);
        when(defaultAbsSender.execute(sendVoice)).thenThrow(TelegramApiException.class);

        // Calling method under test and asserting exception
        assertThrows(TelegramApiException.class, () -> defaultAbsSender.execute(sendVoice), "Expected execute to throw TelegramApiException when chatId is null");
    }
}
