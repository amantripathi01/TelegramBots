package org.telegram.telegrambots.bots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.updateshandlers.DownloadFileCallback;

import static org.mockito.Mockito.*;

public class DefaultAbsSender_downloadFileAsync_be466ba670_Test {

    @InjectMocks
    private DefaultAbsSender defaultAbsSender;
    
    private Object telegramFileDownloader;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        telegramFileDownloader = mock(Object.class);
    }

    @Test
    public void testDownloadFileAsyncSuccess() throws TelegramApiException {
        File fileMock = mock(File.class);
        DownloadFileCallback<File> callbackMock = mock(DownloadFileCallback.class);

        doNothing().when(telegramFileDownloader).downloadFileAsync(fileMock, callbackMock);
        
        defaultAbsSender.downloadFileAsync(fileMock, callbackMock);

        verify(telegramFileDownloader, times(1)).downloadFileAsync(fileMock, callbackMock);
    }

    @Test
    public void testDownloadFileAsyncFailure() throws TelegramApiException {
        File fileMock = mock(File.class);
        DownloadFileCallback<File> callbackMock = mock(DownloadFileCallback.class);

        doThrow(new TelegramApiException("Failed to download file")).when(telegramFileDownloader).downloadFileAsync(fileMock, callbackMock);

        try {
            defaultAbsSender.downloadFileAsync(fileMock, callbackMock);
        } catch (TelegramApiException e) {
            assertEquals("Failed to download file", e.getMessage());
        }

        verify(telegramFileDownloader, times(1)).downloadFileAsync(fileMock, callbackMock);
    }
}
