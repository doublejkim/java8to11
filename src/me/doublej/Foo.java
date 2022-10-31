package me.doublej;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Supplier;

public class Foo {

    private String name;

    protected Foo() {}
    public Foo(String name) {this.name = name; }

    public String getName() {return this.name; }

    public static void main(String[] args) {

        interfaceDefaultMethod();

    }

    public static void functinalInterface() {

        Supplier<Foo> supplier = () -> new Foo("guest");
        Foo foo = supplier.get();
        System.out.println(foo.getName());

        String [] arr = {"jack", "alice", "tom"};

        Arrays.sort(arr, String::compareToIgnoreCase);
    }

    public static void interfaceDefaultMethod() {
        List<String> names = new ArrayList<>();
        names.add("fff");
        names.add("bbb");
        names.add("ccc");
        names.add("ddd");
        names.add("eee");
        names.add("aaa");

        names.forEach(System.out::println);

        System.out.println("======================================");

        Spliterator<String> spliterator1 = names.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();

        while(spliterator1.tryAdvance(System.out::println));

        System.out.println("--------------------------");

        while(spliterator2.tryAdvance(System.out::println));
    }
}
