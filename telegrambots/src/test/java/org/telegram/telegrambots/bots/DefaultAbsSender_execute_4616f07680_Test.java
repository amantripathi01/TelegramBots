package org.telegram.telegrambots.bots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.updateshandlers.DownloadFileCallback;

public class DefaultAbsSender_downloadFileAsync_be466ba670_Test {

    @Mock
    private DefaultAbsSender defaultAbsSender;
    @Mock
    private File file;
    @Mock
    private DownloadFileCallback<File> callback;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDownloadFileAsync() {
        defaultAbsSender.downloadFileAsync(file, callback);
    }
}
