package pl.braintelligence;

import pl.braintelligence.models.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
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

        Function<List<Integer>, Stream<Integer>> numbers = listOfNumbers -> listOfNumbers.stream();
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
//                new Person("Jack", 22),
//                new Person("Jack", 11),
                new Person("Jack", 5),
                new Person("Mike", 2)
        );

        Optional<Integer> minAge = persons.stream()
                .map(Person::getAge)
                .filter(age -> age > 10)
                .min(Comparator.naturalOrder());

        if(minAge.isPresent()){
            minAge.get();
        }



        System.out.println(minAge.orElse(1));

    }
}






















