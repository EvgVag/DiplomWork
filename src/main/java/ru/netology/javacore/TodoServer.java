package ru.netology.javacore;

import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;

public class TodoServer {
    private int port;
    private Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Starting server at " + port + "...");
            Gson gson = new Gson();
            while (true) {

                try (Socket socket = serverSocket.accept();
                     PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                    String json = bufferedReader.readLine();
                    Map map = gson.fromJson(json, Map.class);


                    if (map.get("type").toString().equals("ADD")) {
                        String addTodos = map.get("task").toString();
                        todos.addTask(addTodos);

                    } else {
                        String removeTodos = map.get("task").toString();
                        todos.removeTask(removeTodos);
                    }

                    String a = todos.getAllTasks();
                    printWriter.println(a);
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

