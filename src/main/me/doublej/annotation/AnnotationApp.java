package me.doublej.annotation;

public class AnnotationApp {

    public static void main(String[] args) {

    }

    static class FellsLikeChicken<@Chicken T> {

        public static <@Chicken C> void  print(C c) {

        }
    }


}
