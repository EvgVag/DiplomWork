package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTests {
    @Test
    void addTodosTest() {
        Todos todos = new Todos();
        String s = "Попить чай";
        String s1 = "Выйти на пробежку";


        todos.addTask(s);
        todos.addTask(s1);


        String expected = "Выйти на пробежку Попить чай";
        String result = todos.getAllTasks();


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


        String expected = "Попить чай";
        String result = todos.getAllTasks();


        Assertions.assertEquals(expected, result);
    }

    @Test
    void removeTodosTestException() {
        Todos todos = new Todos();
        String s = "Попить чай";
        String s1 = "Выйти на пробежку";
        String s2 = "Погулять";

        todos.addTask(s);
        todos.addTask(s1);

        Assertions.assertThrows(IllegalArgumentException.class, () -> todos.removeTask(s2));
    }

}
