package br.com.studies.java8.reduce;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Exercises {
    
    public static void main(String[] args) {
        
        List<Integer> number = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);

        //sum of sqrt
        System.out.println(
            number.stream()
                .map(n -> n*n)
                .reduce(0, Integer::sum)
        );

        //sum of cube
        System.out.println(
            number.stream()
                .map(n -> n*n*n)
                .reduce(0, Integer::sum)
        );

        //find sum of odd number in a list
        System.out.println(
            number.stream()
                .filter(n -> n%2 == 1)
                .reduce(0, Integer::sum)
        );

        //Create a list with even numbers filtered from numbers list
        System.out.println(
            number.stream()
                .filter(n -> n%2 == 0)
                .collect(Collectors.toList())
        );

        //Create a list with lengths of all course titles
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        System.out.println(
            courses.stream()
                .sorted(Comparator.reverseOrder())
                .map(n -> n.length())
                .collect(Collectors.toList())
        );
    }
    
}