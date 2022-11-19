package org.example;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManagerTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    void sayHelloSuccess() {
        Manager manager = new Manager("Fedor", 19, 400, 2500, "HR");

        manager.sayHello();

        String staticInfoLine = "There is " + Manager.countOfManagers + " manager(-s) in our company";

        assertEquals("Hello, my name is Fedor!" + System.lineSeparator() +
                            "I'm 19 y.o." + System.lineSeparator() +
                            "My salary is 400" + System.lineSeparator() +
                            "My balance is 2500" + System.lineSeparator() +
                            "My scope is HR" + System.lineSeparator() +
                            staticInfoLine + System.lineSeparator(), output.toString());
    }

    @Test
    void sayHelloFail() {
        Manager manager = new Manager("Fedor", 19, 400, 2500, "HR");

        manager.isFired = true;
        manager.sayHello();

        assertEquals("I'm fired..." + System.lineSeparator(), output.toString());
    }

    @Test
    void changeScopeSuccess() {
        Manager manager = new Manager("Fedor", 19, 400, 2500, "HR");

        manager.isFired = true;
        manager.changeScope("SMM");

        assertEquals("Now my scope is SMM" + System.lineSeparator(), output.toString());
    }

    @Test
    void changeScopeFail() {
        Manager manager = new Manager("Fedor", 19, 400, 2500, "HR");

        manager.isFired = true;
        manager.changeScope(null);

        assertEquals("Undefined scope" + System.lineSeparator(), output.toString());
    }

    @Test
    void payEmployeeSalarySuccess() {
        Manager manager = new Manager("Fedor", 19, 400, 2500, "HR");
        Secretary secretary = new Secretary("Olga", 20, 50, 250, "latte");

        manager.payEmployeeSalary(secretary);

        assertEquals(secretary.balance, 300);
        assertEquals("", output.toString());
    }

    @Test
    void payEmployeeSalaryFired() {
        Manager manager = new Manager("Fedor", 19, 400, 2500, "HR");
        Secretary secretary = new Secretary("Olga", 20, 50, 250, "latte");

        manager.isFired = true;
        manager.payEmployeeSalary(secretary);

        assertEquals(secretary.balance, 250);
        assertEquals("At first I need to be hired to start working..." + System.lineSeparator(), output.toString());
    }

    @Test
    void payEmployeeSalaryNull() {
        Manager manager = new Manager("Fedor", 19, 400, 2500, "HR");

        manager.payEmployeeSalary(null);

        assertEquals("Undefined employee" + System.lineSeparator(), output.toString());
    }

    @Test
    void payEmployeeSalaryEmployeeFired() {
        Manager manager = new Manager("Fedor", 19, 400, 2500, "HR");
        Secretary secretary = new Secretary("Olga", 20, 50, 250, "latte");

        secretary.isFired = true;
        manager.payEmployeeSalary(secretary);

        assertEquals(secretary.balance, 250);
        assertEquals("Get out and find another work!" + System.lineSeparator(), output.toString());
    }

    @Test
    void payEmployeeSalaryBothManager() {
        Manager manager1 = new Manager("Fedor", 19, 400, 2500, "HR");
        Manager manager2 = new Manager("Igor", 20, 50, 250, "SMM");

        manager1.payEmployeeSalary(manager2);

        assertEquals(manager2.balance, 250);
        assertEquals("Managers don't pay money to each other" + System.lineSeparator(), output.toString());
    }

    @Test
    void payEmployeeSalaryBothExecutive() {
        Executive executive1 = new Executive("Fedor", 19, 400, 2500, "HR", 5);
        Executive executive2 = new Executive("Igor", 20, 50, 250, "SMM", 10);

        executive1.payEmployeeSalary(executive2);

        assertEquals(executive2.balance, 250);
        assertEquals("Executives don't pay money to each other" + System.lineSeparator(), output.toString());
    }

    @Test
    void payEmployeeSalaryOneManagerOneExecutive() {
        Manager manager = new Manager("Fedor", 19, 400, 2500, "HR");
        Executive executive = new Executive("Igor", 20, 50, 250, "SMM", 10);

        manager.payEmployeeSalary(executive);

        assertEquals(executive.balance, 250);
        assertEquals("Generally I don't give salary to executive, rather the opposite..." + System.lineSeparator(), output.toString());
    }

    @Test
    void payEmployeeSalaryOneExecutiveOneManager() {
        Executive executive = new Executive("Igor", 20, 50, 250, "SMM", 10);
        Manager manager = new Manager("Fedor", 19, 400, 2500, "HR");

        executive.payEmployeeSalary(manager);

        assertEquals(manager.balance, 2900);
        assertEquals("", output.toString());
    }

    @Test
    void payEmployeeSalaryManagerToHimself() {
        Manager manager = new Manager("Fedor", 19, 400, 2500, "HR");

        manager.payEmployeeSalary(manager);

        assertEquals(manager.balance, 2500);
        assertEquals("Managers don't pay money to each other" + System.lineSeparator(), output.toString());
    }

    @Test
    void payEmployeeSalaryExecutiveToHimself() {
        Executive executive = new Executive("Fedor", 19, 400, 2500, "HR", 20);

        executive.payEmployeeSalary(executive);

        assertEquals(executive.balance, 2500);
        assertEquals("Executives don't pay money to each other" + System.lineSeparator(), output.toString());
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
    }
}