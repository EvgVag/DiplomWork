package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TodosTests {
    @Test
    void addTodosTest() {
        Todos todos = new Todos();
        String s = "Попить чай";
        todos.addTask(s);

        List<String> expected = new ArrayList<>();
        expected.add(s);
        List<String> result = todos.tasks;
        Assertions.assertEquals(expected, result);
    }

    @Test
    void removeTodosTest() {
        Todos todos = new Todos();
        String s = "Попить чай";
        String s1 = "Выйти на пробежку";

        todos.addTask(s);
        todos.addTask(s1);
        todos.removeTask(s1);
        List<String> expected = new ArrayList<>();
        expected.add(s);
        List<String> result = todos.tasks;
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getAllTasks() {
        Todos todos = new Todos();
        String s = "Попить чай";
        String s1 = "Выйти на пробежку";

        todos.addTask(s);
        todos.addTask(s1);
        String result = todos.getAllTasks();
        String expected = "Выйти на пробежку Попить чай ";
        Assertions.assertEquals(expected, result);
    }

}
