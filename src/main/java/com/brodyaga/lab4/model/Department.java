package com.brodyaga.lab4.model;

/**
 * Модель сущности «Подразделение» с автогенерируемым ID и именем.
 */
public class Department {
    private static int idCounter = 1;
    private int id;
    private String name;


    /**
     * Конструктор. Генерирует новый уникальный ID.
     * @param name название подразделения
     */
    public Department(String name) {
        this.id = idCounter++;
        this.name = name;
    }

    /** @return уникальный ID подразделения */
    public int getId() { return id; }
    /** @return название подразделения */
    public String getName() { return name; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Department)) return false;
        Department other = (Department) obj;
        return this.name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }
}
