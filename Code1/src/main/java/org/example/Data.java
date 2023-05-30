package org.example;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class Data {
    public JSONObject selectDatabase(String[] path, String query){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\n8n0c\\OneDrive\\Documents\\Assignment\\KelasPBO\\API-untuk-aplikasi-e-commerce-sederhana\\ecommerce.db");
            Statement statement = connection.createStatement();
            System.out.println("connection berhasil");
            if(query != null){
                if(path[1].equals("users")){
                    JSONObject jsonObject = new JSONObject();
                    JSONArray array = new JSONArray();
                    ResultSet rs = statement.executeQuery("select * from " + path[1] + " where " + query );
                    while(rs.next()) {
                        JSONObject record = new JSONObject();
                        record.put("Id_User", rs.getInt("id"));
                        record.put("First_Name", rs.getString("first_name"));
                        record.put("Last_Name", rs.getString("last_name"));
                        record.put("Email", rs.getString("email"));
                        record.put("Phone_Number", rs.getString("phone_number"));
                        record.put("Type", rs.getString("type"));
                        array.add(record);
                    }
                    jsonObject.put("User Information", array);
                    return jsonObject;
                }
            }
            if(path[1].equals("users")){
                JSONObject jsonObject = new JSONObject();
                JSONArray array = new JSONArray();
                if(path.length == 2){
                    ResultSet rs = statement.executeQuery("select * from " + path[1]);
                    while(rs.next()) {
                        JSONObject record = new JSONObject();
                        record.put("Id_User", rs.getInt("id_user"));
                        record.put("First_Name", rs.getString("first_name"));
                        record.put("Last_Name", rs.getString("last_name"));
                        record.put("Email", rs.getString("email"));
                        record.put("Phone_Number", rs.getString("phone_number"));
                        record.put("Type", rs.getString("type"));
                        array.add(record);
                    }
                    jsonObject.put("User Information", array);
                    return jsonObject;
                }
                if(path.length == 3){
                    ResultSet rs = statement.executeQuery("select * from " + path[1] + " where id_user=" + path[2]);
                    while(rs.next()) {
                        JSONObject record = new JSONObject();
                        record.put("Id_User", rs.getInt("id_user"));
                        record.put("First_Name", rs.getString("first_name"));
                        record.put("Last_Name", rs.getString("last_name"));
                        record.put("Email", rs.getString("email"));
                        record.put("Phone_Number", rs.getString("phone_number"));
                        record.put("Type", rs.getString("type"));
                        array.add(record);
                    }
                    jsonObject.put("User Information", array);
                    return jsonObject;
                }
                if(path.length == 4){
                    if(path[3].equals("orders")){
                        ResultSet rs = statement.executeQuery("select users.id_user, users.first_name, users.last_name, orders.note, products.title, order_details.quantity, order_details.price from orders inner join users on orders.id_user = users.id_user inner join order_details on order_details.id_order = orders.id_user inner join products on products.id_product = order_details.id_product where orders.id_user=" + path[2]);
                        while(rs.next()) {
                            JSONObject record = new JSONObject();
                            record.put("Id_User", rs.getInt("id_user"));
                            record.put("First_Name", rs.getString("first_name"));
                            record.put("Last_Name", rs.getString("last_name"));
                            record.put("Note", rs.getString("note"));
                            record.put("Title", rs.getString("title"));
                            record.put("Quantity", rs.getString("quantity"));
                            record.put("Price", rs.getString("price"));
                            array.add(record);
                        }
                        jsonObject.put("User Information", array);
                        return jsonObject;
                    }
                    if(path[3].equals("products")){
                        ResultSet rs = statement.executeQuery("select users.id_user, users.first_name, users.last_name, products.title,products.price,products.description, products.stock from products inner join users on products.id_user = users.id_user where products.id_user=" + path[2]);
                        while(rs.next()) {
                            JSONObject record = new JSONObject();
                            record.put("Id_User", rs.getInt("id_user"));
                            record.put("First_Name", rs.getString("first_name"));
                            record.put("Last_Name", rs.getString("last_name"));
                            record.put("Title", rs.getString("title"));
                            record.put("Price", rs.getInt("price"));
                            record.put("Description", rs.getString("description"));
                            record.put("Stock", rs.getInt("stock"));
                            array.add(record);
                        }
                        jsonObject.put("User Information", array);
                        return jsonObject;
                    }
                    if(path[3].equals("reviews")){
                        ResultSet rs = statement.executeQuery("select users.id_user, users.first_name, users.last_name,reviews.star,reviews.description from reviews inner join orders on reviews.id_order = orders.id_user inner join users on orders.id_user = users.id_user where orders.id_user="+ path[2]);
                        while(rs.next()) {
                            JSONObject record = new JSONObject();
                            record.put("Id_User", rs.getInt("id_user"));
                            record.put("First_Name", rs.getString("first_name"));
                            record.put("Last_Name", rs.getString("last_name"));
                            record.put("Star", rs.getString("star"));
                            record.put("Description", rs.getString("description"));
                            array.add(record);
                        }
                        jsonObject.put("User Information", array);
                        return jsonObject;
                    }
                }
            }
            else if(path[1].equals("products")){
                JSONObject jsonObject = new JSONObject();
                JSONArray array = new JSONArray();
                System.out.println(query);
                if(path.length == 2){
                    ResultSet rs = statement.executeQuery("select * from " + path[1]);
                    while(rs.next()) {
                        JSONObject record = new JSONObject();
                        record.put("Stock", rs.getInt("stock"));
                        record.put("Price", rs.getString("price"));
                        record.put("Description", rs.getString("description"));
                        record.put("Title", rs.getString("title"));
                        record.put("Id_User", rs.getInt("id_user"));
                        record.put("Id", rs.getInt("id_product"));
                        array.add(record);
                    }
                    jsonObject.put("Product Information", array);
                    return jsonObject;
                }
                if(path.length == 3){
                    ResultSet rs = statement.executeQuery("select * from " + path[1] + " where id_product=" + path[2]);
                    while(rs.next()) {
                        JSONObject record = new JSONObject();
                        record.put("Stock", rs.getInt("stock"));
                        record.put("Price", rs.getString("price"));
                        record.put("Description", rs.getString("description"));
                        record.put("Title", rs.getString("title"));
                        record.put("Id_User", rs.getInt("id_user"));
                        record.put("Id", rs.getInt("id_product"));
                        array.add(record);
                    }
                    jsonObject.put("Product Information", array);
                    return jsonObject;
                }
            }
            else if(path[1].equals("orders")){
                JSONObject jsonObject = new JSONObject();
                JSONArray array = new JSONArray();
                if(path.length == 2){
                    ResultSet rs = statement.executeQuery("select * from " + path[1]);
                    while(rs.next()) {
                        JSONObject record = new JSONObject();
                        record.put("isPaid", rs.getInt("is_paid"));
                        record.put("Discount", rs.getInt("discount"));
                        record.put("Total", rs.getInt("total"));
                        record.put("Note", rs.getInt("note"));
                        record.put("Id_User", rs.getInt("id_user"));
                        record.put("Id", rs.getInt("id_order"));
                        array.add(record);
                    }
                    jsonObject.put("Orders Information", array);
                    return jsonObject;
                }
                if(path.length == 3){
                    ResultSet rs = statement.executeQuery("select * from " + path[1] + " where id_order=" + path[2]);
                    while(rs.next()) {
                        JSONObject record = new JSONObject();
                        record.put("isPaid", rs.getInt("is_paid"));
                        record.put("Discount", rs.getInt("discount"));
                        record.put("Total", rs.getInt("total"));
                        record.put("Note", rs.getInt("note"));
                        record.put("Id_User", rs.getInt("id_user"));
                        record.put("Id", rs.getInt("id_order"));
                        array.add(record);
                    }
                    jsonObject.put("Orders Information", array);
                    return jsonObject;
                }
            }
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public String postDatabase(JSONObject requestBodyJson, String[] path){
        if(path[1].equals("users")){
            String first_name = (String) requestBodyJson.get("First_Name");
            String last_name = (String) requestBodyJson.get("Last_Name");
            String email = (String) requestBodyJson.get("Email");
            String phone_number = (String) requestBodyJson.get("Phone_Number");
            String type = (String) requestBodyJson.get("Type");
            PreparedStatement statement = null;
            int rowsAffected = 0;
            String query = "INSERT INTO users(first_name, last_name, email, phone_number, type) VALUES(?,?,?,?,?)";
            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\n8n0c\\OneDrive\\Documents\\Assignment\\KelasPBO\\API-untuk-aplikasi-e-commerce-sederhana\\ecommerce.db");
                statement = connection.prepareStatement(query);
                statement.setString(1, first_name);
                statement.setString(2, last_name);
                statement.setString(3, email);
                statement.setString(4, phone_number);
                statement.setString(5, type);
                rowsAffected = statement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
            System.out.println(rowsAffected + " rows inserted!");
            return rowsAffected + " rows inserted!";
        }
        else if(path[1].equals("orders")){
            int id_user = Integer.parseInt(requestBodyJson.get("Id_User").toString());
            int note = Integer.parseInt(requestBodyJson.get("Note").toString());
            int total = Integer.parseInt(requestBodyJson.get("Total").toString());
            int discount = Integer.parseInt(requestBodyJson.get("Discount").toString());
            int isPaid = Integer.parseInt(requestBodyJson.get("isPaid").toString());
            PreparedStatement statement = null;
            int rowsAffected = 0;
            String query = "INSERT INTO orders(id_user, note, total, discount, is_paid) VALUES(?,?,?,?,?)";
            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\n8n0c\\OneDrive\\Documents\\Assignment\\KelasPBO\\API-untuk-aplikasi-e-commerce-sederhana\\ecommerce.db");
                statement = connection.prepareStatement(query);
                statement.setInt(1, id_user);
                statement.setInt(2, note);
                statement.setInt(3, total);
                statement.setInt(4, discount);
                statement.setInt(5, isPaid);
                rowsAffected = statement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
            System.out.println(rowsAffected + " rows inserted!");
            return rowsAffected + " rows inserted!";
        }
        else if(path[1].equals("products")){
            int id_seller = Integer.parseInt(requestBodyJson.get("Id_User").toString());
            String title = requestBodyJson.get("Title").toString();
            String description = requestBodyJson.get("Description").toString();
            int price = Integer.parseInt(requestBodyJson.get("Price").toString());
            int stock = Integer.parseInt(requestBodyJson.get("Stock").toString());
            PreparedStatement statement = null;
            int rowsAffected = 0;
            String query = "INSERT INTO products(id_user, title, description, price, stock) VALUES(?,?,?,?,?)";
            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\n8n0c\\OneDrive\\Documents\\Assignment\\KelasPBO\\API-untuk-aplikasi-e-commerce-sederhana\\ecommerce.db");
                statement = connection.prepareStatement(query);
                statement.setInt(1, id_seller);
                statement.setString(2, title);
                statement.setString(3, description);
                statement.setInt(4, price);
                statement.setInt(5, stock);
                rowsAffected = statement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
            System.out.println(rowsAffected + " rows inserted!");
            return rowsAffected + " rows inserted!";
        }
        return null;
    }

    public String putData(JSONObject requestBodyJson, String[] path){
        if(path[1].equals("users")){
            String first_name = (String) requestBodyJson.get("First_Name");
            String last_name = (String) requestBodyJson.get("Last_Name");
            String email = (String) requestBodyJson.get("Email");
            String phone_number = (String) requestBodyJson.get("Phone_Number");
            String type = (String) requestBodyJson.get("Type");
            PreparedStatement statement = null;
            int rowsAffected = 0;
            String query = "UPDATE users SET first_name = ?, last_name = ?, email = ?, phone_number = ?, type = ? WHERE id_user=" + path[2];
            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\n8n0c\\OneDrive\\Documents\\Assignment\\KelasPBO\\API-untuk-aplikasi-e-commerce-sederhana\\ecommerce.db");
                statement = connection.prepareStatement(query);
                statement.setString(1, first_name);
                statement.setString(2, last_name);
                statement.setString(3, email);
                statement.setString(4, phone_number);
                statement.setString(5, type);
                rowsAffected = statement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
            System.out.println(rowsAffected + " rows updated!");
            return rowsAffected + " rows updated!";
        }

        else if(path[1].equals("orders")){
            int id_buyer = Integer.parseInt(requestBodyJson.get("Id_User").toString());
            int note = Integer.parseInt(requestBodyJson.get("Note").toString());
            int total = Integer.parseInt(requestBodyJson.get("Total").toString());
            int discount = Integer.parseInt(requestBodyJson.get("Discount").toString());
            int isPaid = Integer.parseInt(requestBodyJson.get("isPaid").toString());
            PreparedStatement statement = null;
            int rowsAffected = 0;
            String query = "UPDATE orders SET id_user = ?, note = ?, total = ?, discount = ?, is_paid = ? WHERE id_order=" + path[2];
            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\n8n0c\\OneDrive\\Documents\\Assignment\\KelasPBO\\API-untuk-aplikasi-e-commerce-sederhana\\ecommerce.db");
                statement = connection.prepareStatement(query);
                statement.setInt(1, id_buyer);
                statement.setInt(2, note);
                statement.setInt(3, total);
                statement.setInt(4, discount);
                statement.setInt(5, isPaid);
                rowsAffected = statement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
            System.out.println(rowsAffected + " rows updated!");
            return rowsAffected + " rows updated!";
        }
        else if(path[1].equals("products")){
            int id_seller = Integer.parseInt(requestBodyJson.get("Id_User").toString());
            String title = requestBodyJson.get("Title").toString();
            String description = requestBodyJson.get("Description").toString();
            int price = Integer.parseInt(requestBodyJson.get("Price").toString());
            int stock = Integer.parseInt(requestBodyJson.get("Stock").toString());
            PreparedStatement statement = null;
            int rowsAffected = 0;
            String query = "UPDATE products SET id_user = ?, title = ?, description = ?,  price = ?, stock = ? WHERE id_product=" + path[2];
            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\n8n0c\\OneDrive\\Documents\\Assignment\\KelasPBO\\API-untuk-aplikasi-e-commerce-sederhana\\ecommerce.db");
                statement = connection.prepareStatement(query);
                statement.setInt(1, id_seller);
                statement.setString(2, title);
                statement.setString(3, description);
                statement.setInt(4, price);
                statement.setInt(5, stock);
                rowsAffected = statement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
            System.out.println(rowsAffected + " rows updated!");
            return rowsAffected + " rows updated!";
        }
        return null;
    }

    public String deleteData(String[] path){
        PreparedStatement statement = null;
        int rowsAffected = 0;
        String id;
        if(path[1].equals("users")) id = "user";
        else if(path[1].equals("orders")) id = "order";
        else if(path[1].equals("products")) id = "product";
        else id = "nothing";
        try {
            String query = "DELETE FROM " + path[1] + " WHERE id_" + id +"=" + path[2];
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\n8n0c\\OneDrive\\Documents\\Assignment\\KelasPBO\\API-untuk-aplikasi-e-commerce-sederhana\\ecommerce.db");
            statement = connection.prepareStatement(query);
            rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return rowsAffected + " rows deleted!";
    }
}
    // private JSONObject getData(JSONObject object, JSONArray array, ResultSet rs){

    // }