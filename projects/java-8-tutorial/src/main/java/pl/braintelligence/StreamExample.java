package pl.braintelligence;

import pl.braintelligence.models.Person;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamExample {
    public static void main(String[] args) {


        Stream<String> numbers = Stream.of("1", "22", "333", "4444");
        List<String> result = new ArrayList<>();

        Predicate<String> isTextLengthValid = text -> text.length() > 2;


//        numbers.filter(isTextLengthValid)
//                .peek(System.out::println)
//                .peek(result::add);


//        numbers.filter(isTextLengthValid)
//                .peek(System.out::println)
//                .forEach(result::add);

        System.out.println(numbers.findFirst().get());

//        System.out.println(result.size());

    }
}

class FlatMapExample {
    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> list2 = Arrays.asList(2, 4, 6);
        List<Integer> list3 = Arrays.asList(3, 5, 7);

        List<List<Integer>> list = Arrays.asList(list1, list2, list3);

        System.out.println(list);

        Function<List<Integer>, Stream<Integer>> numbers = Collection::stream;
//        Function<List<Integer>, Stream<Integer>> numbers = Collection::stream;

        list.stream()
                .map(numbers)
                .forEach(System.out::println); // java.util.stream.ReferencePipeline$Head@43a25848

        list.stream()
                .flatMap(numbers)
                .forEach(System.out::println); // 1,2,3,4,5,6,7,2,4,6,3,5,7

    }
}

class ReductionExample {
    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
//                new Person("Jack", 44),
                new Person("Jack", 22),
                new Person("Jack", 13),
                new Person("Jack", 5),
                new Person("Mike", 2),
                new Person("Mike", 12)
        );

        Optional<Person> personMaxAge = persons.stream()
                .max(Comparator.comparing(Person::getAge));

        System.out.println(personMaxAge);


//        Optional<Integer> minAge = persons.stream()
//                .map(Person::getAge)
//                .filter(age -> age > 10)
//                .min(Comparator.naturalOrder());
//
//        if (minAge.isPresent()) {
//            minAge.get();
//        }
//
////        System.out.println(minAge.orElse(1));
//
//        Map<Integer, List<String>> result = persons.stream()
//                .filter(person -> person.getAge() > 10)
//                .collect(
//                        Collectors.groupingBy(
//                                Person::getAge,
//                                Collectors.mapping(
//                                        Person::getName,
//                                        Collectors.toList()
//                                )
//                        )
//                );
//
////        System.out.println("result" + result);
//
////        ArrayList<?> box = new ArrayList<String>();
////        box.add(null);
////        box.add("saa");
//
//        Film film = title -> "Watching " + title;
//
////        System.out.println(film.watch("Rick and Morty")); // Watching Rick and Morty
//


        var tools = Arrays.asList("Hammer", "Nokia 3030");

        var streamOfTools = tools.stream();

        tools.stream()
                .peek(System.out::println)
                .collect(Collectors.joining(", "));

    }

}

interface Film {

    String watch(String str);

    default String defaultPreview(String str) { }
    static String staticPreview(String str) { }
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
