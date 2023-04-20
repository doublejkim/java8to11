package me.doublej.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_PARAMETER) // TYPE_USE 를 사용하면 Type Parameter 앞 뿐만아니라 일반적인 Type 앞에도 사용 가능
public @interface Chicken {
}