package org.telegram.telegrambots.bots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DefaultAbsSender_DefaultAbsSender_3643a22c20_Test {

    private TestDefaultAbsSender defaultAbsSender;
    private DefaultBotOptions options;
    private String botToken = "testBotToken";

    @BeforeEach
    public void setUp() {
        options = new DefaultBotOptions();
        options.setMaxThreads(5);
    }

    @Test
    public void testDefaultAbsSender_WithNonNullOptionsAndBotToken() {
        defaultAbsSender = new TestDefaultAbsSender(options, botToken);
        assertNotNull(defaultAbsSender);
        assertEquals(botToken, defaultAbsSender.getBotToken());
    }

    @Test
    public void testDefaultAbsSender_WithNullOptions() {
        defaultAbsSender = new TestDefaultAbsSender(null, botToken);
        assertNotNull(defaultAbsSender);
        assertEquals(botToken, defaultAbsSender.getBotToken());
    }

    @Test
    public void testDefaultAbsSender_WithNullBotToken() {
        defaultAbsSender = new TestDefaultAbsSender(options, null);
        assertNotNull(defaultAbsSender);
        assertEquals(null, defaultAbsSender.getBotToken());
    }

    @Test
    public void testDefaultAbsSender_WithNullOptionsAndBotToken() {
        defaultAbsSender = new TestDefaultAbsSender(null, null);
        assertNotNull(defaultAbsSender);
        assertEquals(null, defaultAbsSender.getBotToken());
    }

    private class TestDefaultAbsSender extends DefaultAbsSender {
        public TestDefaultAbsSender(DefaultBotOptions options, String botToken) {
            super(options, botToken);
        }

        @Override
        public String getBotToken() {
            return botToken;
        }
    }
}
