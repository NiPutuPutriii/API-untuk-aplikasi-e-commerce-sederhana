package org.example;

import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import org.json.simple.parser.ParseException;

import java.util.Scanner;

public  class Server implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException{
        String[] path = exchange.getRequestURI().getPath().split("/");
        String query = exchange.getRequestURI().getQuery();
        if(!apiAuthorization(exchange)){
            Response response = new Response();
            response.getResponse(exchange, "BAD REQUEST!", 400);
            System.exit(0);
        }
        Request request = new Request();
        if("GET".equals(exchange.getRequestMethod())){
            request.handleGetRequest(exchange,path,query);
        }
        if("POST".equals(exchange.getRequestMethod())){
            try {
                request.handlePostRequest(exchange,path,query);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        if("PUT".equals(exchange.getRequestMethod())){
            try {
                request.handlePutRequest(exchange,path,query);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        if("DELETE".equals(exchange.getRequestMethod())){
            try {
                request.handleDeleteRequest(exchange,path,query);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static Boolean apiAuthorization(HttpExchange exchange) throws FileNotFoundException{
        Headers requestHeaders = exchange.getRequestHeaders();
        String headersKey = "Api-key:"+requestHeaders.getFirst("Api-key");
        File file = new File(".env");
        String api_key = null;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("Api-key")) {
                api_key = line;
            } else{
                api_key = "NULL";
            }
        }
        scanner.close();
        if(headersKey.equals(api_key)){
            return true;
        }
        return false;
    }
}