package com.nav.java8.lambdas;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;

public class Java8Lambdas {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("-----------Java8 Lambdas-----------");
        fileFilter();
        runnable();
        comparator();
        systemOutPrint();
        consumer();
    }

    private static void fileFilter() {
        System.out.println("------Example 1 FileFilter-------");

        //Java7
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };

        File dir = new File("src/main/resources");
        File[] files = dir.listFiles(fileFilter);

        for (File f: files) {
            System.out.println(f);
        }

        //Java8 Lambda
        FileFilter filterLambda = (File pathname) -> pathname.getName().endsWith(".java");
        files = dir.listFiles(filterLambda);
        for (File f: files) {
            System.out.println(f);
        }
    }

    private static void runnable() throws InterruptedException {
        System.out.println("------Example 2 Runnable-------");

        //Java7
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<3; i++) {
                    System.out.println("Hello world from thread [" + Thread.currentThread().getName() + "]");
                }
            }
        };

        Thread t = new Thread(runnable);
        t.start();
        t.join();

        //Java8 Lambda

        Runnable runnableLambda = () -> {
            for (int i=0; i<3; i++) {
                System.out.println("Hello world from thread [" + Thread.currentThread().getName() + "]");
            }
        };

        t = new Thread(runnable);
        t.start();
        t.join();

    }

    private static void comparator() {
        System.out.println("------Example 3 Comparator-------");

        //Java7
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };

        List<String> list = Arrays.asList("***", "**", "****", "*");
        Collections.sort(list, comp);

        for (String s: list) {
            System.out.println(s);
        }

        //Java8 Lambda

        Comparator<String> compLambda = (String o1, String o2) -> Integer.compare(o1.length(), o2.length());
        list = Arrays.asList("***", "**", "****", "*");
        Collections.sort(list, compLambda);

        for (String s: list) {
            System.out.println(s);
        }

        //Another way
        Comparator<String> compLambda2 = (o1, o2) -> Integer.compare(o1.length(), o2.length());
        list = Arrays.asList("***", "**", "****", "*");
        Collections.sort(list, compLambda);

        for (String s: list) {
            System.out.println(s);
        }

        //Another way Comparator with Integer
        Comparator<Integer> compLambda3 = (o1, o2) -> Integer.compare(o1, o2);
        List<Integer> list2 = Arrays.asList(1, 5, 2, 4);
        Collections.sort(list2, compLambda3);

        for (Integer s: list2) {
            System.out.println(s);
        }

        //Abrev way
        Comparator<Integer> compLambda4 = Integer::compare;
        list2 = Arrays.asList(1, 5, 2, 4);
        Collections.sort(list2, compLambda3);

        for (Integer s: list2) {
            System.out.println(s);
        }
    }

    private static void systemOutPrint() {
        System.out.println("------Example 4 System out println-------");
        Car car1 = new Car("Nissan", "Kicks", "2019");
        Car car2 = new Car("Nissan", "March", "2017");
        Car car3 = new Car("Toyota", "Corolla", "2015");
        Car car4 = new Car("Mitsubishi", "Lancer", "2019");
        Car car5 = new Car("Kia", "Sportage", "2006");
        List<Car> listCars = new ArrayList<>();
        listCars.add(car1);
        listCars.add(car2);
        listCars.add(car3);
        listCars.add(car4);
        listCars.add(car5);

        //Print with Lambdas
        listCars.forEach( car -> System.out.println(car));
        listCars.forEach(System.out::println);
    }

    private static void consumer() {
        System.out.println("------Example 5 Consumer-------");

        List<String> strings = Arrays.asList("one", "two", "three", "four", "five");
        List<String> result = new ArrayList<>();

        System.out.println("strings size: " + strings.size() + " result size: " + result.size());

        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = result::add;

        strings.forEach(c1.andThen(c2));

        System.out.println("strings size: " + strings.size() + " result size: " + result.size());
    }
}
