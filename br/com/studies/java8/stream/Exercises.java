package br.com.studies.java8.stream;

import java.util.List;

public class Exercises {

    public static void main(String[] args) {
        
        //Print only odd numbers
        List<Integer> number = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
        number.stream()
            .filter(n -> n % 2 != 0)
            .forEach(System.out::println);

        //Print all courses individually
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        courses.stream()
            .forEach(System.out::println);

        //Print courses containing the word 'Spring'
        courses.stream()
            .filter(c -> c.contains("Spring"))
            .forEach(System.out::println);

        //Print courses whose name has at least 4 letters
        courses.stream()
            .filter(c -> c.length() <= 4)
            .forEach(System.out::println);
    }

}