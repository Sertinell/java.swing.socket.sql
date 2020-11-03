/*package usantatecla.utils;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class ConsoleTest {

    @Mock
    private BufferedReader bufferedReader;

    @InjectMocks
    private Console console = new Console();

    @Test
    public void testGivenNewConsoleWhenReadLineCorrectStringThenIsCorrect() throws IOException {
        when(this.bufferedReader.readLine()).thenReturn("1");
        assertEquals("1", this.console.readString(""));
    }

    @Test
    public void testGivenNewConsoleWhenReadLineCorrectStringIntegerThenIsCorrect() throws IOException {
        when(this.bufferedReader.readLine()).thenReturn("1");
        assertEquals(1, this.console.readInt(""));
    }

    @Test
    public void testGivenNewConsoleWhenReadLineCorrectStringIntegerThenIsInCorrect() throws IOException {
        when(this.bufferedReader.readLine()).thenReturn("a");
        assertThrows(AssertionError.class, () -> this.console.readChar(""));
        //assertEquals(1, this.console.readInt(""));
    }

    @Test
    public void testGivenNewConsoleWhenReadLineCorrectStringCharThenIsCorrect() throws IOException {
        when(this.bufferedReader.readLine()).thenReturn("a");
        assertEquals('a', this.console.readChar(""));
    }

    @Test
    public void testGivenNewConsoleWhenReadLineCorrectStringCharThenIsInCorrect() throws IOException {
        when(this.bufferedReader.readLine()).thenReturn("a");
        assertThrows(AssertionError.class, () -> this.console.readChar(""));
        //assertEquals(1, this.console.readChar(""));
    }

}*/