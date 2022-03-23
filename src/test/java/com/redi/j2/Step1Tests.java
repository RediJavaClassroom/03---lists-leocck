package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Step1Tests {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStream() {
        System.setOut(originalOut);
    }

    @Test
    void task_1_1_shouldDefinePrintReversedListMethod()
    {
        // given - the Main class
        Main main = Fixtures.createMain();

        // then - the method exists
        assertTrue(main.hasMethod("printReversedList", List.class),
                "Could not find the method 'printReversedList', which receives a List<Integer> as parameter");

        // and - the List parameter has the right type
        assertTrue(main.isMethodParameterFromGenericType("printReversedList", new Class[] {List.class}, new Class[] {Integer.class}),
                "Could not find the method 'printReversedList', which receives a List<Integer> as parameter");

        // and - the method is public
        assertTrue(main.isMethodPublic("printReversedList", List.class),
                "Method 'printReversedList' must be public");

        // and - the method is static
        assertTrue(main.isMethodStatic("printReversedList", List.class),
                "Method 'printReversedList' must be static");

        // and - the method should return 'void'
        assertTrue(main.isMethodReturnType(void.class, "printReversedList", List.class),
                "Method 'printReversedList' should return void");
    }

    @Test
    void task_1_2_shouldPrintReversedList()
    {
        // given - the Main class
        Main main = Fixtures.createMain();

        // and a list of numbers
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4);

        // and - the console output set
        setUpStream();

        // when - you run the 'printReversedList' method
        main.printReversedList(numbers);

        // then - the reversed list should be printed in the default system output
        List<Integer> reversed = Arrays.asList(4, 3, 2, 1, 0);
        assertTrue(outContent.toString().contains(reversed.toString()),
                "The 'printReversedList' does not work correct for input [0, 1, 2, 3, 4]. It should print [4, 3, 2, 1, 0] in the default output.");
    }

    @Test
    void task_1_2_shouldWorkOneSingleElement()
    {
        // given - the Main class
        Main main = Fixtures.createMain();

        // and a list of numbers
        List<Integer> numbers = Arrays.asList(7);

        // and - the console output set
        setUpStream();

        // when - you run the 'printReversedList' method
        main.printReversedList(numbers);

        // then - the reversed list should be the same as the original list
        assertTrue(outContent.toString().contains(numbers.toString()),
                "The 'printReversedList' does not work correct for one single element [7]. It should print [7] in the default output.");
    }

    @Test
    void task_1_2_shouldWorkWithEmptyList()
    {
        // given - the Main class
        Main main = Fixtures.createMain();

        // and a list of numbers
        List<Integer> numbers = Arrays.asList();

        // and - the console output set
        setUpStream();

        // when - you run the 'printReversedList' method
        main.printReversedList(numbers);

        // then - the reversed list should be printed in the default system output
        List<Integer> reversed = Arrays.asList();
        assertTrue(outContent.toString().contains(reversed.toString()),
                "The 'printReversedList' does not work correct for an empty list as input. It should print [] in the default output.");
    }
}
