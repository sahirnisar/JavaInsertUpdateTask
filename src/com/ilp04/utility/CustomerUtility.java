package com.ilp04.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp04.entity.Customer;
import com.ilp04.service.*;

public class CustomerUtility {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Display all customers");
            System.out.println("2. Insert a new customer");
            System.out.println("3. Update an existing customer");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    getAllCustomers();
                    break;
                case 2:
                    insertCustomer(scanner);
                    break;
                case 3:
                    updateCustomer(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void getAllCustomers() {
        CustomerService customerService = new CustomerServiceImpl();
        ArrayList<Customer> customerList = customerService.getAllCustomers();
        for (Customer customer : customerList) {
            System.out.println("CustomerCode: " + customer.getCustomerCode());
            System.out.println("CustomerFirstName: " + customer.getCustomerFirstame());
            System.out.println("CustomerLastName: " + customer.getCustomerLastname());
            System.out.println("Address: " + customer.getAddress());
            System.out.println("Phone number: " + customer.getPhoneNo());
            System.out.println("Aadhar: " + customer.getAadhar());
            System.out.println();
        }
    }

    private static void insertCustomer(Scanner scanner) {
        System.out.println("Enter customer first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter address:");
        String address = scanner.nextLine();
        System.out.println("Enter phone number:");
        long phoneNo = scanner.nextLong();
        System.out.println("Enter Aadhar number:");
        long aadhar = scanner.nextLong();

        Customer customer = new Customer(0, firstName, lastName, address, phoneNo, aadhar);
        CustomerService customerService = new CustomerServiceImpl();
        int result = customerService.insertIntoCustomer(customer);
        if (result > 0) {
            System.out.println("Customer inserted successfully.");
        } else {
            System.out.println("Failed to insert customer.");
        }
    }

    private static void updateCustomer(Scanner scanner) {
        System.out.println("Enter customer code:");
        int customerCode = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter new customer first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter new customer last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter new customer address:");
        String address = scanner.nextLine();
        System.out.println("Enter new customer phone number:");
        long phoneNo = scanner.nextLong();
        System.out.println("Enter new customer Aadhar number:");
        long aadhar = scanner.nextLong();

        Customer customer = new Customer(customerCode, firstName, lastName, address, phoneNo, aadhar);
        CustomerService customerService = new CustomerServiceImpl();
        int result = customerService.updateCustomer(customer);
        if (result > 0) {
            System.out.println("Customer updated successfully.");
        } else {
            System.out.println("Failed to update customer.");
        }
    }
}
