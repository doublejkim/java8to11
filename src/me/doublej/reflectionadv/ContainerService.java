package me.doublej.reflectionadv;

import java.lang.reflect.InvocationTargetException;

public class ContainerService {

    public static <T> T getObject(Class<T> classType)  {
        return createInstance(classType);
    }

    /*
    특정 타입의 Class Type을 (*.class) 받아 Refection 을 이용하여 기본생성자를 통해 객체 생성
     */
    private static <T> T createInstance(Class<T> classType) {
        try {

            return classType.getConstructor(null).newInstance();

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

}
