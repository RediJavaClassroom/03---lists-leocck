package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.Main;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Step4Tests {

    @Test
    void task_4_1_shouldDefineSecondSmallestMethod()
    {
        // given - the Main class
        Main main = Fixtures.createMain();

        // then - the method exists
        assertTrue(main.hasMethod("secondSmallest", List.class),
                "Could not find the method 'secondSmallest', which receives a List<Integer> as parameter");

        // and - the List parameter has the right type
        assertTrue(main.isMethodParameterFromGenericType("secondSmallest", new Class[] {List.class}, new Class[] {Integer.class}),
                "Could not find the method 'secondSmallest', which receives a List<Integer> as parameter");

        // and - the method is public
        assertTrue(main.isMethodPublic("secondSmallest", List.class),
                "Method 'secondSmallest' must be public");

        // and - the method is static
        assertTrue(main.isMethodStatic("secondSmallest", List.class),
                "Method 'secondSmallest' must be static");

        // and - the method should return 'List<Integer>'
        assertTrue(main.isMethodReturnType(Integer.class, "secondSmallest", List.class),
                "Method 'secondSmallest' should return an Integer");
    }

    @Test
    void task_4_2_shouldFindTheSecondSmallest()
    {
        // given - the Main class
        Main main = Fixtures.createMain();

        // and a lists of numbers
        List<Integer> list1 = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(4, 3, 2, 1, 0);
        List<Integer> list3 = Arrays.asList(1, 3, 4, 1, 4, 2);
        List<Integer> list4 = Arrays.asList(7);

        // when - you run the 'secondSmallest' method
        Integer result1 = main.secondSmallest(list1);
        Integer result2 = main.secondSmallest(list2);
        Integer result3 = main.secondSmallest(list3);
        Integer result4 = main.secondSmallest(list4);

        // then - the result should be what is expected
        assertEquals(1, result1,
                "The 'secondSmallest' does not work correct for input [0, 1, 2, 3, 4]");
        assertEquals(1, result2,
                "The 'secondSmallest' does not work correct for input [4, 3, 2, 1, 0]");
        assertEquals(2, result3,
                "The 'secondSmallest' does not work correct for input [1, 3, 4, 1, 4, 2]");
        assertEquals(7, result4,
                "The 'secondSmallest' does not work correct for input [7]");

        // and - the original list is not changed by the method
        assertTrue(Arrays.asList(0, 1, 2, 3, 4).equals(list1),
                "The 'secondSmallest' method should not change the elements of the parameter List");
        assertTrue(Arrays.asList(4, 3, 2, 1, 0).equals(list2),
                "The 'secondSmallest' method should not change the elements of the parameter List");
        assertTrue(Arrays.asList(1, 3, 4, 1, 4, 2).equals(list3),
                "The 'secondSmallest' method should not change the elements of the parameter List");
        assertTrue(Arrays.asList(7).equals(list4),
                "The 'secondSmallest' method should not change the elements of the parameter List");
    }

    @Test
    void task_4_3_shouldWorkWithEmptyList()
    {
        // given - the Main class
        Main main = Fixtures.createMain();

        // and a lists of numbers
        List<Integer> list1 = Arrays.asList();

        // when - you run the 'secondSmallest' method
        Integer result1 = main.secondSmallest(list1);

        // then - the result should be what is expected
        assertEquals(null, result1,
                "The 'secondSmallest' does not work correct for input []");

        // and - the original list is not changed by the method
        assertTrue(Arrays.asList().equals(list1),
                "The 'secondSmallest' method should not change the elements of the parameter List");
    }
}
