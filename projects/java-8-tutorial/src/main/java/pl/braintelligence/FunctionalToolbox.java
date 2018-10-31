package pl.braintelligence;


import pl.braintelligence.models.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *  Category 1
 *  Consumer Section
 */
class ConsumerSection {
    public static void main(String[] args) {
        Consumer<String> consumer1 = s -> System.out.println(s);
        Consumer<String> consumer2 = System.out::println;

        consumer1.accept("consumer1 ");
        consumer2.accept("consumer2 ");

        // More practical sample of consumer
        List<Person> persons = Arrays.asList(
                new Person("Consumer: Jack"),
                new Person("Consumer: Mike")
        );

        persons.forEach(person ->
                System.out.println(person.getName())
        );

        // We want this syntax :: System.out::println
        persons.stream()
                .map(Person::getName) // To get the same result we need to map it so we get names instead of Person object
                .forEach(System.out::println);

        // First we want to print persons List
        // Second we want to add content of the `famousPeople` list to new List called `trulyFamousPeople`
        List<Person> famousPeople = Arrays.asList(
                new Person("Chuck Norris"),
                new Person("Chuck Norris")
        );

        List<Person> trulyFamousPeople = new ArrayList<>();

        Consumer<Person> printingConsumer = person -> System.out.println("Famous Person is " + person.getName());
        Consumer<Person> addingConsumer = trulyFamousPeople::add;

        Consumer<Person> chainedConsumer = printingConsumer.andThen(addingConsumer);

        famousPeople.forEach(chainedConsumer);

//        famousPeople.forEach(printingConsumer.andThen(addingConsumer)); // We can chain Consumers

        System.out.println("There is " + trulyFamousPeople.size() + " truly famous people in the world.");

    }
}

/**
 *  Category 2
 *  Comparator Section
 */
class ComparatorSection {
    public static void main(String[] args) {
        // -------------------------------------- //
        // -------------- Category 2 ------------ //
        // -------------------------------------- //
        // ---------- Comparator Section -------- //
        // -------------------------------------- //
        Comparator<Integer> comparator1 = (o1, o2) -> Integer.compare(o1, o2);
        Comparator<Integer> comparator2 = Integer::compare;

        System.out.println(comparator1.compare(42, 1)); // return  1   : first argument is greater than second
        System.out.println(comparator1.compare(1, 1));  // return  0   : first is equal to second
        System.out.println(comparator2.compare(1, 42)); // return -1   : first is less than second

    }
}

/**
 *  Category 3
 *  Predicate Section
 */
class PredicateSection {
    public static void main(String[] args) {
        // -------------------------------------- //
        // -------------- Category 3 ------------ //
        // -------------------------------------- //
        // ---------- Predicate Section ----------- //
        // ---------------------------------------- //
        Predicate<String> predicate1 = s -> s.length() < 20;
        Predicate<String> predicate2 = s -> s.length() > 10;

        // TIP: Predicate.and() checks for null
        Predicate<String> p3 = predicate1.and(predicate2);
        System.out.println(p3.test("123456789")); // false
        System.out.println(p3.test("12345678912345")); // true

        // Static Predicate method isEqual()
        Predicate<String> id = Predicate.isEqual("123");
        System.out.println(id.test("123"));
    }
}

