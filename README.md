# Java 8 이후 특징 정리

## 1. Custom Annotation

[1.예제](src/main/java/me/doublej/annotation/AnnotationApp.java)

### 1.1. Retention 어노테이션 정책

- SOURCE
> 어노테이션을 주석처럼사용. 컴파일러가 컴파일할때 어노테이션의 메모리를 버림. (source 에서만 사용)

- CLASS
> Default. 컴파일할때는 어노테이션의 메모리를 가져가지만 실질적으로 런타임시에는 사라짐. (*.class 에서만 사용)

- RUNTIME
> 어노테이션을 런타임시에까지 사용가능. 즉 Refelction API 등을 사용하여 어노테이션 정보를 알 수 있음 

### 1.2. Target 어노테이션

- Element.Type.PACKAGE : 패키지 선언
- Element.Type.TYPE : 타입 선언 (클래서, 인터페이스, enum)
- Element.Type.ANNOTATION_TYPE : 어노테이션
- Element.Type.CONSTRUCTOR : 생성자
- Element.Type.FIELD : 필드. 멤버변수
- Element.Type.LOCAL_VARIABLE : 지역변수 
- Element.Type.METHOD : 메소드
- Element.Type.PARAMETER : 파라미터
- Element.Type.TYPE_PARAMETER : 타입 파라미터
- Element.Type.TYPE_USE : 타입

## 2. 리스트 조작

- 필요없는 항목제거
- 정렬, 역정렬등 

[2.예제](src/main/java/me/doublej/addinterface/IfApp.java)

## 3. Stream 활용

- filter
- forEach
- map
- flatMap
- skip
- limit

위의 메소드를 활용하여 stream 을 편하게 활용 가능 

[3.예제](src/main/java/me/doublej/stream/StreamTest.java)

## 4. CompletableFuture 활용

### 4.1. CompletableFuture 의 기본적인 사용

- get()
- 비동기로 직접 실행 하는 방법 (리턴타입 존재하는경우/존재하지 않는 경우)
- 비동기로 callback 을 이용하여 실행 (thenApply()...Callable / thenAccept() ... Consumer)
- 비동기 동작과 상관없이 일단 수행된다면 무조건 그 뒤에 실행 (thenRiun()... Runnable

[4.1.예제](src/main/java/me/doublej/completablefuture/CompletableFutureApp1.java)

### 4.2. CompletableFuture 의 응용

- supplyAsync()
  - thenCompose() : 이어서 실행해야 하는경우
  - thenCombine() : 독립적인 결과들을 합쳐서 실행결과가 끝나고 난뒤에 컨트롤해야하는 경우
- allOf() : 여러 작업을 모두 실행하고 모든 작업 결과에 콜백 수행
- anyOf() : 가장 빨리 끝나는 작업이 하나의 결과에 콜백수행
- exceptionally() : 에러 발생시 컨트롤. handle() 도 사용 가능 

[4.2.예제](src/main/java/me/doublej/completablefuture/CompletableFutureApp2.java)

## 5. Reflection 기초

- 클래스 정보 획득
- 생성자 획득 후 인스턴스 생성
- 필드 획득 및 사용
- 메소드 호출

[5.예제](src/main/java/me/doublej/reflection/ReflectionApp.java)

## 6. Reflection 응용

- 커스텀 Container Service 를 만들고 DI 를 할 수 있는 커스텀 어노테이션 생성
- Reflection 기능을 활용하여 Class<?> 정보를 받아서 객체를 생성
- Reflection 기능을 활용하여 어노테이션 정보를 확인하여 내부 객체 주입

[6.예제](src/main/java/me/doublej/reflectionadv/RefelctionAdvApp.java)

## 7. Proxy Pattern 기초

- Proxy Pattern 기초 구현

[7.예제](src/main/java/me/doublej/proxy/basic/ProxyBasicApp.java)

## 8. Dynamic Proxy

- Java 에서 제공하는 Proxy 를 사용하여 동적으로 Proxy 객체 생성
- 단점 : Interface 형태로 넘겨야 사용가능

[8.예제](src/main/java/me/doublej/proxy/dynamic/DynamicProxyApp.java)

## 9. Cglib Proxy

- 스프링, 하이버네이트 등에서 사용하는 라이브러리
- 버전 호환성이 좋은 편은 아니라서 라이브러리 내부에 내장된 형태로 제공되기도함
- Class 형태로 넘겨서 Proxy 를 사용 할 수 있음 

[9.예제](src/main/java/me/doublej/proxy/cglib/CglibProxyApp.java)