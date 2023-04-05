# Java 8 이후 특징 정리

## 1. Custom Annotation

[1.예제](src/me/doublej/annotation/AnnotationApp.java)

## 2. 리스트 조작

- 필요없는 항목제거
- 정렬, 역정렬등 

[2.예제](src/me/doublej/addinterface/IfApp.java)

## 3. Stream 활용

- filter
- forEach
- map
- flatMap
- skip
- limit

위의 메소드를 활용하여 stream 을 편하게 활용 가능 

[3.예제](src/me/doublej/stream/StreamTest.java)

## 4. CompletableFuture 활용

### 4.1. CompletableFuture 의 기본적인 사용

- get()
- 비동기로 직접 실행 하는 방법 (리턴타입 존재하는경우/존재하지 않는 경우)
- 비동기로 callback 을 이용하여 실행 (thenApply()...Callable / thenAccept() ... Consumer)
- 비동기 동작과 상관없이 일단 수행된다면 무조건 그 뒤에 실행 (thenRiun()... Runnable

[4.1.예제](src/me/doublej/completablefuture/CompletableFutureApp1.java)

### 4.2. CompletableFuture 의 응용

- supplyAsync()
  - thenCompose() : 이어서 실행해야 하는경우
  - thenCombine() : 독립적인 결과들을 합쳐서 실행결과가 끝나고 난뒤에 컨트롤해야하는 경우
- allOf() : 여러 작업을 모두 실행하고 모든 작업 결과에 콜백 수행
- anyOf() : 가장 빨리 끝나는 작업이 하나의 결과에 콜백수행
- exceptionally() : 에러 발생시 컨트롤. handle() 도 사용 가능 

[4.2.예제](src/me/doublej/completablefuture/CompletableFutureApp2.java)