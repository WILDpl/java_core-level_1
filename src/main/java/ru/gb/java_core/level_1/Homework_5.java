package ru.gb.java_core.level_1;

public class Homework_5 {

    public static void main(String[] args) {

        Employee[] employeeArray = new Employee[5];
        employeeArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        employeeArray[1] = new Employee("Galkina Nina", "Accountant", "ngalkina@mailbox.com", "892312313", 30000, 50);
        employeeArray[2] = new Employee("Petrov Nikolay", "Manager", "npetrov@mailbox.com", "892312314", 40000, 40);
        employeeArray[3] = new Employee("Pupkin Vasiliy", "Programmer", "vpupkin@mailbox.com", "892312315", 50000, 25);
        employeeArray[4] = new Employee("Sidorov Petr", "Director", "psidorov@mailbox.com", "892312310", 100000, 45);

        // печать через return
        for (int i = 0; i < employeeArray.length; i++) {
            if (employeeArray[i].getAge() > 40) {
                System.out.println(employeeArray[i].getInfo());
            }
        }

        // печать в консоль
        System.out.println();
        for (int i = 0; i < employeeArray.length; i++) {
            if (employeeArray[i].getAge() > 40) {
                employeeArray[i].getInfoConsole();
            }
        }

        // составная печать через переменную в консоль
        System.out.println();
        for (int i = 0; i < employeeArray.length; i++) {
            if (employeeArray[i].getAge() > 40) {
                employeeArray[i].getInfoChoice();
            }
        }

        // пример составной печати через переменную в консоль
        System.out.println();
        Employee employee1 = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        Employee employee2 = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com");
        Employee employee3 = new Employee("Ivanov Ivan", "Engineer");
        employee1.getInfoChoice();
        employee2.getInfoChoice();
        employee3.getInfoChoice();

    }
}
