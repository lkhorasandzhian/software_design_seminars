package org.example;

import java.util.List;

public final class Programmer extends Employee {
    private final List<String> programmingLanguages;
    private int countOfCodeLines;

    public Programmer(String name, int age, int salary, int balance, List<String> programmingLanguages, int count_of_cod_lines) {
        super(name, age, salary, balance);
        this.programmingLanguages = programmingLanguages;
        this.countOfCodeLines = count_of_cod_lines;
    }

    @Override
    public void sayHello() {
        super.sayHello();
        if (!isFired) {
            if (programmingLanguages == null) {
                System.out.println("I don't know any languages yet...");
            } else {
                System.out.print("List of languages I know:");
                for (String language : programmingLanguages) {
                    System.out.print(" " + language);
                }
                System.out.printf(System.lineSeparator() + "I wrote %d code lines" + System.lineSeparator(), countOfCodeLines);
            }
        }
    }

    @Override
    public void sayWorkRole() {
        System.out.println("I'm programmer");
    }

    public void learnNewProgrammingLanguage(String language) {
        if (programmingLanguages.contains(language)) {
            System.out.printf("I already know %s\r\n", language);
            return;
        }
        programmingLanguages.add(language);
        System.out.printf("I've learnt %s\r\n", language);
        if (isFired) {
            System.out.println("I hope it will help me to be hired...");
        }
    }

    public void writeCodeLines(int count_of_new_lines) {
        if (!isFired) {
            countOfCodeLines += count_of_new_lines;
            System.out.printf("I've just written %d code lines\r\n", count_of_new_lines);
            System.out.printf("My total count of code lines is %d\r\n", countOfCodeLines);
        } else {
            System.out.println("At first I need to be hired to start working...");
        }
    }
}
