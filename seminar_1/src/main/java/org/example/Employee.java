package org.example;

public abstract class Employee {
    protected static int count_of_employees = 0;
    protected final String name;
    protected final int age;
    protected int salary;
    protected int balance;
    protected Boolean isFired = false;

    protected Employee(String name, int age, int salary, int balance) {
        ++count_of_employees;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.balance = balance;
    }

    public void sayHello() {
        if (!isFired) {
            System.out.printf("Hello, my name is %s!" + System.lineSeparator(), name);
            System.out.printf("I'm %d y.o." + System.lineSeparator(), age);
            System.out.printf("My salary is %d" + System.lineSeparator(), salary);
            System.out.printf("My balance is %d" + System.lineSeparator(), balance);
        } else {
            System.out.println("I'm fired...");
        }
    }

    protected abstract void sayWorkRole();
}
