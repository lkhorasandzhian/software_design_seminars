package org.example;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.jupiter.api.Assertions.assertEquals;

class ProgrammerTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    void sayHelloSuccess() {
        List<String> languages = new ArrayList<>();
        languages.add("C++");
        languages.add("Java");
        languages.add("C#");

        Programmer programmer = new Programmer("Levon", 19, 500, 7500, languages, 600);

        programmer.sayHello();

        assertEquals("Hello, my name is Levon!" + System.lineSeparator() +
                            "I'm 19 y.o." + System.lineSeparator() +
                            "My salary is 500" + System.lineSeparator() +
                            "My balance is 7500" + System.lineSeparator() +
                            "List of languages I know: C++ Java C#" + System.lineSeparator() +
                            "I wrote 600 code lines" + System.lineSeparator(), output.toString());
    }

    @Test
    void sayHelloFail() {
        List<String> languages = new ArrayList<>();
        languages.add("C++");
        languages.add("Java");
        languages.add("C#");

        Programmer programmer = new Programmer("Levon", 19, 500, 7500, languages, 600);

        programmer.isFired = true;
        programmer.sayHello();

        assertEquals("I'm fired..." + System.lineSeparator(), output.toString());
    }

    @Test
    void learnNewProgrammingLanguageSuccess() {
        List<String> languages = new ArrayList<>();
        languages.add("C++");
        languages.add("Java");
        languages.add("C#");

        Programmer programmer = new Programmer("Levon", 19, 500, 7500, languages, 600);

        programmer.isFired = true;
        programmer.learnNewProgrammingLanguage("Go");

        assertEquals("I've learnt Go" + System.lineSeparator() +
                            "I hope it will help me to be hired..." + System.lineSeparator(), output.toString());
    }

    @Test
    void learnNewProgrammingLanguageFail() {
        List<String> languages = new ArrayList<>();
        languages.add("C++");
        languages.add("Java");
        languages.add("C#");

        Programmer programmer = new Programmer("Levon", 19, 500, 7500, languages, 600);

        programmer.isFired = true;
        programmer.learnNewProgrammingLanguage("C#");

        assertEquals("I already know C#" + System.lineSeparator(), output.toString());
    }

    @Test
    void writeCodeLinesSuccess() {
        List<String> languages = new ArrayList<>();
        languages.add("C++");
        languages.add("Java");
        languages.add("C#");

        Programmer programmer = new Programmer("Levon", 19, 500, 7500, languages, 600);

        programmer.writeCodeLines(400);

        assertEquals("I've just written 400 code lines" + System.lineSeparator() +
                            "My total count of code lines is 1000" + System.lineSeparator(), output.toString());
    }

    @Test
    void writeCodeLinesFail() {
        List<String> languages = new ArrayList<>();
        languages.add("C++");
        languages.add("Java");
        languages.add("C#");

        Programmer programmer = new Programmer("Levon", 19, 500, 7500, languages, 600);

        programmer.isFired = true;
        programmer.writeCodeLines(400);

        assertEquals("At first I need to be hired to start working..." + System.lineSeparator(), output.toString());
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
    }

}