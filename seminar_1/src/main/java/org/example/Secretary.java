package org.example;

public final class Secretary extends Employee {
    private String favourite_coffee;

    public Secretary(String name, int age, int salary, int balance, String favourite_coffee) {
        super(name, age, salary, balance);
        this.favourite_coffee = favourite_coffee;
    }

    @Override
    public void sayHello() {
        super.sayHello();
        if (!isFired) {
            System.out.printf("My favourite coffee is %s" + System.lineSeparator(), favourite_coffee);
        }
    }

    public void changeCoffee(String new_coffee) {
        if (new_coffee == null) {
            System.out.println("Undefined coffee");
        } else {
            favourite_coffee = new_coffee;
            System.out.printf("Now I like %s" + System.lineSeparator(), new_coffee);
        }
    }
}
