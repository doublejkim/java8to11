package me.doublej.proxy.basic;

public class ProxyBasicApp {

    public static void main(String[] args) {

        testDefaultBookService();

        testBookServiceProxy();
    }

    public static void testDefaultBookService() {

        System.out.println("testDefaultBookService()");

        BookService bookService = new DefaultBookService();
        Book book = new Book();
        book.setTitle("Harry Potter");
        bookService.rent(book);

        System.out.println();

    }

    public static void testBookServiceProxy() {

        System.out.println("testBookServiceProxy()");

        BookService bookService = new BookServiceProxy(new DefaultBookService());
        Book book = new Book();
        book.setTitle("Harry Potter");
        bookService.rent(book);

        System.out.println();
    }

}
