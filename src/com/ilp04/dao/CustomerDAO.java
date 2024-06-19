package com.ilp04.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ilp04.entity.Customer;

public class CustomerDAO {
    // Get connection
    public Connection getConnection() {
        String connectionURL = "jdbc:mysql://localhost:3306/bankdb?useSSL=false";
        String userName = "root";
        String password = "experion@123";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Close connection
    public void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Customer> getAllCustomers(Connection connection) {
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        Statement statement;
        ResultSet resultSet;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM customer");
            while (resultSet.next()) {
                int customerCode = resultSet.getInt("customer_code");
                String customerFirstname = resultSet.getString("customer_firstname");
                String customerLastname = resultSet.getString("customer_lastname");
                String address = resultSet.getString("address");
                Long phoneNo = resultSet.getLong("phone_number");
                Long aadhar = resultSet.getLong("aadhar_number");
                Customer customer = new Customer(customerCode, customerFirstname, customerLastname, address, phoneNo, aadhar);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public int insertIntoCustomer(Connection connection, Customer customer) {
        int result = 0;
        String query = "INSERT INTO customer (customer_firstname, customer_lastname, address, phone_number, aadhar_number) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, customer.getCustomerFirstame());
            preparedStatement.setString(2, customer.getCustomerLastname());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.setLong(4, customer.getPhoneNo());
            preparedStatement.setLong(5, customer.getAadhar());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int updateCustomer(Connection connection, Customer customer) {
        int result = 0;
        String query = "UPDATE customer SET customer_firstname = ?, customer_lastname = ?, address = ?, phone_number = ?, aadhar_number = ? WHERE customer_code = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, customer.getCustomerFirstame());
            preparedStatement.setString(2, customer.getCustomerLastname());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.setLong(4, customer.getPhoneNo());
            preparedStatement.setLong(5, customer.getAadhar());
            preparedStatement.setInt(6, customer.getCustomerCode());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
