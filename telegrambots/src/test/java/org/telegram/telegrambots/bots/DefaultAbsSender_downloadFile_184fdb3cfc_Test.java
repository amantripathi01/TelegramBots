package org.telegram.telegrambots.bots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.telegram.telegrambots.facilities.filedownloader.TelegramFileDownloader;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class DefaultAbsSender_downloadFile_184fdb3cfc_Test {

    @Mock
    private TelegramFileDownloader telegramFileDownloader;

    @InjectMocks
    private DefaultAbsSender defaultAbsSender = new DefaultAbsSender();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDownloadFileSuccess() throws TelegramApiException {
        String filePath = "testPath";
        File outputFile = new File("testOutput");

        when(telegramFileDownloader.downloadFile(filePath, outputFile)).thenReturn(outputFile);

        File result = defaultAbsSender.downloadFile(filePath, outputFile);

        assertEquals(outputFile, result);
    }

    @Test
    public void testDownloadFileFailure() throws TelegramApiException {
        String filePath = "testPath";
        File outputFile = new File("testOutput");

        when(telegramFileDownloader.downloadFile(filePath, outputFile)).thenThrow(TelegramApiException.class);

        assertThrows(TelegramApiException.class, () -> defaultAbsSender.downloadFile(filePath, outputFile));
    }
}
