package org.example.restaurant;

import java.util.Scanner;

public class MainRestaurant {
  public static void main(String[] args) {
    RestaurantOrderManagementSystem system = new RestaurantOrderManagementSystem();

    // Agregar elementos al menú
    system.addMenuItem("Pizza", 15);
    system.addMenuItem("Burger", 12);
    system.addMenuItem("Salad", 6.50);
    // Bebidas
    system.addMenuItem("Cola", 3);
    system.addMenuItem("Water", 1);
    system.addMenuItem("Wine", 12);
    // Postres
    system.addMenuItem("Ice Cream", 4);
    system.addMenuItem("Cake", 5);
    system.addMenuItem("Cinnamon Roll", 4.50);

    // Crear algunas mesas
    system.createTable(1);
    system.createTable(2);

    // Interacción con el usuario
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;
    while (!exit) {
      System.out.println("\nRestaurant Order Management System");
      System.out.println("1. Display Menu");
      System.out.println("2. Take Order");
      System.out.println("3. Display Table Status");
      System.out.println("4. Generate Invoice");
      System.out.println("5. Create Menu Item");
      System.out.println("6. Update Menu Item");
      System.out.println("7. Delete Menu Item");
      System.out.println("8. Display Order Status");
      System.out.println("9. Mark Order as Completed");
      System.out.println("10. Exit");
      System.out.println("Enter your choice:");

      int choice = scanner.nextInt();
      switch (choice) {
        case 1:
          system.displayMenu();
          break;
        case 2:
          System.out.println("Enter table number:");
          int tableNumber = scanner.nextInt();
          system.takeOrder(tableNumber);
          break;
        case 3:
          system.displayTableStatus();
          break;
        case 4:
          System.out.println("Enter table number:");
          int tableNum = scanner.nextInt();
          system.generateInvoice(tableNum);
          break;
        case 5:
          System.out.println("Enter item name:");
          String itemName = scanner.next();
          System.out.println("Enter price:");
          double itemPrice = scanner.nextDouble();
          system.createMenuItem(itemName, itemPrice);
          break;
        case 6:
          System.out.println("Enter item name:");
          String nameUpdated = scanner.next();
          System.out.println("Enter new price:");
          double priceUpdated = scanner.nextDouble();
          system.updateMenuItem(nameUpdated, priceUpdated);
          break;
        case 7:
          System.out.println("Enter item name:");
          itemName = scanner.next();
          system.deleteMenuItem(itemName);
          break;
        case 8:
          System.out.println("Enter table number:");
          tableNumber = scanner.nextInt();
          system.displayOrderStatus(tableNumber);
          break;
        case 9:
          System.out.println("Enter table number:");
          int tableCompletedNumber = scanner.nextInt();
          System.out.println("Enter order number:");
          int orderNum = scanner.nextInt();
          system.markOrderAsCompleted(tableCompletedNumber, orderNum);
          break;
        case 10:
          exit = true;
          break;
        default:
          System.out.println("Invalid choice");
          break;
      }
    }
    scanner.close();
  }
}