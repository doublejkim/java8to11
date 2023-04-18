package me.doublej.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyApp {

    public static void main(String[] args) {

        testDefaultBookService();

    }

    public static void testDefaultBookService() {

        System.out.println("testDefaultBookService()");

        /*
        Java 가 제공하는 Proxy 는 Interface 를 넘겨서 사용해야함. (ex. 또다른 Proxy Class 를 넘기거나, Concrete Class 를 넘겨서는 사용 못함
         */
        BookService bookService = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[]{BookService.class},
                new InvocationHandler() {
                    BookService bookService = new DefaultBookService();

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        if (method.getName().equals("rent")) {
                            System.out.println("======================== before work by dynamic proxy...");
                            Object invoke = method.invoke(bookService, args);
                            System.out.println("======================== after work by dynamic proxy...");
                            return invoke;
                        }

                        return method.invoke(bookService, args);
                    }
            });

        Book book = new Book();
        book.setTitle("Harry Potter");
        bookService.rent(book);

        System.out.println();

    }


}
