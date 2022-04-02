package com.fsoft.hibernatedemo;

import com.fsoft.hibernatedemo.dao.CustomerDAO;
import com.fsoft.hibernatedemo.model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.util.Scanner;

@SpringBootApplication
public class HibernateDemoApplication {
    public static void main(String[] args) throws ParseException {
        SpringApplication.run(HibernateDemoApplication.class, args);
        CustomerDAO pDAO = new CustomerDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("-------------------------------------------------------");
            System.out.println("1. Show All");
            System.out.println("2. Delete");
            System.out.println("3. Update Name");
            System.out.println("4. Add");
            System.out.println("5. Find");

            System.out.print("Press number to select: ");
            int n = Integer.parseInt(sc.nextLine());
            switch (n) {
                case 1:
                    pDAO.showAll();
                    break;
                case 2:
                    System.out.print("Enter id of Customer need to delete: ");
                    int id = Integer.parseInt(sc.nextLine());
                    pDAO.delete(new Customer(id));
                    System.out.println("Deleted!");
                    break;
                case 3:
                    System.out.print("Enter id of Customer need to update name:");
                    int id2 = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter new name: ");
                    String name = sc.nextLine();
                    pDAO.updateName(id2, name);
                    System.out.println("Updated!");
                    break;
                case 4:
                    System.out.println("Fill information of new Customer");
                    System.out.print("Enter id: ");
                    int idCustomer = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter name: ");
                    String name2 = sc.nextLine();
                    System.out.print("Enter address: ");
                    String address = sc.nextLine();
                    Customer customer = new Customer(idCustomer, name2, address);
                    pDAO.insert(customer);
                    System.out.println("Inserted!");
                    break;
                case 5:
                    System.out.print("Enter name of Customer to find: ");
                    String name3 = sc.nextLine();
                    pDAO.searchByName(name3);
                    break;

            }
        }
    }
}
