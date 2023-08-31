package org.telegram.telegrambots.bots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.bots.DefaultBotOptions;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DefaultAbsSender_DefaultAbsSender_2e312b22f6_Test {

    private DefaultBotOptions options;
    private DefaultAbsSender sender;

    @BeforeEach
    void setUp() {
        options = Mockito.mock(DefaultBotOptions.class);
        sender = Mockito.mock(DefaultAbsSender.class);
        when(sender.getOptions()).thenReturn(options);
    }

    @Test
    void testDefaultAbsSenderWithNonNullOptions() {
        assertNotNull(sender);
        assertEquals(options, sender.getOptions());
    }

    @Test
    void testDefaultAbsSenderWithNullOptions() {
        DefaultAbsSender nullSender = Mockito.mock(DefaultAbsSender.class);
        when(nullSender.getOptions()).thenReturn(null);
        assertNull(nullSender.getOptions());
    }
}
