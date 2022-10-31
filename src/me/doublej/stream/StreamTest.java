package me.doublej.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        List<Books> itBooks = new ArrayList<>();
        itBooks.add(new Books(1, "Java basic", false));
        itBooks.add(new Books(2, "You can do it. C# programming", true));
        itBooks.add(new Books(3, "MySql", false));
        itBooks.add(new Books(4, "Swift programming", false));
        itBooks.add(new Books(5, "Good test (JUnit)", true));

        List<Books> fruitBooks = new ArrayList<>();
        fruitBooks.add(new Books(6, "Orange", true));
        fruitBooks.add(new Books(7, "Grape", true));
        fruitBooks.add(new Books(8, "Banana", false));
        fruitBooks.add(new Books(9, "Apple", false));
        fruitBooks.add(new Books(10, "Mango", false));

        System.out.println("[Ja 로 시작하는 책]");
        itBooks.stream()
                .filter(val -> val.getTitle().startsWith("Ja"))  // Predicate<T>
                .forEach(System.out::println);

        System.out.println("\n[rental 되지 않은 책]");
        /*itBooks.stream()
                .filter(val -> !val.isRental())
                .forEach(System.out::println); */ // 결과 동일

        itBooks.stream()
                .filter(Predicate.not(Books::isRental))
                .forEach(System.out::println); // 결과 동일

        System.out.println("\n[타이틀만 모아서 스트림 만들기]");
        itBooks.stream()
                .map(Books::getTitle)  // Function< T, R >
                .forEach(System.out::println);

        List<List<Books>> combineBooks = new ArrayList<>();

        combineBooks.add(itBooks);
        combineBooks.add(fruitBooks);

        System.out.println("\n[두 책 리스트에 포함되어있는 아이디 출력]");
        combineBooks.stream()
                .flatMap(Collection::stream)
                .forEach(book -> System.out.println(book.getId()));

        System.out.println("\n[10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만]");
        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("\n[Apple 이 있는지 확인]");
        boolean existApple = fruitBooks.stream().anyMatch(val -> val.getTitle().contains("Apple"));
        System.out.println("existApple = " + existApple);

        System.out.println("\n[itBooks 에서 programming 이 들어간 것만 별도의 List 로 만들기]");
        List<String> programmingBooks = itBooks.stream()
                .filter(val -> val.getTitle().contains("programming"))
                .map(val -> val.getTitle())  // 메소드 참조로 변환 하여 파라미터 인자로 전달 가능
                .collect(Collectors.toList());

        programmingBooks.forEach(System.out::println);


        System.out.println("[xx 로 시작하는 책]");
        List<Books> tempList = itBooks.stream()
                .filter(val -> val.getTitle().startsWith("xx"))
                .collect(Collectors.toList());

        tempList = null;
        System.out.println(tempList);


    }

}
