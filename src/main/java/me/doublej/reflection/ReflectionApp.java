package me.doublej.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionApp {

    public static void main(String[] args) throws Exception {

        //Book.class
        Class<?> bookClass = Class.forName("me.doublej.reflection.Book");
        Constructor<?> constructor1 = bookClass.getConstructor(null);// 기본생성자 획득
        Book book1 = (Book)constructor1.newInstance(); // getConstructor() 를 통해 기본생성자를 획득했으므로 전달인자는 존재하지 않음

        Constructor<?> constructor2 = bookClass.getConstructor(String.class);
        Book book2  = (Book)constructor2.newInstance("HarryPoter");

        System.out.println(book1);
        System.out.println(book2);

        Field madeInField = Book.class.getDeclaredField("madeIn");
        System.out.println(madeInField.get(null));  // static 필드이므로 파라미터로 인스턴스를 넘겨주지 않아도 됨
        madeInField.set(null, "USA");
        System.out.println(madeInField.get(null));

        book1.setPrice(1100);
        Field priceField = Book.class.getDeclaredField("price");
        priceField.setAccessible(true); // private field 라도 accessible : true 이면 접근 가능.( true 설정하지 않으면 IllegalAccessExcpetion 발생)
        System.out.println(priceField.get(book1));
        priceField.set(book1, 3200);
        System.out.println(priceField.get(book1));

        Method printInfoMethod = Book.class.getDeclaredMethod("printInfo");
        printInfoMethod.setAccessible(true);  // private method 도 접근 가능하도록 설정
        printInfoMethod.invoke(book1);

        Method sumMethod = Book.class.getDeclaredMethod("sum", int.class, int.class); // 파라미터 타입은 primitive, wrapper 를 구분함
        int result = (int)sumMethod.invoke(book1, 10, 15);
        System.out.println("sum result : " + result);

    }
}
