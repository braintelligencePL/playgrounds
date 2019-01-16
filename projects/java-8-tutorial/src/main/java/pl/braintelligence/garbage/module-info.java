package pl.braintelligence.garbage;


import groovy.time.TimeDuration;
import groovy.util.logging.Slf4j;
import pl.braintelligence.garbage.models.Person;

import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//public class StreamExample {
//    public static void main(String[] args) {
//
//
//        var numbers = Stream.of("1", "22", "333", "4444");
//        var result = new ArrayList<>();
//
//        Predicate<String> isTextLengthValid = text -> text.length() > 2;
//
////        numbers.filter(isTextLengthValid)
////                .peek(System.out::println)
////                .peek(result::add);
//
//
////        numbers.filter(isTextLengthValid)
////                .peek(System.out::println)
////                .forEach(result::add);
//
////        System.out.println(numbers.findFirst().get());
//
//        Optional<String> opt = Optional.ofNullable("df");
//
//        opt = Optional.ofNullable(null);
//
//        opt.ifPresent(System.out::print);
//
//        opt.ifPresentOrElse(
//                value -> System.out.print(value),
//                () -> System.out.print("Not found")
//        );
//
////        System.out.println(result.size());
//
//    }
//}
//
//class FlatMapExample {
//    public static void main(String[] args) {
//        List<? extends Serializable> serializables = List.of(1, 2.0, "3");
//
//        var list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
//        List<Integer> list2 = Arrays.asList(2, 4, 6);
//        List<Integer> list3 = Arrays.asList(3, 5, 7);
//
//        List<List<Integer>> list = Arrays.asList(list1, list2, list3);
//
//        System.out.println(list);
//
//        Function<List<Integer>, Stream<Integer>> numbers = Collection::stream;
////        Function<List<Integer>, Stream<Integer>> numbers = Collection::stream;
//
//        list.stream()
//                .map(numbers)
//                .forEach(System.out::println); // java.util.stream.ReferencePipeline$Head@43a25848
//
//        list.stream()
//                .flatMap(numbers)
//                .forEach(System.out::println); // 1,2,3,4,5,6,7,2,4,6,3,5,7
//
//    }
//}
//
//class ReductionExample {
//    public static void main(String[] args) {
//
//        List<Person> persons = Arrays.asList(
//
//                new Person("Jack", 19),
//                new Person("First Morty", 15),
//                new Person("Another Morty", 15),
//                new Person("Rick", 65)
////                new Person("Jack", 44),
////                new Person("Jack", 22),
////                new Person("Jack", 13),
////                new Person("Jack", 21),
////                new Person("Jack", 20),
////                new Person("Jack", 19),
////                new Person("Jack", 5),
////                new Person("Mike2", 2),
////                new Person("Mike1", 2),
////                new Person("Mike4", 2),
////                new Person("Mike", 12)
//        );
//
//
//        var result1 = persons.stream()
//                .min(Comparator.comparing(Person::getAge));
//
//        var result2 = persons.stream()
//                .filter(p -> p.getAge() > 18)
//                .min(Comparator.comparing(Person::getAge));
//
//        var result3 = persons.stream()
//                .collect(Collectors.groupingBy(
//                        Person::getAge,
//                        Collectors.counting()
//                ));
//
//        var result35 = persons.stream()
//                .collect(Collectors.groupingBy(Person::getAge));
//
//        var result4 = persons.stream()
//                .collect(Collectors.groupingBy(
//                        Person::getAge,
//                        Collectors.mapping(
//                                Person::getName,
//                                Collectors.toCollection(TreeSet::new)
//                        )
//                ));
//
////        persons.stream()
////                .map(person ->  String.format("%s is %s", person.getName(), person.getAge()))
////                .peek(System.out::println)
////                .collect(Collectors.toList());
//
//        System.out.println(result1.get().getAge());
//        System.out.println(result2.get().getAge());
//
//        System.out.println(result35);
//        System.out.println(result3);
//        System.out.println(result4);
//
////        Optional<Integer> minAge = persons.stream()
////                .map(Person::getAge)
////                .filter(age -> age > 10)
////                .min(Comparator.naturalOrder());
////
////        if (minAge.isPresent()) {
////            minAge.get();
////        }
////
//////        System.out.println(minAge.orElse(1));
////
////        Map<Integer, List<String>> result = persons.stream()
////                .filter(person -> person.getAge() > 10)
////                .collect(
////                        Collectors.groupingBy(
////                                Person::getAge,
////                                Collectors.mapping(
////                                        Person::getName,
////                                        Collectors.toList()
////                                )
////                        )
////                );
////
//////        System.out.println("result" + result);
////
//////        ArrayList<?> box = new ArrayList<String>();
//////        box.add(null);
//////        box.add("saa");
////
////        Film film = title -> "Watching " + title;
////
//////        System.out.println(film.watch("Rick and Morty")); // Watching Rick and Morty
////
//
//
//        var tools = Arrays.asList("Hammer", "Nokia 3030");
//
//        var streamOfTools = tools.stream();
//
//        var ss = "2" + 234;
////        System.out.println(ss);
//
//        tools.stream()
////                .peek(System.out::println)
//                .collect(Collectors.joining(", "));
//
//    }
//
//}

interface Film {

    String watch(String str);

    default String defaultPreview(String str) {
        return null;
    }

    static String staticPreview(String str) {
        return null;
    }

//    private String

}

class FilmImpl implements Film {

    @Override
    public String watch(String str) {
        return "Rick and Morty";
    }

    private void performAction() {
        // First way
        Film.staticPreview("Rick and Morty");

        // Second way
        FilmImpl film = new FilmImpl();
        film.defaultPreview("Rick and Morty");
    }
}

class OptionalExample {
    public static void main(String[] args) {
//        List<Optional<String>> list = Arrays.asList(
//                Optional.empty(),
//                Optional.of("foo"),
//                Optional.empty(),
//                Optional.of("bar"));

//        var empty1 = Optional.empty();
//        empty1.ifPresent(t -> Optional.get(t));

//        Date date = new Date();
//        System.out.println(date);

//        var instant = Instant.MIN;
//        System.out.println(instant);

        var objects = List.of("zxc");

        var immutable = "asdf";
        immutable = "1234";

//        final String immutableAndFinal = "asdfzxcv";
//        immutableAndFinal = "1234";

        Instant start = Instant.now();
        // time consuming computations
        Instant end = Instant.now();

        System.out.println(Duration.between(start, end).toNanos());

        // Let's say we want to represent a date like 24.01.1765
        var date1 = LocalDate.of(2000, Month.JANUARY, 10);
        var date2 = LocalDate.of(2010, 3, 20);


        System.out.println(
                Period.between(
                        date1,
                        date2
                )
        );

        date1.until(date2, ChronoUnit.MONTHS); // 120

        System.out.println(LocalTime.of(14, 15));

        var europeTime = ZonedDateTime.of(
                LocalDate.of(2001, Month.JANUARY, 20),
                LocalTime.of(14, 15),
                ZoneId.of("Europe/Warsaw")
        );

        var africaTime = europeTime
                .withZoneSameInstant(ZoneId.of("Africa/Nairobi"))
                .format(DateTimeFormatter.RFC_1123_DATE_TIME);


        System.out.println(

        );

        System.out.println(ZoneId.getAvailableZoneIds());


        String rick = "Rick";
        String morty = "Morty";


        String rickAndMorty = String.join("", rick, " and ", morty);
        System.out.println(rickAndMorty);

        var list = List.of("123", "asd");

        list.stream().of

    }

    public static void main(String[] args) {

    }
}
