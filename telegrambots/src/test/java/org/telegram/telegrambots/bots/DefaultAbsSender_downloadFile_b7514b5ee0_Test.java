package org.telegram.telegrambots.bots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.facilities.filedownloader.TelegramFileDownloader;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class DefaultAbsSender_downloadFile_b7514b5ee0_Test {

    @Mock
    private TelegramFileDownloader telegramFileDownloader;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDownloadFile_success() throws TelegramApiException {
        String filePath = "testPath";
        File expectedFile = new File(filePath);
        when(telegramFileDownloader.downloadFile(filePath)).thenReturn(expectedFile);

        File actualFile = telegramFileDownloader.downloadFile(filePath);

        assertEquals(expectedFile, actualFile);
    }

    @Test
    public void testDownloadFile_failure() throws TelegramApiException {
        String filePath = "testPath";
        when(telegramFileDownloader.downloadFile(filePath)).thenThrow(TelegramApiException.class);

        assertThrows(TelegramApiException.class, () -> telegramFileDownloader.downloadFile(filePath));
    }
}
