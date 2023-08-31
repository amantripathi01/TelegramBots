package org.telegram.telegrambots.bots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DefaultAbsSender_downloadFile_a24a297aa2_Test {

    @InjectMocks
    private DefaultAbsSender defaultAbsSender;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDownloadFileSuccess() throws TelegramApiException, IOException {
        File mockFile = mock(File.class);
        java.io.File mockOutputFile = Files.createTempFile("temp", ".txt").toFile();

        when(defaultAbsSender.downloadFile(mockFile.getFileId())).thenReturn(mockOutputFile);

        java.io.File result = defaultAbsSender.downloadFile(mockFile.getFileId());

        assertEquals(mockOutputFile, result);
    }

    @Test
    public void testDownloadFileFailure() throws TelegramApiException, IOException {
        File mockFile = mock(File.class);

        when(defaultAbsSender.downloadFile(mockFile.getFileId())).thenThrow(TelegramApiException.class);

        assertThrows(TelegramApiException.class, () -> defaultAbsSender.downloadFile(mockFile.getFileId()));
    }
}
