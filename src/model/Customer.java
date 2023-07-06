package model;

public class Customer {
    private String customerName;
    private String customerPhoneNumber;
    private String email;
    private String address;

    public Customer() {
    }

    public Customer(String name, String phoneNumber, String email, String address) {
        this.customerName = name;
        this.customerPhoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhoneNumber() {
        return this.customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}