package com.epam;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class AppTest {

    private final String[] input;
    private final String expectedOutput;
    private final boolean expectException;

    public AppTest(String[] input, String expectedOutput, boolean expectException) {
        this.input = input;
        this.expectedOutput = expectedOutput;
        this.expectException = expectException;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][]{

                {new String[]{}, "No arguments", true},


                {new String[]{"5"}, "5 ", false},


                {new String[]{"10", "9", "8", "7", "6", "5", "4", "3", "2", "1"},
                        "1 2 3 4 5 6 7 8 9 10 ", false},


                {new String[]{"12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"},
                        "Too many of arguments", true}
        });
    }

    @Test
    public void testSorting() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        try {
            App.main(input);
            if (expectException) {
                fail("Expected exception but none was thrown");
            }
            assertEquals(expectedOutput, outContent.toString());
        } catch (RuntimeException e) {
            if (!expectException) {
                fail("Unexpected exception: " + e.getMessage());
            }
            assertEquals(expectedOutput, e.getMessage());
        }
    }
}
