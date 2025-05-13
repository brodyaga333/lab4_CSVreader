package com.brodyaga.lab4;

import com.brodyaga.lab4.model.Department;
import com.brodyaga.lab4.model.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Точка входа, демонстрирует чтение CSV и выводит простую статистику.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        String csvFile = "foreign_names.csv";
        List<Person> people = CSVReaderApp.readPeopleFromCSV(csvFile);

        // 1) Просто вывод всех прочитанных записей
        System.out.println("Всего людей: " + people.size());
        people.forEach(System.out::println);

        // 2) Группировка по подразделениям
        Map<Department, Long> countByDept = people.stream()
                .collect(Collectors.groupingBy(Person::getDepartment, Collectors.counting()));

        System.out.println("\nСтатистика по подразделениям:");
        System.out.printf("%-20s %s%n", "Подразделение", "Количество");
        countByDept.forEach((dept, cnt) ->
                System.out.printf("%-20s %d%n", dept.getName(), cnt)
        );
    }
}
