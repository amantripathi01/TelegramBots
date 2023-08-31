package org.telegram.telegrambots.bots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.telegram.telegrambots.facilities.filedownloader.TelegramFileDownloader;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class DefaultAbsSender_downloadFileAsStream_ed6094f6ba_Test {

    @Mock
    private TelegramFileDownloader telegramFileDownloader;

    private class TestDefaultAbsSender extends DefaultAbsSender {
        public TestDefaultAbsSender() {
            super();
        }
    }

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDownloadFileAsStreamSuccess() throws TelegramApiException {
        TestDefaultAbsSender defaultAbsSender = new TestDefaultAbsSender();

        InputStream inputStream = new InputStream() {
            @Override
            public int read() {
                return -1;  // end of stream
            }
        };

        when(telegramFileDownloader.downloadFileAsStream("file_path")).thenReturn(inputStream);

        InputStream result = defaultAbsSender.downloadFileAsStream("file_path");

        assertNotNull(result);
    }

    @Test
    public void testDownloadFileAsStreamFailure() throws TelegramApiException {
        TestDefaultAbsSender defaultAbsSender = new TestDefaultAbsSender();

        when(telegramFileDownloader.downloadFileAsStream("file_path")).thenThrow(TelegramApiException.class);

        assertThrows(TelegramApiException.class, () -> defaultAbsSender.downloadFileAsStream("file_path"));
    }
}
