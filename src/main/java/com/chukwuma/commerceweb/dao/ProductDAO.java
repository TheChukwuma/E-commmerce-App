package com.chukwuma.commerceweb.dao;

import com.chukwuma.commerceweb.model.Cart;
import com.chukwuma.commerceweb.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private Connection connection;
    private PreparedStatement pst;
    private ResultSet resultSet;
    private static final String INSERT_PRODUCTS_SQL = "INSERT INTO products (name, category, price, quantity) VALUES (?,?,?,?);";
    private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM myproducts";
    private static final String SELECT_PRODUCTS_BY_NAME_OR_CATEGORY = "SELECT * FROM myproducts WHERE name LIKE ? OR category LIKE ?";
    private static final String SELECT_ALL_PRODUCTS_BY_CATEGORY = "SELECT * FROM myproducts WHERE category = ?";
    private static final String DELETE_PRODUCTS_SQL = "DELETE FROM myproducts WHERE name = ?;";
    private static final String UPDATE_PRODUCTS_PRICE_SQL = "UPDATE myproducts SET price = ? WHERE name = ?;";
    private static final String UPDATE_PRODUCTS_QTY_SQL = "UPDATE myproducts SET quantity = ? WHERE name = ?;";

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    public ProductDAO(Connection connection, PreparedStatement pst, ResultSet resultSet) {
        this.connection = connection;
        this.pst = pst;
        this.resultSet = resultSet;
    }

    public String insertProducts(Product product){
        String result;
        int queryStatus;
        try{
            pst = this.connection.prepareStatement(INSERT_PRODUCTS_SQL);
            pst.setString(1, product.getName());
            pst.setString(2, product.getCategory());
            pst.setDouble(3, product.getPrice());
            pst.setLong(4, product.getQuantity());
            queryStatus = pst.executeUpdate();
            if (queryStatus == 1){
                result = "Successfully Added Product To Store";
            }
            else {result = "Failed, Couldn't Add Product To Store";}

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public String updatePrice(String productName, Double price){
        String result;
        int queryStatus;
        try{
            pst = this.connection.prepareStatement(UPDATE_PRODUCTS_PRICE_SQL);
            pst.setDouble(1, price);
            pst.setString(2, productName);
            queryStatus = pst.executeUpdate();
            if (queryStatus == 1){
                result = "Successfully Updated Product Price";
            }
            else {result = "Failed, Couldn't Update Product Price";}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public String updateQuantity(String productName, Long quantity){
        String result = "";
        int queryStatus;
        try{
            pst = this.connection.prepareStatement(UPDATE_PRODUCTS_QTY_SQL);
            pst.setLong(1, quantity);
            pst.setString(2, productName);
            System.out.println(pst);
            queryStatus = pst.executeUpdate();
            if (queryStatus >= 1){
                result = "Successfully Updated Product Quantity";
                System.out.println(result);
            }
            else if (queryStatus < 1) {
                result = "Failed, Couldn't Update Product Quantity In Store";
                System.out.println(result);}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public String deleteAProduct(String productName){
        System.out.println("in the method");
        String result = "";
        try{
            pst = this.connection.prepareStatement(DELETE_PRODUCTS_SQL);
            pst.setString(1, productName);
            System.out.println(pst);
            int valueOfExecution = pst.executeUpdate();
            if(valueOfExecution >= 1){
                result = "successfully deleted " + productName;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<Product> getAllProductsInStore(){
        List<Product> productList = new ArrayList<>();
        try{
            pst = this.connection.prepareStatement(SELECT_ALL_PRODUCTS);
            resultSet = pst.executeQuery();

            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String category = resultSet.getString("category");
                Double price = resultSet.getDouble("price");
                Long qty = resultSet.getLong("quantity");
                String image = resultSet.getString("image");
                Product product = new Product(id, name, category, price, qty, image);
                productList.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    public List<Cart> getCartProducts(ArrayList<Cart> cartList){
        List<Cart> products = new ArrayList<>();
        try {
            if(cartList.size() > 0){
                for (Cart item : cartList){
                    String query = "SELECT * FROM myproducts WHERE id=?";
                    pst = this.connection.prepareStatement(query);
                    pst.setInt(1, item.getId());
                    resultSet = pst.executeQuery();
                    while(resultSet.next()){
                        Cart row  = new Cart();
                        row.setId(resultSet.getInt("id"));
                        row.setName(resultSet.getString("name"));
                        row.setCategory(resultSet.getString("category"));
                        row.setPrice(resultSet.getDouble("price")* item.getProductQuantity());
                        row.setProductQuantity(item.getProductQuantity());
                        products.add(row);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }

    public List<Product> searchByNameOrCategory(String searchTag){
        List<Product> searchList = new ArrayList<>();
        try{
            pst = this.connection.prepareStatement(SELECT_PRODUCTS_BY_NAME_OR_CATEGORY);
            pst.setString(1, "%"+searchTag+"%");
            pst.setString(2, "%"+searchTag+"%");
            resultSet = pst.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String category = resultSet.getString("category");
                Double price = resultSet.getDouble("price");
                Long qty = resultSet.getLong("quantity");
                String image = resultSet.getString("image");
                Product product = new Product(id, name, category, price, qty, image);
                searchList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return searchList;
    }



}
