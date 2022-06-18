package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    List<String> taskList = new ArrayList<>();
    ;
    StringBuilder bd = new StringBuilder();


    public void addTask(String task) {
        taskList.add(task);
    }

    public void removeTask(String task) {
        if (taskList.contains(task)) {
            taskList.remove(task);
        } else {
            throw new IllegalArgumentException("Задача отсутствует");
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
