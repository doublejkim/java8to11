package me.doublej.proxy.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyApp {

    public static void main(String[] args) {

        testCglibProxy();

    }

    public static void testCglibProxy() {


        System.out.println("testCglibProxy()");


        MethodInterceptor methodInterceptor = new MethodInterceptor() {

            BookServiceConcrete bookServiceConcrete = new BookServiceConcrete();

            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                if (method.getName().equals("rent")) {
                    System.out.println("======================== before work by cglib proxy...");
                    Object invoke = method.invoke(bookServiceConcrete, args);
                    System.out.println("======================== after work by cglib proxy...");
                }

                return method.invoke(bookServiceConcrete, args);
            }
        };

        BookServiceConcrete bookServiceConcrete = (BookServiceConcrete) Enhancer.create(BookServiceConcrete.class, methodInterceptor);

        Book book = new Book();
        book.setTitle("Harry Potter");
        bookServiceConcrete.rent(book);

        System.out.println();

    }
}
