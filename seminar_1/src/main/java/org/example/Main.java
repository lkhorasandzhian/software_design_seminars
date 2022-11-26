package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> languages = new ArrayList<>();
        languages.add("C++");
        languages.add("C#");
        languages.add("Java");

        Employee[] array = new Employee[4];

        Programmer programmer = new Programmer("Levon", 19, 100, 1500, languages, 20);

        Secretary secretary = new Secretary("Tanya", 20, 50, 500, "latte");

        Manager manager = new Manager("Artem", 27, 500, 2500, "PR");

        Executive executive = new Executive("Oleg", 40, 2000, 10_000, "HR", 10);

        array[0] = programmer;
        array[1] = secretary;
        array[2] = manager;
        array[3] = executive;
        System.out.println();

        for (Employee employee : array) {
            employee.sayHello();
            System.out.println();
        }

        programmer.sayWorkload();
        secretary.sayWorkload();
        manager.sayWorkload();
        executive.sayWorkload();

        for (var employee : array) {
            employee.sayWorkRole();
            executive.fireEmployee(employee);
        }
    }
}