package org.example;

import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;


// import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import org.json.simple.parser.ParseException;

public  class Server implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException{
        String[] path = exchange.getRequestURI().getPath().split("/");
        String query = exchange.getRequestURI().getQuery();
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
}