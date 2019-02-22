package pl.braintelligence.garbage;

import io.vavr.control.Try;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;
import java.util.function.Predicate;

public class BetterTryCatcher {

    public static void main(String[] args) {
        var fileReader = new FileReader();
        fileReader.exportFile("sample.txt");
//        fileReader.throwStuff();
    }
}

class FileReader {

    public void exportFile(String filename) {

        var persons = io.vavr.collection.List.of(
                new Person(UUID.randomUUID().toString(), 12, "rick"),
                new Person(UUID.randomUUID().toString(), 20, "rick"),
                new Person(UUID.randomUUID().toString(), 231, "rick"),
                new Person(UUID.randomUUID().toString(), 1324, "rick")
        );

        var file = new File(filename);

        try (var writer = new FileWriter(file)) {

            writer.write("id,order\n");
            var persons2 = persons
                    .filter(hasValidAge())
                    .map(person -> person.getId().concat(",").concat(person.getName()));

            System.out.println(persons2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void throwSomeStuff() throws IOException {
        throw new IOException();
    }

    public void throwStuff() {
        Try
                .run(this::throwSomeStuff)
                .onSuccess(System.out::println)
                .onFailure(Throwable::printStackTrace);

        try {
            throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Predicate<Person> hasValidAge() {
        return person -> person.getAge() > 30;
    }
}

class Person {
    private String id;
    private int age;
    private String name;

    Person(String id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    String getId() {
        return id;
    }

    int getAge() {
        return age;
    }

    String getName() {
        return name;
    }
}
