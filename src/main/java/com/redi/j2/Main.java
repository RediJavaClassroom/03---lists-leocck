package com.redi.j2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

    }

    public static void printReversedList(List<Integer> list) {

        System.out.print("[");
        for (int i = list.size()-1; i >= 0; i--) {
            System.out.print(list.get(i));
            if (i>0) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static List<Integer> mergeLists(List<Integer> input1, List<Integer> input2) {

        List<Integer> response = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>(input1); // copying list so it doesn't change the original
        List<Integer> list2 = new ArrayList<>(input2); // copying list so it doesn't change the original

        while(list1.size() > 0 || list2.size() > 0) {

            if (list1.size() > 0) {
                Integer element = list1.remove(0);
                response.add(element);
            }
            if (list2.size() > 0) {
                Integer element = list2.remove(0);
                response.add(element);
            }
        }

        return response;
    }

    public static int findFirstInList(List<String> strings, String search) {
        int i = 0;
        for (String s : strings) {
            if (s.equalsIgnoreCase(search)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int findLastInList(List<String> strings, String search) {
        for (int i = strings.size()-1; i >= 0; i--) {
            if (strings.get(i).equalsIgnoreCase(search)) {
                return i;
            }
        }
        return -1;
    }

    public static Integer secondSmallest(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) return null;
        int firstSmallest = numbers.get(0);
        int secondSmallest = numbers.get(0);
        for(int i=1; i<numbers.size(); i++) {
            int number = numbers.get(i);
            if (number < firstSmallest) {
                secondSmallest = firstSmallest;
                firstSmallest = number;
            }
            else if (number < secondSmallest) {
                secondSmallest = number;
            }
            else if (secondSmallest == firstSmallest) {
                secondSmallest = number;
            }
        }
        return secondSmallest;
    }
}
