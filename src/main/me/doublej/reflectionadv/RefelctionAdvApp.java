package me.doublej.reflectionadv;

public class RefelctionAdvApp {

    public static void main(String[] args) {


        testGetObjectBookRepo();

        System.out.println("===========================================");

        tetGetObjectBookService();
    }

    public static void testGetObjectBookRepo() {

        BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
        System.out.println(bookRepository);
    }

    public static void tetGetObjectBookService() {

        BookService bookService = ContainerService.getObject(BookService.class);
        System.out.println(bookService);
        System.out.println(bookService.bookRepository);

    }
}
