package org.telegram.telegrambots.bots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class DefaultAbsSender_execute_64cb8c9270_Test {

    @InjectMocks
    private DefaultAbsSender defaultAbsSender = new DefaultAbsSender();

    @Mock
    private SendVideo sendVideo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testExecuteSuccess() throws TelegramApiException {
        Message expectedMessage = new Message();
        when(sendVideo.deserializeResponse(any())).thenReturn(expectedMessage);
        Message actualMessage = defaultAbsSender.execute(sendVideo);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testExecuteFailure() throws TelegramApiException {
        when(sendVideo.deserializeResponse(any())).thenThrow(new TelegramApiException("Unable to send video"));
        assertThrows(TelegramApiException.class, () -> defaultAbsSender.execute(sendVideo));
    }
}
