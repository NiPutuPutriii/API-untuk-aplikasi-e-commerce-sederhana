package org.example;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.InputStream;
import com.sun.net.httpserver.HttpExchange;
import org.json.simple.parser.ParseException;

public  class Request {
    public void handleGetRequest(HttpExchange exchange, String[] path, String query) throws IOException{
        Response response = new Response();
        Data data = new Data();
        if ("users".equals(path[1])) {
            JSONObject jsonObject = new JSONObject();
            jsonObject = data.selectDatabase(path, query);
            // System.out.print(jsonObject.toString());
            response.getResponse(exchange, jsonObject.toString(), 200);
        } else if ("orders".equals(path[1])) {
            JSONObject jsonObject = new JSONObject();
            jsonObject = data.selectDatabase(path, query);
            response.getResponse(exchange, jsonObject.toString(), 200);
        } else if ("products".equals(path[1])) {
            JSONObject jsonObject = new JSONObject();
            jsonObject = data.selectDatabase(path, query);
            response.getResponse(exchange, jsonObject.toString(), 200);
        }else {
            response.sendResponse(exchange, "\n<h1><center>404</center></h1>\n<h3><center>Not Found!</center></h3>");
        }
    }

    public void handlePostRequest(HttpExchange exchange, String[] path, String query) throws IOException, ParseException {
        Response response = new Response();
        Data data = new Data();
        if (path[1].equals("users")) {
            JSONObject requestBody = parseRequestBody(exchange.getRequestBody());
            response.getResponse(exchange, data.postDatabase(requestBody, path), 200);
        } else if (path[1].equals("products")) {
            JSONObject requestBody = parseRequestBody(exchange.getRequestBody());
            response.getResponse(exchange, data.postDatabase(requestBody, path), 200);
        } else if (path[1].equals("orders")) {
            JSONObject requestBody = parseRequestBody(exchange.getRequestBody());
            response.getResponse(exchange, data.postDatabase(requestBody, path), 200);
        }
    }

    public void handlePutRequest(HttpExchange exchange, String[] path, String query) throws IOException, ParseException{
        Response response = new Response();
        Data data = new Data();
        if(path.length != 3){
            response.getResponse(exchange, "MAAF URL ANDA SALAH", 0);
        }else {
            if(path[1].equals("users")){
                JSONObject requestBody = parseRequestBody(exchange.getRequestBody());
                response.getResponse(exchange, data.putData(requestBody, path), 200);
            }else if(path[1].equals("products")){
                JSONObject requestBody = parseRequestBody(exchange.getRequestBody());
                response.getResponse(exchange, data.putData(requestBody, path), 200);
            }else if(path[1].equals("orders")){
                JSONObject requestBody = parseRequestBody(exchange.getRequestBody());
                response.getResponse(exchange, data.putData(requestBody, path), 200);
            }
        }
    }

    public void handleDeleteRequest(HttpExchange exchange, String[] path, String query) throws IOException, ParseException{
        Response response = new Response();
        Data data = new Data();
        if(path.length != 3){
            response.getResponse(exchange, "MAAF URL ANDA SALAH", 0);
        }else {
            if(path[1].equals("users")){
                response.getResponse(exchange, data.deleteData(path), 200);
            }else if(path[1].equals("products")){
                response.getResponse(exchange, data.deleteData(path), 200);
            }else if(path[1].equals("orders")){
                response.getResponse(exchange, data.deleteData(path), 200);
            }
        }
    }

    private JSONObject parseRequestBody(InputStream requestBody) throws ParseException, IOException{
        JSONParser jsonParser = new JSONParser();
        byte[] requestBodyBytes = requestBody.readAllBytes();
        String requestBodyString = new String(requestBodyBytes);
        return (JSONObject) jsonParser.parse(requestBodyString);
    }
}