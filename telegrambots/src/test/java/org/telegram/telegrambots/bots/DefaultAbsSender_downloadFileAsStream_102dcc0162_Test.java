package org.telegram.telegrambots.bots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DefaultAbsSender_downloadFileAsStream_102dcc0162_Test {

    @InjectMocks
    DefaultAbsSender defaultAbsSender;

    @Mock
    DefaultAbsSender mockDefaultAbsSender;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDownloadFileAsStream_success() throws TelegramApiException {
        File file = mock(File.class);
        InputStream expectedStream = mock(InputStream.class);
        when(mockDefaultAbsSender.downloadFileAsStream(file)).thenReturn(expectedStream);

        InputStream actualStream = defaultAbsSender.downloadFileAsStream(file);

        assertEquals(expectedStream, actualStream);
        verify(mockDefaultAbsSender, times(1)).downloadFileAsStream(file);
    }

    @Test
    public void testDownloadFileAsStream_failure() throws TelegramApiException {
        File file = mock(File.class);
        when(mockDefaultAbsSender.downloadFileAsStream(file)).thenThrow(TelegramApiException.class);

        assertThrows(TelegramApiException.class, () -> defaultAbsSender.downloadFileAsStream(file));
        verify(mockDefaultAbsSender, times(1)).downloadFileAsStream(file);
    }
}
