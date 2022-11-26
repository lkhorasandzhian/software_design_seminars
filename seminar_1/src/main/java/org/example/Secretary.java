package org.example;

public final class Secretary extends Employee implements IWorkloadable {
    private String favouriteCoffee;

    public Secretary(String name, int age, int salary, int balance, String favouriteCoffee) {
        super(name, age, salary, balance);
        this.favouriteCoffee = favouriteCoffee;
    }

    @Override
    public void sayHello() {
        super.sayHello();
        if (!isFired) {
            System.out.printf("My favourite coffee is %s" + System.lineSeparator(), favouriteCoffee);
        }
    }

    @Override
    public void sayWorkRole() {
        System.out.println("I'm secretary");
    }

    public void changeCoffee(String newCoffee) {
        if (newCoffee == null) {
            System.out.println("Undefined coffee");
        } else {
            favouriteCoffee = newCoffee;
            System.out.printf("Now I like %s" + System.lineSeparator(), newCoffee);
        }
    }
}
