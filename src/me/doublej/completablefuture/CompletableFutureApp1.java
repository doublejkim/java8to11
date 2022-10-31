package me.doublej.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureApp1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> futureBasic1 = new CompletableFuture<>();
        futureBasic1.complete("doublej-1");
        System.out.println(futureBasic1.get());

        System.out.println("-----------------------------------------------------------------------");

        CompletableFuture<String> futureBasic2 = CompletableFuture.completedFuture("doublej-2");
        System.out.println(futureBasic2.get());

        System.out.println("-----------------------------------------------------------------------");

        // 비동기로 직접 실행. 리턴타입이 없는경우 - runAsync()
        CompletableFuture<Void> futureRunAsync = CompletableFuture.runAsync(() -> {
            System.out.println("Hello3 " + Thread.currentThread().getName());
        });

        futureRunAsync.get();

        System.out.println("-----------------------------------------------------------------------");

        // 비동기로 직접 실행. 리턴 타입이 있는경우 - supplyAsync()
        CompletableFuture<String> futureSupplyAsync = CompletableFuture.supplyAsync(() -> {
            return "Hello4 " + Thread.currentThread().getName();
        });

        System.out.println(futureSupplyAsync.get());

        System.out.println("-----------------------------------------------------------------------");

        // 비동기로 callback 을 이용하여 실행 (thenApply()...Callable)
        CompletableFuture<String> futureSupplyAsynThenApply = CompletableFuture.supplyAsync(() -> {
            return "Hello5 " + Thread.currentThread().getName();
        }).thenApply((s) -> {
            System.out.println(Thread.currentThread().getName());
            return s.toUpperCase();
        });  // thenApply 로 callBack 사용 가능 (Callable 활용)

        System.out.println(futureSupplyAsynThenApply.get());

        System.out.println("-----------------------------------------------------------------------");

        // 비동기로 callback 을 이용하여 실행 (thenAccept() ... Consumer)
        CompletableFuture<Void> futureSupplyAsynThenAccept = CompletableFuture.supplyAsync(() -> {
            return "Hello6 " + Thread.currentThread().getName();
        }).thenAccept((s) -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(s.toUpperCase());
        });  // thenApply 로 callBack 사용 가능 (Callable 활용)

        futureSupplyAsynThenAccept.get();

        System.out.println("-----------------------------------------------------------------------");

        // 비동기 동작과 상관없이 일단 수행된다면 무조건 그뒤에 실행 (thenRun()... Runnable)
        CompletableFuture<Void> futureSupplyAsynThenRun = CompletableFuture.supplyAsync(() -> {
            return "Hello7 " + Thread.currentThread().getName();
        }).thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
        });  // thenApply 로 callBack 사용 가능 (Callable 활용)

        futureSupplyAsynThenRun.get();


    }
}
