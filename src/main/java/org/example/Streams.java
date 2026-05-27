package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 2, 6, 8, 3, 4, 5, 6, 7, 8, 9, 0, 12, 1234, 5, 35346, 3545, 832, 768);
        List<Integer> filteredList = list.stream()
                .filter(x -> x % 2 == 0)
                .distinct()
                .sorted((a, b) -> b - a)
                .collect(Collectors.toList());
        System.out.println(filteredList);


    }

    public void testStreamGeneration() {
        List<String> list = Arrays.asList("apple", "banana", "pienapple", "watermelon");
        Stream<String> stream = list.stream();

        String[] array = {"apple", "banana", "cherry"};
        Stream<String> arrayStream = Arrays.stream(array);

        Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> iterateStream = Stream.iterate(0, n -> n + 1).limit(100);
    }


}
