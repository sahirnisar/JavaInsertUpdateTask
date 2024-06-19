package com.ilp04.entity;

public class Customer {
    private int customerCode;
    private String customerFirstname;
    private String customerLastname;
    private String address;
    private long phoneNo;
    private long aadhar;

    public Customer(int customerCode, String customerFirstname, String customerLastname, String address, long phoneNo, long aadhar) {
        this.customerCode = customerCode;
        this.customerFirstname = customerFirstname;
        this.customerLastname = customerLastname;
        this.address = address;
        this.phoneNo = phoneNo;
        this.aadhar = aadhar;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerFirstame() {
        return customerFirstname;
    }

    public void setCustomerFirstame(String customerFirstname) {
        this.customerFirstname = customerFirstname;
    }

    public String getCustomerLastname() {
        return customerLastname;
    }

    public void setCustomerLastname(String customerLastname) {
        this.customerLastname = customerLastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public long getAadhar() {
        return aadhar;
    }

    public void setAadhar(long aadhar) {
        this.aadhar = aadhar;
    }
}
