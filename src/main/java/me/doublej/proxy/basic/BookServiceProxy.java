package me.doublej.proxy.basic;

public class BookServiceProxy implements BookService {

    BookService bookService;

    public BookServiceProxy(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void rent(Book book) {
        System.out.println("======================== before work by proxy...");
        bookService.rent(book);
        System.out.println("======================== after work by proxy...");
    }
}
