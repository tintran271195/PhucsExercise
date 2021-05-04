package com.store.manager;

import com.store.database.CustomerDatabase;
import com.store.model.Customer;

import java.util.Map;

public class CustomerManager {
    public CustomerDatabase customerDatabase = new CustomerDatabase();

    public void add(Customer customer) throws Exception {
        customerDatabase.add(customer);
        customerDatabase.saveFile();
    }
    public void loadFile() throws Exception {
        customerDatabase.readFile();
    }
    public Customer find(String phoneNumber){
        return customerDatabase.customerMap.get(phoneNumber);
    }
    public void print(){
        for (Map.Entry<String, Customer> entry: customerDatabase.customerMap.entrySet()
             ) {
            System.out.println(entry.getValue().toString());
        }
    }
    public void getSize(){
        System.out.println("Tong so khach hang la: " + customerDatabase.size());
    }
}
