package br.com.studies.java8.defaultmethods;

import java.util.Arrays;
import java.util.List;

public class StringOrder {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("alura", "caelum", "casa do codigo");

        words.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        words.forEach((String s) -> {
            System.out.println(s);
        });
    }

}