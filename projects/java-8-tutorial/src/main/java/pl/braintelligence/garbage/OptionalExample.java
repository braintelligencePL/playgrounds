package pl.braintelligence.garbage;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

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

//        objects.stream()
//                .map(Person::getAge)
//                .orElse("zxc");
//
        final String immutableAndFinal = "asdfzxcv";
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


    }
}
