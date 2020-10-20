package br.com.studies.java8.behaviorParameterization;

import java.util.List;
import java.util.function.Predicate;

public class Exercises {
    
    public static void main(String[] args) {
        
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        //Print even numbers
        filterAndPrint(numbers, n -> n%2 == 0);
        
        //Print odd numbers
        filterAndPrint(numbers, n -> n%2 != 0);
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> evenPredicate) {
        numbers.stream()
            .filter(evenPredicate)
            .forEach(System.out::println);
    }

}
