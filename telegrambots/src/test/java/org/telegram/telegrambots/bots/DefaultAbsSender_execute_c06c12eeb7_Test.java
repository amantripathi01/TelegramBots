package org.telegram.telegrambots.bots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class DefaultAbsSender_execute_c06c12eeb7_Test {

    @Mock
    SendMediaGroup sendMediaGroup;

    @InjectMocks
    DefaultAbsSender defaultAbsSender;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testExecute_Success() throws TelegramApiException {
        Message message1 = new Message();
        Message message2 = new Message();
        List<Message> expected = Arrays.asList(message1, message2);

        when(sendMediaGroup.deserializeResponse(any())).thenReturn(expected);

        List<Message> actual = defaultAbsSender.execute(sendMediaGroup);

        assertEquals(expected, actual);
    }

    @Test
    public void testExecute_Failure() throws TelegramApiException {
        when(sendMediaGroup.deserializeResponse(any())).thenThrow(new TelegramApiException("Unable to set chat photo"));

        assertThrows(TelegramApiException.class, () -> {
            defaultAbsSender.execute(sendMediaGroup);
        });
    }
}
