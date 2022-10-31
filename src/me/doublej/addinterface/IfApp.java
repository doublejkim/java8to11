package me.doublej.addinterface;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class IfApp {

    public static void main(String[] args) {
      //  List<String> fruits = new ArrayList<>();
        List<String> fruits = new ArrayList<>();

        fruits.add("banana");   fruits.add("melon");
        fruits.add("apple");    fruits.add("cherry");
        fruits.add("mango");

        System.out.println("=== forEach() 1");
        fruits.forEach(s ->{
            System.out.println(s);
        });

        System.out.println("\n=== forEach() 2");
        fruits.forEach(System.out::println);

        System.out.println("\n=== spliterator()");

        Spliterator<String> spliterator1 = fruits.spliterator(); // 분리할수있는 iterator 라고 생각하면 됨
        Spliterator<String> spliterator2 = spliterator1.trySplit();


        while(spliterator1.tryAdvance(System.out::println)) ;

        System.out.println("----------------------------");

        while(spliterator2.tryAdvance(System.out::println)) ;




        System.out.println("\n=== removeIf() 이후 출력");

        fruits.removeIf(s -> s.startsWith("a"));
        fruits.forEach(System.out::println);

        System.out.println("\n=== 정렬 이후 출력");

        fruits.sort(String::compareToIgnoreCase); // parameter 가 Consumer<? Extends E>

        fruits.forEach(System.out::println); // 정렬후 출력

        System.out.println("\n=== 역정렬 이후 출력");

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        fruits.sort(compareToIgnoreCase.reversed());
        fruits.forEach(System.out::println); // 역 정렬후 출력




    }

}
