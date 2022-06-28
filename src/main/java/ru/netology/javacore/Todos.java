package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    List<String> tasks;

    public Todos() {
        this.tasks = new ArrayList<String>();
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public String getAllTasks() {
        Collections.sort(tasks);
        String bd = "";
        for (String s : tasks) bd += s + " ";
        return bd;
    }

}
