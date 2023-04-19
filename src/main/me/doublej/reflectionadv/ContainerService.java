package me.doublej.reflectionadv;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {

    /*
    @Inject 어노테이션이 붙어있으면 동일하게 인스턴스를 만들어서 주입하도록 변경
     */
    public static <T> T getObject(Class<T> classType)  {

        T instance = createInstance(classType);
        Arrays.stream(classType.getDeclaredFields()).forEach(
                f -> {
                    Inject annotation = f.getAnnotation(Inject.class);
                    if (annotation != null) {
                        Object filedInstance = createInstance(f.getType());
                        f.setAccessible(true);  // field 는 private/default 인 경우가 많기때문에..

                        try {

                            f.set(instance, filedInstance);

                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );

        return instance;
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
