package com.nav.java8.streams;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Java8Streams {

    public static void main(String[] args) {
        System.out.println("-----------Java8 Streams-----------");
        firstPredicates();
    }

    private static void firstPredicates() {
        System.out.println("------Example 1 First Predicates-------");
        /*------------------------------------------------------------------------*/
        Stream<String> stream1 = Stream.of("one", "two", "three", "four", "five");

        System.out.println("Without Filters");
        stream1
                .forEach(s -> System.out.println(s));
        /*------------------------------------------------------------------------*/
        System.out.println("Filter - Length > 3");

        Predicate<String> p1 = s -> s.length() > 3;

        Stream<String> stream2 = Stream.of("one", "two", "three", "four", "five");
        stream2
                .filter(p1)
                .forEach(s -> System.out.println(s));
        /*------------------------------------------------------------------------*/
        System.out.println("Filter - Equal to two");

        Predicate<String> p2 = Predicate.isEqual("two");

        Stream<String> stream3 = Stream.of("one", "two", "three", "four", "five");
        stream3
                .filter(p2)
                .forEach(s -> System.out.println(s));
        /*------------------------------------------------------------------------*/
        System.out.println("Filter - Equal to two or three");

        Predicate<String> p3 = Predicate.isEqual("three");

        Stream<String> stream4 = Stream.of("one", "two", "three", "four", "five");
        stream4
                .filter(p2.or(p3))
                .forEach(s -> System.out.println(s));
        /*------------------------------------------------------------------------*/
    }
}
