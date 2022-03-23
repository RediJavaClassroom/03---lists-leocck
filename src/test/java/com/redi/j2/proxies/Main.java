package com.redi.j2.proxies;

import com.redi.j2.utils.ReflectionProxy;

import java.util.List;

public class Main extends ReflectionProxy {

    @Override
    public String getTargetClassName() {
        return "com.redi.j2.Main";
    }

    public static void printReversedList(List<Integer> listToPrint){
        Main main = new Main();
        if(main.getTarget() == null) {
            return;
        }
        main.invokeMethod("printReversedList", new Class[]{List.class}, listToPrint);
    }

    public static List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
        Main main = new Main();
        if(main.getTarget() == null) {
            return null;
        }
        return main.invokeMethod("mergeLists", new Class[]{List.class, List.class}, list1, list2);
    }

    public static int findFirstInList(List<String> list, String search) {
        Main main = new Main();
        if(main.getTarget() == null) {
            return -1;
        }
        return main.invokeMethod("findFirstInList", new Class[]{List.class, String.class}, list, search);
    }

    public int findLastInList(List<String> list, String search) {
        Main main = new Main();
        if(main.getTarget() == null) {
            return -1;
        }
        return main.invokeMethod("findLastInList", new Class[]{List.class, String.class}, list, search);
    }

    public static Integer secondSmallest(List<Integer> list) {
        Main main = new Main();
        if(main.getTarget() == null) {
            return null;
        }
        return main.invokeMethod("secondSmallest", new Class[]{List.class}, list);
    }
}
