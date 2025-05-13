package com.brodyaga.lab4;

import com.brodyaga.lab4.model.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестирование метода readPeopleFromCSV().
 */
class CSVReaderAppTest {

    @Test
    void readPeopleFromCSV_shouldReturnNonEmptyList() throws Exception {
        List<Person> people = CSVReaderApp.readPeopleFromCSV("foreign_names.csv");
        assertNotNull(people, "Список не должен быть null");
        assertFalse(people.isEmpty(), "Список не должен быть пустым");
    }

    @Test
    void readPeopleFromCSV_sampleRecordFields() throws Exception {
        List<Person> people = CSVReaderApp.readPeopleFromCSV("foreign_names.csv");
        Person p = people.get(0);
        assertTrue(p.getId() > 0, "ID должен быть положительным");
        assertNotNull(p.getName(), "Имя не должно быть null");
        assertNotNull(p.getGender(), "Пол не должен быть null");
        assertNotNull(p.getBirthDate(), "Дата рождения не должна быть null");
        assertTrue(p.getSalary() > 0, "Зарплата должна быть > 0");
        assertNotNull(p.getDepartment(), "Подразделение не должно быть null");
    }
}
