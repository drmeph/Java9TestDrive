package com.drmeph.java9testdrive;

import java.util.*;

/**
 * With Java 9, new factory methods are added to List, Set and Map interfaces to create immutable instances.
 * These factory methods are convenience factory methods to create a collection in less verbose and in concise way.
 */
public class CollectionFactoryMethodsTester {

    public static void main(String[] args) {

        /*
            The old way !
         */
        System.out.println("The old way !");

        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        set = Collections.unmodifiableSet(set);
        System.out.println(set);
        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list = Collections.unmodifiableList(list);
        System.out.println(list);
        Map<String, String> map = new HashMap<>();

        map.put("A","Apple");
        map.put("B","Boy");
        map.put("C","Cat");
        map = Collections.unmodifiableMap(map);
        System.out.println(map);

        /*
            Starting from Java 9 way !!
         */
        System.out.println("Starting from Java 9 way !!");

        Set<String> set2 = Set.of("A", "B", "C");
        System.out.println(set2);
        List<String> list2 = List.of("A", "B", "C");
        System.out.println(list2);
        Map<String, String> map2 = Map.of("A","Apple","B","Boy","C","Cat");
        System.out.println(map2);

        Map<String, String> map1 = Map.ofEntries (
                new AbstractMap.SimpleEntry<>("A","Apple"),
                new AbstractMap.SimpleEntry<>("B","Boy"),
                new AbstractMap.SimpleEntry<>("C","Cat"));
        System.out.println(map1);
    }
}
