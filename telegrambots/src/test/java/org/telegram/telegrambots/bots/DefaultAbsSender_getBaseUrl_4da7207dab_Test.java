package org.telegram.telegrambots.bots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DefaultAbsSender_getBaseUrl_4da7207dab_Test {

    @Mock
    private DefaultBotOptions options;

    @InjectMocks
    private TestDefaultAbsSender defaultAbsSender;

    @BeforeEach
    public void setUp() {
        defaultAbsSender = new TestDefaultAbsSender(options);
    }

    @Test
    public void testGetBaseUrl_success() {
        when(options.getBaseUrl()).thenReturn("https://api.telegram.org/bot");
        when(defaultAbsSender.getBotToken()).thenReturn("123456:ABC-DEF1234ghIkl-zyx57W2v1u123ew11");
        String expected = "https://api.telegram.org/bot123456:ABC-DEF1234ghIkl-zyx57W2v1u123ew11/";
        assertEquals(expected, defaultAbsSender.getBaseUrl());
    }

    @Test
    public void testGetBaseUrl_emptyBaseUrl() {
        when(options.getBaseUrl()).thenReturn("");
        when(defaultAbsSender.getBotToken()).thenReturn("123456:ABC-DEF1234ghIkl-zyx57W2v1u123ew11");
        String expected = "123456:ABC-DEF1234ghIkl-zyx57W2v1u123ew11/";
        assertEquals(expected, defaultAbsSender.getBaseUrl());
    }

    @Test
    public void testGetBaseUrl_emptyBotToken() {
        when(options.getBaseUrl()).thenReturn("https://api.telegram.org/bot");
        when(defaultAbsSender.getBotToken()).thenReturn("");
        String expected = "https://api.telegram.org/bot/";
        assertEquals(expected, defaultAbsSender.getBaseUrl());
    }

    @Test
    public void testGetBaseUrl_emptyBaseUrlAndBotToken() {
        when(options.getBaseUrl()).thenReturn("");
        when(defaultAbsSender.getBotToken()).thenReturn("");
        String expected = "/";
        assertEquals(expected, defaultAbsSender.getBaseUrl());
    }

    private class TestDefaultAbsSender extends DefaultAbsSender {
        public TestDefaultAbsSender(DefaultBotOptions options) {
            super(options);
        }

        @Override
        public String getBotToken() {
            return "";
        }
    }
}
