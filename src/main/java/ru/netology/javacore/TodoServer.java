package ru.netology.javacore;

import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TodoServer {
    private int port;
    private Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket socket = serverSocket.accept();
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println("Starting server at " + port + "...");
            JSONParser jsonParser = new JSONParser();

            while (true) {
                if (!bufferedReader.ready()) {
                    break;
                }
                String json = bufferedReader.readLine();
                Object o = jsonParser.parse(json);
                JSONObject jsonObject = (JSONObject) o;
                for (int i = 0; i < jsonObject.size(); ) {
                    String typeTodos = (String) jsonObject.get("type");
                    if (typeTodos.equals("ADD")) {
                        String addTodos = (String) jsonObject.get("task");
                        todos.addTask(addTodos);
                    } else {
                        String removeTodos = (String) jsonObject.get("task");
                        todos.removeTask(removeTodos);
                    }
                }

            }

            String a = todos.getAllTasks();
            System.out.println(a);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

