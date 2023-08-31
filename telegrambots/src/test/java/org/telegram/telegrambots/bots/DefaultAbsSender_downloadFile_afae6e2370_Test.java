package org.telegram.telegrambots.bots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DefaultAbsSender_downloadFile_afae6e2370_Test {

    @Mock
    private DefaultAbsSender defaultAbsSenderMock;

    @InjectMocks
    private DefaultAbsSender defaultAbsSender;

    private File file;

    @BeforeEach
    public void setUp() {
        file = new File();
        file.setFilePath("testFilePath");
    }

    @Test
    public void testDownloadFileSuccess() throws TelegramApiException {
        java.io.File expectedFile = new java.io.File("testFilePath");
        when(defaultAbsSenderMock.downloadFile(file)).thenReturn(expectedFile);

        java.io.File actualFile = defaultAbsSender.downloadFile(file);

        assertEquals(expectedFile, actualFile);
        verify(defaultAbsSenderMock, times(1)).downloadFile(file);
    }

    @Test
    public void testDownloadFileFailure() throws TelegramApiException {
        when(defaultAbsSenderMock.downloadFile(file)).thenThrow(TelegramApiException.class);

        assertThrows(TelegramApiException.class, () -> defaultAbsSender.downloadFile(file));
        verify(defaultAbsSenderMock, times(1)).downloadFile(file);
    }
}
