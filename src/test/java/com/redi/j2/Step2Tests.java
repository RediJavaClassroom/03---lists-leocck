package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.Main;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Step2Tests {

    @Test
    void task_2_1_shouldDefineMergeListsMethod()
    {
        // given - the Main class
        Main main = Fixtures.createMain();

        // then - the method exists
        assertTrue(main.hasMethod("mergeLists", List.class, List.class),
                "Could not find the method 'mergeLists', which receives two List<Integer> as parameter");

        // and - the List parameter has the right type
        assertTrue(main.isMethodParameterFromGenericType("mergeLists", new Class[] {List.class, List.class}, new Class[] {Integer.class, Integer.class}),
                "Could not find the method 'mergeLists', which receives two List<Integer> as parameter");

        // and - the method is public
        assertTrue(main.isMethodPublic("mergeLists", List.class, List.class),
                "Method 'mergeLists' must be public");

        // and - the method is static
        assertTrue(main.isMethodStatic("mergeLists", List.class, List.class),
                "Method 'mergeLists' must be static");

        // and - the method should return 'List<Integer>'
        assertTrue(main.isMethodReturnType(List.class, Integer.class, "mergeLists", List.class, List.class),
                "Method 'mergeLists' should return a List<Integer>");
    }

    @Test
    void task_2_2_shouldMergeTwoLists()
    {
        // given - the Main class
        Main main = Fixtures.createMain();

        // and two lists of numbers
        List<Integer> list1 = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(5, 6, 7, 8, 9);

        // when - you run the 'mergeLists' method
        List<Integer> result = main.mergeLists(list1, list2);
        List<Integer> result2 = main.mergeLists(list1, list1);

        // then - the result should be what is expected
        assertEquals(Arrays.asList(0, 5, 1, 6, 2, 7, 3, 8, 4, 9), result,
                "The 'mergeLists' does not work correct for inputs [0, 1, 2, 3, 4] and [5, 6, 7, 8, 9]");
        assertEquals(Arrays.asList(0, 0, 1, 1, 2, 2, 3, 3, 4, 4), result2,
                "The 'mergeLists' does not work correct for inputs [0, 1, 2, 3, 4] and [0, 1, 2, 3, 4]");

        // and - the original lists are not changed by the method
        assertTrue(Arrays.asList(0, 1, 2, 3, 4).equals(list1),
                "The 'mergeLists' method should not change the elements of the parameter Lists");
        assertTrue(Arrays.asList(5, 6, 7, 8, 9).equals(list2),
                "The 'mergeLists' method should not change the elements of the parameter Lists");
    }

    @Test
    void task_2_3_shouldWorkWithDifferentSizes()
    {
        // given - the Main class
        Main main = Fixtures.createMain();

        // and two lists of numbers
        List<Integer> list1 = Arrays.asList(0, 1, 2);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);

        // when - you run the 'mergeLists' method
        List<Integer> result1 = main.mergeLists(list1, list2);
        List<Integer> result2 = main.mergeLists(list2, list1);

        // then - the result should be what is expected
        assertEquals(Arrays.asList(0, 3, 1, 4, 2, 5, 6, 7), result1,
                "The 'mergeLists' does not work correct for inputs [0, 1, 2] and [3, 4, 5, 6, 7]");
        assertEquals(Arrays.asList(3, 0, 4, 1, 5, 2, 6, 7), result2,
                "The 'mergeLists' does not work correct for inputs [3, 4, 5, 6, 7] and [0, 1, 2]");

        // and - the original lists are not changed by the method
        assertTrue(Arrays.asList(0, 1, 2).equals(list1),
                "The 'mergeLists' method should not change the elements of the parameter Lists");
        assertTrue(Arrays.asList(3, 4, 5, 6, 7).equals(list2),
                "The 'mergeLists' method should not change the elements of the parameter Lists");
    }

    @Test
    void task_2_4_shouldWorkWithEmptyLists()
    {
        // given - the Main class
        Main main = Fixtures.createMain();

        // and two lists of numbers
        List<Integer> list1 = Arrays.asList(0, 1, 2);
        List<Integer> list2 = Arrays.asList();

        // when - you run the 'mergeLists' method
        List<Integer> result1 = main.mergeLists(list1, list2);
        List<Integer> result2 = main.mergeLists(list2, list1);
        List<Integer> result3 = main.mergeLists(Arrays.asList(), Arrays.asList());

        // then - the result should be what is expected
        assertEquals(Arrays.asList(0, 1, 2), result1,
                "The 'mergeLists' does not work correct for inputs [0, 1, 2] and []");
        assertEquals(Arrays.asList(0, 1, 2), result2,
                "The 'mergeLists' does not work correct for inputs [] and [0, 1, 2]");
        assertEquals(Arrays.asList(), result3,
                "The 'mergeLists' does not work correct for inputs [] and []");

        // and - the original lists are not changed by the method
        assertTrue(Arrays.asList(0, 1, 2).equals(list1),
                "The 'mergeLists' method should not change the elements of the parameter Lists");
        assertTrue(Arrays.asList().equals(list2),
                "The 'mergeLists' method should not change the elements of the parameter Lists");
    }
}
