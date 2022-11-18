package org.example;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SecretaryTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    void sayHelloSuccess() {
        Secretary secretary = new Secretary("Olga", 20, 50, 250, "latte");

        secretary.sayHello();

        assertEquals("Hello, my name is Olga!" + System.lineSeparator() +
                            "I'm 20 y.o." + System.lineSeparator() +
                            "My salary is 50" + System.lineSeparator() +
                            "My balance is 250" + System.lineSeparator() +
                            "My favourite coffee is latte" + System.lineSeparator(), output.toString());
    }

    @Test
    void sayHelloFail() {
        Secretary secretary = new Secretary("Olga", 20, 50, 250, "latte");

        secretary.isFired = true;
        secretary.sayHello();

        assertEquals("I'm fired..." + System.lineSeparator(), output.toString());
    }

    @Test
    void changeCoffeeSuccess() {
        Secretary secretary = new Secretary("Olga", 20, 50, 250, "latte");

        secretary.changeCoffee("cappuccino");

        assertEquals("Now I like cappuccino" + System.lineSeparator(), output.toString());
    }

    @Test
    void changeCoffeeFail() {
        Secretary secretary = new Secretary("Olga", 20, 50, 250, "latte");

        secretary.changeCoffee(null);

        assertEquals("Undefined coffee" + System.lineSeparator(), output.toString());
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
    }
}