package org.telegram.telegrambots.bots;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.bots.DefaultBotOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doReturn;

public class DefaultAbsSender_getOptions_ce82a6b16f_Test {

    private DefaultAbsSender defaultAbsSender;
    private DefaultBotOptions defaultBotOptions;

    @BeforeEach
    public void setUp() {
        defaultBotOptions = new DefaultBotOptions();
        defaultAbsSender = Mockito.mock(DefaultAbsSender.class, Mockito.RETURNS_DEEP_STUBS);
        doReturn(defaultBotOptions).when(defaultAbsSender).getOptions();
    }

    @Test
    public void testGetOptionsSuccess() {
        DefaultBotOptions result = defaultAbsSender.getOptions();
        assertEquals(defaultBotOptions, result);
    }

    @Test
    public void testGetOptionsFailure() {
        doReturn(null).when(defaultAbsSender).getOptions();
        DefaultBotOptions result = defaultAbsSender.getOptions();
        assertNull(result);
    }
}
