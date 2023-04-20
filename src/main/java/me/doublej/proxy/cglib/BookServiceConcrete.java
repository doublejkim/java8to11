package me.doublej.proxy.cglib;

public class BookServiceConcrete {

    void rent(Book book)  {
        System.out.println("BookServiceConcrete : rent!!! : " + book.getTitle());
    }
}
