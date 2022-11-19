package org.example;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExecutiveTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    void sayHelloSuccess() {
        Executive executive = new Executive("Fedor", 19, 400, 2500, "HR", 30);

        executive.sayHello();

        String staticInfoLine = "There is " + Manager.countOfManagers + " manager(-s) in our company";

        assertEquals("Hello, my name is Fedor!" + System.lineSeparator() +
                            "I'm 19 y.o." + System.lineSeparator() +
                            "My salary is 400" + System.lineSeparator() +
                            "My balance is 2500" + System.lineSeparator() +
                            "My scope is HR" + System.lineSeparator() +
                            staticInfoLine + System.lineSeparator() +
                            "I have 30 securities" + System.lineSeparator() +
                            "I fired 0 employees" + System.lineSeparator(), output.toString());
    }

    @Test
    void sayHelloFail() {
        Executive executive = new Executive("Fedor", 19, 400, 2500, "HR", 30);

        executive.isFired = true;
        executive.sayHello();

        assertEquals("I'm fired..." + System.lineSeparator(), output.toString());
    }

    @Test
    void payManagerSalarySuccess() {
        Executive executive = new Executive("Fedor", 19, 400, 2500, "HR", 30);
        Manager manager = new Manager("Egor", 19, 200, 800, "SMM");

        executive.payManagerSalary(manager);

        assertEquals(manager.balance, 1000);
        assertEquals("", output.toString());
    }

    @Test
    void payManagerSalaryFired() {
        Executive executive = new Executive("Fedor", 19, 400, 2500, "HR", 30);
        Manager manager = new Manager("Egor", 19, 200, 800, "SMM");

        executive.isFired = true;
        executive.payManagerSalary(manager);

        assertEquals(manager.balance, 800);
        assertEquals("At first I need to be hired to start working..." + System.lineSeparator(), output.toString());
    }

    @Test
    void payManagerSalaryNull() {
        Executive executive = new Executive("Fedor", 19, 400, 2500, "HR", 30);

        executive.payManagerSalary(null);

        assertEquals("Undefined manager" + System.lineSeparator(), output.toString());
    }

    @Test
    void payManagerSalaryManagerFired() {
        Executive executive = new Executive("Fedor", 19, 400, 2500, "HR", 30);
        Manager manager = new Manager("Egor", 19, 200, 800, "SMM");

        manager.isFired = true;
        executive.payManagerSalary(manager);

        assertEquals(manager.balance, 800);
        assertEquals("Get out and find another work!" + System.lineSeparator(), output.toString());
    }

    @Test
    void fireEmployeeSuccess() {
        Executive executive = new Executive("Fedor", 19, 400, 2500, "HR", 30);
        Manager manager = new Manager("Egor", 19, 200, 800, "SMM");

        executive.fireEmployee(manager);

        assertEquals(manager.isFired, true);
        assertEquals("", output.toString());
    }

    @Test
    void fireEmployeeFired() {
        Executive executive = new Executive("Fedor", 19, 400, 2500, "HR", 30);
        Manager manager = new Manager("Egor", 19, 200, 800, "SMM");

        executive.isFired = true;
        executive.fireEmployee(manager);

        assertEquals(manager.isFired, false);
        assertEquals("At first I need to be hired to start working..." + System.lineSeparator(), output.toString());
    }

    @Test
    void fireEmployeeIsExecutiveEquals() {
        Executive executive1 = new Executive("Fedor", 19, 400, 2500, "HR", 30);
        Executive executive2 = new Executive("Egor", 19, 200, 800, "SMM", 30);

        executive1.fireEmployee(executive2);

        assertEquals(executive2.isFired, false);
        assertEquals("I can't fire my colleague" + System.lineSeparator(), output.toString());
    }

    @Test
    void fireEmployeeIsExecutiveNotEquals() {
        Executive executive1 = new Executive("Fedor", 19, 400, 2500, "HR", 30);
        Executive executive2 = new Executive("Egor", 19, 200, 800, "SMM", 5);

        executive1.fireEmployee(executive2);

        assertEquals(executive2.isFired, true);
        assertEquals("", output.toString());
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
    }
}