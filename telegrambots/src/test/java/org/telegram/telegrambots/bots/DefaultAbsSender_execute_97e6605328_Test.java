package org.telegram.telegrambots.bots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class DefaultAbsSender_execute_97e6605328_Test {

    @Mock
    private DefaultAbsSender defaultAbsSender;
    @Mock
    private SendAudio sendAudio;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testExecuteSendAudio_Success() throws TelegramApiException {
        Message message = mock(Message.class);
        when(defaultAbsSender.execute(sendAudio)).thenReturn(message);
        Message result = defaultAbsSender.execute(sendAudio);
        assertEquals(message, result);
        verify(defaultAbsSender, times(1)).execute(sendAudio);
    }

    @Test
    public void testExecuteSendAudio_TelegramApiException() throws TelegramApiException {
        when(defaultAbsSender.execute(sendAudio)).thenThrow(TelegramApiException.class);
        assertThrows(TelegramApiException.class, () -> defaultAbsSender.execute(sendAudio));
        verify(defaultAbsSender, times(1)).execute(sendAudio);
    }
}
