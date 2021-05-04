package com.store.database;

import com.store.model.Customer;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CustomerDatabase {
    public static final String PATH = "customer.csv";
    public static Map<String, Customer> customerMap;
    public static int count;

    static {
        customerMap = new HashMap<>();
        count = 0;
    }

    public void saveFile() throws IOException {
        File file = new File(PATH);
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("New file was created!!!");
        }
        FileOutputStream fos = new FileOutputStream(PATH);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        for (Map.Entry<String, Customer> entry : customerMap.entrySet()
        ) {
            bos.write(entry.getValue().toStringCSV().getBytes());
        }
        bos.flush();
        bos.close();
        fos.close();
    }

    public void add(Customer customer){
        count++;
        customerMap.put(customer.getPhoneNumber(), customer);
    }

    public boolean remove(int id) {
        boolean result = customerMap.remove(id) == null ? false : true;
        return result;
    }

    public void readFile() throws Exception {
        File file = new File(PATH);
        if (!file.exists()) {
            System.out.println("File not exists!!!");
            return;
        }
        FileReader fr = new FileReader(PATH);
        BufferedReader br = new BufferedReader(fr);
        String line;

        while ((line = br.readLine()) != null) {
            String[] arr = line.split(",");
            Customer customer = new Customer((arr[0]), arr[1], arr[2], (arr[3]), arr[4], Integer.parseInt(arr[5]));
            add(customer);
        }
    }
    public String find(String phoneNumber) {
        for (String key: customerMap.keySet()) {
            if(key == phoneNumber){
                return phoneNumber;
            }
        }
        System.out.println("Khach hang khong ton tai!!!");
        return null;
    }
    public int size(){
        return customerMap.size();
    }
}