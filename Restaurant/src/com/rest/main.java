
package com.rest;

import com.rest.CLI.tablecli;
import com.rest.CLI.menuitemcli;
import com.rest.CLI.ordercli;
import com.rest.CLI.paymentcli;

import com.rest.services.tableservice;
import com.rest.services.menuitemservice;
import com.rest.services.orderservice;
import com.rest.services.paymentservice;

import com.rest.models.order;
import com.rest.models.payment;

import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        tableservice tableService = new tableservice();
        menuitemservice menuService = new menuitemservice();
        orderservice orderService = new orderservice();
        paymentservice PaymentService = new paymentservice();

        tablecli tableCLI = new tablecli(tableService);
        menuitemcli menuCLI = new menuitemcli(menuService);

        ordercli orderCLI = new ordercli(
            orderService, menuService
        );

        paymentcli paymentCLI = new paymentcli();

        int choice = -1;

        do {
            System.out.println(
                "\n===== RESTAURANT MANAGEMENT SYSTEM ====="
            );
            System.out.println("1. View All Tables");
            System.out.println("2. View Menu Items");
            System.out.println("3. Place Order");
            System.out.println("4. View All Orders");
            System.out.println("5. Make Payment");
            System.out.println("6. View All Payments");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        tableCLI.start();
                        break;

                    case 2:
                        menuCLI.start();
                        break;

                    case 3:
                        orderCLI.start();
                        break;

                    case 4:
                        List<order> orders =
                            orderService.getAllOrders();

                        System.out.println("\n===== ALL ORDERS =====");

                        if (orders.isEmpty()) {
                            System.out.println("No orders found.");
                        } else {
                            for (order o : orders) {
                                System.out.println(o);
                            }
                        }
                        break;

                    case 5:
                        paymentCLI.start();
                        break;

                    case 6:
                        paymentCLI.viewAllPayments();
                        break;

                    case 0:
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }

        } while (choice != 0);

        scanner.close();
    }
}
