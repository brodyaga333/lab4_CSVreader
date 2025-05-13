package com.brodyaga.lab4.model;

import java.time.LocalDate;


/**
 * Модель сущности «Человек» с полями:
 * ID, имя, пол, подразделение, зарплата, дата рождения.
 */

public class Person {
    private int id;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private Department department;
    private double salary;


    /**
     * Конструктор.
     *
     * @param id          уникальный идентификатор
     * @param name        имя человека
     * @param gender      пол (Male/Female)
     * @param department  подразделение
     * @param salary      зарплата
     * @param birthDate   дата рождения
     */
    public Person(int id, String name, String gender,LocalDate birthDate, Department department, double salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.department = department;
        this.salary = salary;

    }

    // Геттеры и сеттеры

    /** @return ID человека */
    public int getId() { return id; }
    /** @return имя человека */
    public String getName() { return name; }
    /** @return пол человека */
    public String getGender() { return gender; }
    /** @return дата рождения */
    public LocalDate getBirthDate() { return birthDate; }
    /** @return подразделение */
    public Department getDepartment() { return department; }
    /** @return зарплата */
    public double getSalary() { return salary; }


    @Override
    public String toString() {
        return id + " | " + name + " | " + gender + " | " + birthDate + " | " + department.getName() + " | " + salary;
    }
}
