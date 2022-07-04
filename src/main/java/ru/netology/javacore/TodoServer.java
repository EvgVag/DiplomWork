package ru.netology.javacore;

import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    private int port;
    private Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            while (true) {
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                ) {
                    String json = bufferedReader.readLine();
                    Object obj = new JSONParser().parse(json);
                    JSONObject jsonObj = (JSONObject) obj;
                    String typeTodos = (String) jsonObj.get("type");
                    String addTodos = (String) jsonObj.get("task");

                    if (typeTodos.equals("ADD")) {
                        todos.addTask(addTodos);
                    }
                    if (typeTodos.equals("REMOVE")) {

                        todos.removeTask(addTodos);
                    }
                    printWriter.println(todos.getAllTasks());
                }
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}

