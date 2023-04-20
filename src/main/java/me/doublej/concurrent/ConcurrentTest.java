package me.doublej.concurrent;

public class ConcurrentTest {

    public static void main(String[] args) {


        test1();
    }

    public static void test1() {

        Thread thr = new Thread(() -> {

            try {

                for (int i = 0; i < 100; i++) {

                    Thread.sleep(100L);
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thr.start();

        for (int i = 0; i < 100                                                                      ; i++) {
            try {
            Thread.sleep(100L);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }



    }

}
