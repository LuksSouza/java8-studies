package br.com.studies.java8.defaultmethods;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringOrder {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("alura", "caelum", "casa do codigo");

        words.sort(Comparator.comparing(String::length));

        words.forEach(System.out::println);
    }

}