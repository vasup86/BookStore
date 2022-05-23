package bookstoreapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Owner {
    
    private ObservableList<Customer> customers;
    private ObservableList<Books> books;
    private String username;
    private String password;
    private static Owner instance = null;
    
    private Owner(String username, String password){
        customers = FXCollections.observableArrayList();
        books = FXCollections.observableArrayList();
        this.username = username;
        this.password = password;
    }
    
    public static Owner getOwnerInstance(){
        if(instance == null){
            instance = new Owner("admin", "admin");
        }
        return instance;
    }
    
    public void addCustomer(Customer c) {
       customers.add(c);
    }
    public void addBook(Books b) {
       books.add(b);
    }
    
    public void setCustomersList(ObservableList<Customer> customers){
        for(Customer c: customers){
            System.out.println(c.getUsername());
        }
        this.customers = customers;
    }
    
    public void addBooks(String name, double price) {
        books.add(new Books(name, price));
    }
    
    public void voidCustomer(){
        //get new obserable list instance; 
        customers =  FXCollections.observableArrayList();;
    }
    
    public ObservableList<Books> getBooks() {
        return books;
    }
    
    public Customer getCustomers(String username, String password) {
        //fix it 
        //return requested customer
        for(Customer customer : customers){
            if(customer.getUsername().equals(username) && customer.getPassword().equals(password)){
                return (Customer) customers;
            }
        }
        return null;
    }
    
    public ObservableList<Customer> getCustomersList(){
        return customers;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
