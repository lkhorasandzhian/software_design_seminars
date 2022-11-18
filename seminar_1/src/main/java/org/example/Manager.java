package org.example;

public class Manager extends Employee {
    protected static int count_of_managers = 0;
    protected String scope;

    public Manager(String name, int age, int salary, int balance, String scope) {
        super(name, age, salary, balance);
        this.scope = scope;
        ++count_of_managers;
    }

    @Override
    public void sayHello() {
        super.sayHello();
        if (!isFired) {
            System.out.printf("My scope is %s" + System.lineSeparator(), scope);
            System.out.printf("There is %s manager(-s) in our company" + System.lineSeparator(), count_of_managers);
        }
    }

    public final void changeScope(String new_scope) {
        if (new_scope == null) {
            System.out.println("Undefined scope");
        } else {
            scope = new_scope;
            System.out.printf("Now my scope is %s" + System.lineSeparator(), new_scope);
        }
    }

    public void payEmployeeSalary(Employee employee) {
        if (isFired) {
            System.out.println("At first I need to be hired to start working...");
            return;
        }

        if (employee == null) {
            System.out.println("Undefined employee");
            return;
        } else if (employee.isFired) {
            System.out.println("Get out and find another work!");
            return;
        }

        if (employee instanceof Executive) {
            if (this instanceof Executive) {
                System.out.println("Executives don't pay money to each other");
            } else {
                System.out.println("Generally I don't give salary to executive, rather the opposite...");
            }
            return;
        } else if (employee instanceof Manager manager) {
            if (this instanceof Executive executive) {
                executive.payManagerSalary(manager);
            } else {
                System.out.println("Managers don't pay money to each other");
            }
            return;
        }

        employee.balance += employee.salary;
    }
}
