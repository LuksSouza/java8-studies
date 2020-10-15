package br.com.studies.java8.stream;

public class Course {

    private String name;
    private int students;

    public Course(String name, int students) {
        this.name = name;
        this.students = students;       
    }

    public String getName() {
        return this.name;
    }

    public int getStudents() {
        return this.students;
    }
    
}