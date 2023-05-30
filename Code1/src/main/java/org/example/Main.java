package org.example;

import java.net.InetSocketAddress; //untuk menentukan alamat dan port server
import com.sun.net.httpserver.HttpServer; //untuk membuat server HTTP
import java.io.IOException; //untuk mengatasi exception
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IOException {
        try{
            HttpServer httpserver = HttpServer.create(new InetSocketAddress("localhost", 8101),0);
            httpserver.createContext("/", new Server());
            httpserver.setExecutor(Executors.newSingleThreadExecutor());
            httpserver.start();
            System.out.println("Listening on port 8101...");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
