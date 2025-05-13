package com.brodyaga.lab4;

import com.brodyaga.lab4.model.Department;
import com.brodyaga.lab4.model.Person;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;

import java.io.InputStreamReader;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CSVReaderApp {

    public static List<Person> readPeopleFromCSV(String filePath) throws Exception {
        List<Person> people = new ArrayList<>();
        Map<String, Department> departmentMap = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        try (InputStream in = CSVReaderApp.class.getClassLoader().getResourceAsStream(filePath);
             CSVReader reader = new CSVReaderBuilder(new InputStreamReader(in))
                     .withCSVParser(new CSVParserBuilder().withSeparator(';').build()).build();)
        {

            if (reader == null) throw new RuntimeException("Файл не найден: " + filePath);
            String[] nextLine;
            reader.readNext(); // пропускаем заголовки

            while ((nextLine = reader.readNext()) != null) {
                int id = Integer.parseInt(nextLine[0]);
                String name = nextLine[1];
                String gender = nextLine[2];
                LocalDate birthDate = LocalDate.parse(nextLine[3], formatter);
                String departmentName = nextLine[4];
                double salary = Double.parseDouble(nextLine[5].replace(",", "."));

                Department dept = departmentMap.computeIfAbsent(departmentName, Department::new);
                people.add(new Person(id, name, gender,birthDate, dept, salary));
            }
        }

        return people;
    }

    public static void main(String[] args) throws Exception {
        List<Person> people = readPeopleFromCSV("foreign_names.csv");
        people.forEach(System.out::println);
    }
}
