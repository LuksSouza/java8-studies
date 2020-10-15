package br.com.studies.java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestStream {

    public static void main(String[] args) {
        
        List<Course> courses = new ArrayList<Course>();

        courses.add(new Course("Python", 45));
        courses.add(new Course("JavaScript", 150));
        courses.add(new Course("Java 8", 113));
        courses.add(new Course("C", 55));

        courses.sort(Comparator.comparingInt(Course::getStudents));

        courses.forEach(s -> System.out.println(s.getStudents()));

        courses.stream().filter(c -> c.getStudents() > 50).map(Course::getName).forEach(System.out::println);

        courses.stream().mapToInt(Course::getStudents).average().ifPresent(System.out::println);
    }

}