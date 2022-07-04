package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    protected List<String> tasks;

    public Todos() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public String getAllTasks() {
        Collections.sort(tasks);
        StringBuilder sb = new StringBuilder();
        for (String s : tasks) {
            sb.append(s);
            sb.append(" ");
        }
        return sb.toString();
    }

}
