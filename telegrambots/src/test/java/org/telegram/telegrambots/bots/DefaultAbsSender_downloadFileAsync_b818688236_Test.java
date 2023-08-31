package org.telegram.telegrambots.bots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

public class DefaultAbsSender_downloadFileAsync_b818688236_Test {

    @InjectMocks
    private DefaultAbsSender defaultAbsSender;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDownloadFileAsync_Success() throws TelegramApiException {
        String filePath = "testFilePath";

        defaultAbsSender.downloadFileAsync(filePath, null);

        // verify logic here if there's a method to verify in DefaultAbsSender
    }

    @Test
    public void testDownloadFileAsync_TelegramApiException() throws TelegramApiException {
        String filePath = "testFilePath";

        doThrow(TelegramApiException.class).when(defaultAbsSender).downloadFileAsync(any(), any());

        try {
            defaultAbsSender.downloadFileAsync(filePath, null);
        } catch (TelegramApiException e) {
            // verify logic here if there's a method to verify in DefaultAbsSender
        }
    }
}
