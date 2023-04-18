package me.doublej.proxy.dynamic;

public class DefaultBookService implements BookService {

    @Override
    public void rent(Book book) {
        System.out.println("DefaultBookService : rent!!! : " + book.getTitle());
    }
}
