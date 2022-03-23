package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.Main;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Step3Tests {

    @Test
    void task_3_1_shouldDefineFindFirstInListMethod()
    {
        // given - the Main class
        Main main = Fixtures.createMain();

        // then - the method exists
        assertTrue(main.hasMethod("findFirstInList", List.class, String.class),
                "Could not find the method 'findFirstInList', which receives a List<Integer> and a String as parameters");

        // and - the List parameter has the right type
        assertTrue(main.isMethodParameterFromGenericType("findFirstInList", new Class[] {List.class, String.class}, new Class[] {String.class, null}),
                "Could not find the method 'findFirstInList', which receives a List<String> and a String as parameters");

        // and - the method is public
        assertTrue(main.isMethodPublic("findFirstInList", List.class, String.class),
                "Method 'findFirstInList' must be public");

        // and - the method is static
        assertTrue(main.isMethodStatic("findFirstInList", List.class, String.class),
                "Method 'findFirstInList' must be static");

        // and - the method should return an int
        assertTrue(main.isMethodReturnType(int.class, "findFirstInList", List.class, String.class),
                "Method 'findFirstInList' should return an int");
    }

    @Test
    void task_3_2_shouldFindTheFirstString()
    {
        // given - the Main class
        Main main = Fixtures.createMain();

        // and - a List with Strings
        List<String> list = Arrays.asList("Germany", "Japan", "Austria", "France", "Poland", "France");

        // when - we try to find an existing string
        int result = main.findFirstInList(list, "France");

        // then - the result should be the index position of this string
        assertEquals(3, result,
                "The 'findFirstInList' does not work correct for inputs " + list.toString() + " and 'France'");
    }

    @Test
    void task_3_3_shouldWorkWithNonexistentSearch()
    {
        // given - the Main class
        Main main = Fixtures.createMain();

        // and - a List with Strings
        List<String> list = Arrays.asList("Germany", "Japan", "Austria", "France", "Poland");

        // when - we try to find an unexisting string
        int result = main.findFirstInList(list, "Brazil");

        // then - the result should be the index position of this string
        assertEquals(-1, result,
                "The 'findFirstInList' does not work correct for inputs " + list.toString() + " and 'Brazil'");
    }

    @Test
    void task_3_4_shouldIgnoreCase()
    {
        // given - the Main class
        Main main = Fixtures.createMain();

        // and - a List with Strings
        List<String> list = Arrays.asList("Germany", "Japan", "Austria", "France", "Poland");

        // when - we try to find an existing string
        int result = main.findFirstInList(list, "francE");

        // then - the result should be the index position of this string
        assertEquals(3, result,
                "The 'findFirstInList' does not work correct for inputs " + list.toString() + " and 'francE'");
    }

    @Test
    void task_3_4_shouldWorkWithEmptyLists()
    {
        // given - the Main class
        Main main = Fixtures.createMain();

        // and - a List with Strings
        List<String> list = Arrays.asList();

        // when - we try to find an existing string
        int result = main.findFirstInList(list, "a");

        // then - the result should be the index position of this string
        assertEquals(-1, result,
                "The 'findFirstInList' does not work correct for inputs " + list.toString() + " and 'a'");
    }

    @Test
    void task_3_5_shouldDefineFindLastInListMethod()
    {
        // given - the Main class
        Main main = Fixtures.createMain();

        // then - the method exists
        assertTrue(main.hasMethod("findLastInList", List.class, String.class),
                "Could not find the method 'findLastInList', which receives a List<Integer> and a String as parameters");

        // and - the List parameter has the right type
        assertTrue(main.isMethodParameterFromGenericType("findLastInList", new Class[] {List.class, String.class}, new Class[] {String.class, null}),
                "Could not find the method 'findLastInList', which receives a List<String> and a String as parameters");

        // and - the method is public
        assertTrue(main.isMethodPublic("findLastInList", List.class, String.class),
                "Method 'findLastInList' must be public");

        // and - the method is static
        assertTrue(main.isMethodStatic("findLastInList", List.class, String.class),
                "Method 'findLastInList' must be static");

        // and - the method should return an int
        assertTrue(main.isMethodReturnType(int.class, "findLastInList", List.class, String.class),
                "Method 'findLastInList' should return an int");
    }

    @Test
    void task_3_6_shouldFindTheLastString()
    {
        // given - the Main class
        Main main = Fixtures.createMain();

        // and - a List with Strings
        List<String> list = Arrays.asList("Germany", "Japan", "Austria", "France", "Poland", "France");

        // when - we try to find an existing string
        int result = main.findLastInList(list, "France");

        // then - the result should be the index position of this string
        assertEquals(5, result,
                "The 'findLastInList' does not work correct for inputs " + list.toString() + " and 'France'");
    }

    @Test
    void task_3_7_shouldWorkWithNonexistentSearch()
    {
        // given - the Main class
        Main main = Fixtures.createMain();

        // and - a List with Strings
        List<String> list = Arrays.asList("Germany", "Japan", "Austria", "France", "Poland");

        // when - we try to find an unexisting string
        int result = main.findLastInList(list, "Brazil");

        // then - the result should be the index position of this string
        assertEquals(-1, result,
                "The 'findLastInList' does not work correct for inputs " + list.toString() + " and 'Brazil'");
    }

    @Test
    void task_3_7_shouldIgnoreCase()
    {
        // given - the Main class
        Main main = Fixtures.createMain();

        // and - a List with Strings
        List<String> list = Arrays.asList("Germany", "Japan", "Austria", "France", "Poland");

        // when - we try to find an existing string
        int result = main.findLastInList(list, "francE");

        // then - the result should be the index position of this string
        assertEquals(3, result,
                "The 'findLastInList' does not work correct for inputs " + list.toString() + " and 'francE'");
    }

    @Test
    void task_3_7_shouldWorkWithEmptyLists()
    {
        // given - the Main class
        Main main = Fixtures.createMain();

        // and - a List with Strings
        List<String> list = Arrays.asList();

        // when - we try to find an existing string
        int result = main.findLastInList(list, "a");

        // then - the result should be the index position of this string
        assertEquals(-1, result,
                "The 'findLastInList' does not work correct for inputs " + list.toString() + " and 'a'");
    }
}
