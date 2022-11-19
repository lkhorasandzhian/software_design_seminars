package org.example;

public final class Executive extends Manager {
    private final int countOfSecurities;
    private int countOfFiredEmployees = 0;

    public Executive(String name, int age, int salary, int balance, String scope, int countOfSecurities) {
        super(name, age, salary, balance, scope);
        this.countOfSecurities = countOfSecurities;
    }

    @Override
    public void sayHello() {
        super.sayHello();
        if (!isFired) {
            System.out.printf("I have %d securities" + System.lineSeparator(), countOfSecurities);
            System.out.printf("I fired %s employees" + System.lineSeparator(), countOfFiredEmployees);
        }
    }

    @Override
    public void sayWorkRole() {
        System.out.println("I'm executive");
    }

    public void payManagerSalary(Manager manager) {
        if (isFired) {
            System.out.println("At first I need to be hired to start working...");
            return;
        }

        if (manager == null) {
            System.out.println("Undefined manager");
        } else if (manager.isFired) {
            System.out.println("Get out and find another work!");
        } else {
            manager.balance += manager.salary;
        }
    }

    public void fireEmployee(Employee employee) {
        if (isFired) {
            System.out.println("At first I need to be hired to start working...");
            return;
        }

        if (employee instanceof Executive executive) {
            if (executive.countOfSecurities >= this.countOfSecurities) {
                System.out.println("I can't fire my colleague");
                return;
            }
        }

        employee.isFired = true;
        ++countOfFiredEmployees;
    }
}
