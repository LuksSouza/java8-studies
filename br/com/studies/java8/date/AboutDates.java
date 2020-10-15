package br.com.studies.java8.date;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class AboutDates {

    public static void main(final String[] args) {

        final LocalDate now = LocalDate.now();
        System.out.println(now);

        final LocalDate january25of2099 = LocalDate.of(2099, Month.JANUARY, 25);
        System.out.println(january25of2099);

        final Period todayTill2099 = Period.between(now, january25of2099);
        System.out.printf("%d year(s), %d month(s) and %d day(s) to 2099\n", todayTill2099.getYears(), todayTill2099.getMonths(), todayTill2099.getDays());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(formatter.format(now));
    }
    
}