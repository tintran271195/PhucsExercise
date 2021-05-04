package com.store.presentation;

import com.store.manager.CustomerManager;
import com.store.model.Customer;

import java.io.IOException;
import java.util.Scanner;

public class MainStore {
    static CustomerManager customerManager = new CustomerManager();
    public static Scanner input = new Scanner(System.in);

    public static void displayMenu() {
        System.out.println("Chao mung ban den he thong quan ly khach hang: \n"
                + "Bam 1 de nhap khach hang moi. \n"
                + "Bam 2 de tim kiem khach hang. \n"
                + "Bam 3 de in thong tin khach hang. \n"
                + "Bam 4 de in toan bo danh sach khach hang. \n"
                + "Bam 5 de tang so don hang cho khach. \n"
                + "Bam 0 de thoat chuong trinh");
        String choice = input.nextLine();
        switch (choice) {
            case "1":
                try {
                    addNewCustomer();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "2":
                findCustomer();
                break;
            case "3":
                printCustomer();
                break;
            case "4":
                printListCustomer();
                break;
            case "5":
                improveOrderNumber();
                break;
            case "0":
                System.exit(0);
                break;
            default:
                System.out.println("Nhap sai, vui long nhap lai ....");
                input.nextLine();
                displayMenu();
                break;
        }
    }

    private static void improveOrderNumber() {
        System.out.println("Nhap sdt khach hang: ");
        String phoneNumber = input.nextLine();
        if (customerManager.find(phoneNumber) == null) {
            System.out.println("Khach hang khong ton tai!!!");
            System.out.println("Nhan phim bat ky de tiep tuc!!!");
            input.nextLine();
            displayMenu();
        } else {
            int orderNumber = customerManager.find(phoneNumber).getOrderNumber() + 1;
            customerManager.find(phoneNumber).setOrderNumber(orderNumber);
            System.out.println("Tang don hang thanh cong!!!");
            System.out.println(customerManager.find(phoneNumber));
            System.out.println("Nhan phim bat ky de tiep tuc!!!");
            input.nextLine();
            displayMenu();
        }
    }

    private static void printListCustomer() {
        customerManager.print();
        customerManager.getSize();
        System.out.println("Bam phim bat ky de tiep tuc ....");
        input.nextLine();
        displayMenu();
    }


    private static void printCustomer() {
        System.out.println("Nhap sdt khach hang: ");
        String phoneNumber = input.nextLine();
        if(customerManager.find(phoneNumber) == null){
            System.out.println("Khach hang khong ton tai!");
        } else {
            System.out.println(customerManager.find(phoneNumber));
        }
        System.out.println("Nhan phim bat ky de tiep tuc !");
        input.nextLine();
        displayMenu();
    }

    private static void findCustomer() {
        System.out.println("Nhap sdt khach hang: ");
        String phoneNumber = input.nextLine();
        if(customerManager.find(phoneNumber) == null){
            System.out.println("Khach hang khong ton tai!");
        } else {
            System.out.println(customerManager.find(phoneNumber).toStringNotOrder());
        }
        System.out.println("Nhan phim bat ky de tiep tuc !");
        input.nextLine();
        displayMenu();
    }

    private static void addNewCustomer() throws IOException {
        System.out.println("Nhap ten: ");
        String name = input.nextLine();
        System.out.println("Nhap dia chi: ");
        String address = input.nextLine();

        ;
        System.out.println("Nhap email: ");
        String email = input.nextLine();
        System.out.println("Nhap sdt: ");
        String phoneNumber = input.nextLine();
        System.out.println("Nhap gioi tinh: ");
        String gender = input.nextLine();
        Customer customer = new Customer(name, address, phoneNumber, email, gender, 0);
        Customer checkCustomer = customerManager.find(phoneNumber);
        if(customer.equals(checkCustomer)){
            System.out.println("Khach hang da ton tai!");
        } else {
            try {
                customerManager.add(customer);
                System.out.println("Bạn vừa thêm mới khách hàng " + customer.getName() + " thành công.");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Nhap phim bat ky de tiep tuc ...");
        input.nextLine();
        displayMenu();
    }


    public static void main(String[] args) {
        try {
            customerManager.loadFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        displayMenu();
    }
}
