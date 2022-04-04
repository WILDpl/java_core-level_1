package ru.gb.java_core.level_1;

import java.time.Year;

public class Employee {
    private String info;
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int birthYear;

    private Employee() {
    }

    public Employee(String name) {
        this();
        this.name = name;
        this.info = String.format("Employee: Name='%s'", name);
    }

    public Employee(String name, String position) {
        this(name);
        this.position = position;
        this.info += String.format(", Position='%s'", position);
    }

    public Employee(String name, String position, String email) {
        this(name, position);
        this.email = email;
        this.info += String.format(", E-Mail='%s'", email);
    }

    public Employee(String name, String position, String email, String phone) {
        this(name, position, email);
        this.phone = phone;
        this.info += String.format(", Phone='%s'", phone);
    }

    public Employee(String name, String position, String email, String phone, int salary) {
        this(name, position, email, phone);
        this.salary = salary;
        this.info += String.format(", Salary='%d'", salary);
    }

    public Employee(String name, String position, String email, String phone, int salary, int age) {
        this(name, position, email, phone, salary);
        this.birthYear = Year.now().getValue() - age;
        this.info += String.format(", Age='%d'", getAge());
    }

    public String getInfo() {
        return String.format("Employee: Name='%s', Position='%s', E-Mail='%s', Phone='%s', Salary='%d', Age='%d'", name, position, email, phone, salary, getAge());
    }

    public void getInfoConsole() {
        System.out.printf("Employee: Name='%s', Position='%s', E-Mail='%s', Phone='%s', Salary='%d', Age='%d'\n", name, position, email, phone, salary, getAge());
    }

    public void getInfoChoice() {
        System.out.println(this.info);
    }

    public String getName() {
        return this.name;
    }

    public String getPosition() {
        return this.position;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public int getSalary() {
        return this.salary;
    }

    public int getAge() {
        return Year.now().getValue() - birthYear;
    }

}
