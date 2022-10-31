package me.doublej.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFutureApp2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("thenCompose() test ================================");
        thenComposeTest();
        System.out.println("===================================================");

        System.out.println("thenCombine() test ================================");
        thenCombineTest();
        System.out.println("===================================================");

        System.out.println("offOf() test ================================");
        allOfTest();
        System.out.println("===================================================");

        System.out.println("anyOf() test ================================");
        anyOfTest();
        System.out.println("===================================================");

        System.out.println("exceptionally() test ================================");
        exceptionallyTest();
        System.out.println("===================================================");
    }

    public static void thenComposeTest() throws ExecutionException, InterruptedException  {

        // 이어서 실행해야하는경우 thenCompose() 사용.
        CompletableFuture<String> helloFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> futureWorld = helloFuture.thenCompose(CompletableFutureApp2::getWorld);

        System.out.println(futureWorld.get());
    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return message + " World";
        });

    }

    public static void thenCombineTest() throws  ExecutionException, InterruptedException {

        // 독립적인 결과들을 합쳐서 실행결과가 끝나고난 뒤에 컨트롤해야하는 경우는 thenCombine() 사용
        CompletableFuture<String> helloFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> worldFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return "World";
        });

        CompletableFuture<String> resultFuture = helloFuture.thenCombine(worldFuture, (h, w) -> {
            return h + " " + w;
        });

        System.out.println(resultFuture.get());
    }

    public static void allOfTest() throws  ExecutionException, InterruptedException {

        CompletableFuture<String> helloFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> worldFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return "World";
        });

        // offOf() 를 사용한 이후에 return 값을 받으려면 아래와 같이 사용하면 되지만, 아무것도 blocking 되지 않음
        List<CompletableFuture<String>> futures = Arrays.asList(helloFuture, worldFuture);
        CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);

        CompletableFuture<List<String>> results = CompletableFuture.allOf(futuresArray)
                .thenApply(v -> {
                    return futures.stream()
                            .map(CompletableFuture::join) // get 을 사용해도 되지만 Checked excpetion 이 발생하여 처리해줘야히기때문에 여기선 join 사용
                            .collect(Collectors.toList());
                });

        results.get().forEach(System.out::println);
    }

    public static void anyOfTest() throws  ExecutionException, InterruptedException {

        CompletableFuture<String> helloFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> worldFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return "World";
        });

        CompletableFuture<Void> future = CompletableFuture.anyOf(helloFuture, worldFuture).thenAccept(System.out::println);
        future.get();

    }

    public static void exceptionallyTest() throws  ExecutionException, InterruptedException {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (true) {
                throw new IllegalArgumentException();
            }

            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).exceptionally(ex -> {  // exceptionally 대신에 정상,에러 두경우 모두 제어하고 싶으면 handle() 사용 가능
            System.out.println(ex);  // Exception 객체를 활용해 원하는 값을 확인 가능하며..
            return "OH~Error!!!"; // 리턴되는 값을 제어 가능
        });

        System.out.println(future.get());


    }
}
