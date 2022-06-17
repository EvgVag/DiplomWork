package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    List<String> taskList;
    StringBuilder bd = new StringBuilder();

    public Todos() {
        taskList = new ArrayList<>();
    }

    public void addTask(String task) {
        taskList.add(task);
    }

    public void removeTask(String task) {
        if (taskList.contains(task)) {
            taskList.remove(task);
        } else {
            System.out.println("Задача отсутствует");
        }

    }

    public String getAllTasks() {
        Collections.sort(taskList);

        for (String c : taskList) {
            bd.append(c + " ");
        }
        return bd.toString().trim();
    }

}
