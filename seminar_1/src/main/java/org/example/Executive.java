package org.example;

public final class Executive extends Manager {
    private final int count_of_securities;
    private int count_of_fired_employees = 0;

    public Executive(String name, int age, int salary, int balance, String scope, int count_of_securities) {
        super(name, age, salary, balance, scope);
        this.count_of_securities = count_of_securities;
    }

    @Override
    public void sayHello() {
        super.sayHello();
        if (!isFired) {
            System.out.printf("I have %d securities" + System.lineSeparator(), count_of_securities);
            System.out.printf("I fired %s employees" + System.lineSeparator(), count_of_fired_employees);
        }
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
            if (executive.count_of_securities >= this.count_of_securities) {
                System.out.println("I can't fire my colleague");
                return;
            }
        }

        employee.isFired = true;
        ++count_of_fired_employees;
    }
}
