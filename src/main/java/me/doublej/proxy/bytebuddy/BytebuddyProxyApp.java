package me.doublej.proxy.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class BytebuddyProxyApp {

    public static void main(String[] args) throws Exception{

        Class<? extends BookServiceConcrete> proxyClass = new ByteBuddy().subclass(BookServiceConcrete.class)
                .method(named("rent")).intercept(InvocationHandlerAdapter.of(new InvocationHandler() {

                    BookServiceConcrete bookServiceConcrete = new BookServiceConcrete();

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        System.out.println("======================== before work by byte-buddy proxy...");
                        Object invoke = method.invoke(bookServiceConcrete, args);
                        System.out.println("======================== after work by byte-buddy proxy...");

                        return invoke;
                    }
                }))
                .make().load(BookServiceConcrete.class.getClassLoader()).getLoaded();

        BookServiceConcrete bookServiceConcrete = proxyClass.getConstructor(null).newInstance();

        Book book = new Book();
        book.setTitle("Java");
        bookServiceConcrete.rent(book);

    }
}
