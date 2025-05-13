package com.brodyaga.lab4.model;

import java.time.LocalDate;

public class Person {
    private int id;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private Department department;
    private double salary;


    public Person(int id, String name, String gender,LocalDate birthDate, Department department, double salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.department = department;
        this.salary = salary;

    }

    // Геттеры и сеттеры
    public int getId() { return id; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public LocalDate getBirthDate() { return birthDate; }
    public Department getDepartment() { return department; }
    public double getSalary() { return salary; }


    @Override
    public String toString() {
        return id + " | " + name + " | " + gender + " | " + birthDate + " | " + department.getName() + " | " + salary;
    }
}
