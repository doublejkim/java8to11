package me.doublej.proxy.bytebuddy;

public class BookServiceConcrete {

    void rent(Book book)  {
        System.out.println("BookServiceConcrete : rent!!! : " + book.getTitle());
    }
}
