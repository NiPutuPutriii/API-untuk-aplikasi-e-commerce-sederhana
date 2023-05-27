package org.example;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.SQLOutput;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress("localhost",8101), 0);
        httpServer.createContext("/", new Request());
        httpServer.setExecutor(Executors.newSingleThreadExecutor());
        httpServer.start();
        System.out.println("Listening on port 8101...");
    }

    public static class Request implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String[] path = exchange.getRequestURI().getPath().split("/");
            String query = exchange.getRequestURI().getQuery();
            System.out.println(exchange.getRequestURI().toString());
            if("GET".equals(exchange.getRequestMethod())){
                if ("users".equals(path[1])){
                    response(exchange, path, query);
                }
                else if ("orders".equals(path[1])){
                    response(exchange, path, query);
                }
                else if ("products".equals(path[1])){
                    response(exchange, path, query);
                }
                else {
                    OutputStream outputStream = exchange.getResponseBody();
                    String responseToBeSentBack = "Error not found";
                    exchange.sendResponseHeaders(404, responseToBeSentBack.length());

                    outputStream.write(responseToBeSentBack.getBytes());
                    outputStream.flush();
                    outputStream.close();

                }

            }
        }
        public static void response (HttpExchange exchange, String[] path, String query) throws IOException{
            OutputStream outputStream = exchange.getResponseBody();
            String responseToBeSentBack = "Hello from " + path[1];
            exchange.sendResponseHeaders(200, responseToBeSentBack.length());

            outputStream.write(responseToBeSentBack.getBytes());
            outputStream.flush();
            outputStream.close();

        }

    }
}