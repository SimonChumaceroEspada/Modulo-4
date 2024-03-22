package org.example.restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


// Clase principal del programa
public class RestaurantOrderManagementSystem {
  private Map<String, MenuItem> menu;
  private List<Table> tables;
  private Scanner scanner;

  public RestaurantOrderManagementSystem() {
    menu = new HashMap<>();
    tables = new ArrayList<>();
    scanner = new Scanner(System.in);
  }

  public void addMenuItem(String itemName, double itemPrice) {
    menu.put(itemName, new MenuItem(itemName, itemPrice));
  }

  public void createTable(int tableNumber) {
    tables.add(new Table(tableNumber));
  }

  public void displayMenu() {
    System.out.println("Menu:");
    for (MenuItem item : menu.values()) {
      System.out.println(item.getName() + " " + item.getPrice() + " Bs");
    }
  }

  public MenuItem getMenuItem(String itemName) {
    return menu.get(itemName);
  }


  public Table getTable(int tableNumber) {
    for (Table table : tables) {
      if (table.getTableNumber() == tableNumber) {
        return table;
      }
    }
    return null;
  }

  public void takeOrder(int tableNumber) {
    Table table = getTable(tableNumber);
    if (table != null) {
      System.out.println("Enter item name:");
      String itemName = scanner.nextLine();
      MenuItem menuItem = getMenuItem(itemName);
      if (menuItem != null) {
        System.out.println("Enter any special requests (or 'none' if there are no special requests):");
        String specialRequest = scanner.nextLine();
        OrderItem orderItem = new OrderItem(menuItem, specialRequest);
        Order order = new Order();
        order.addOrderItem(orderItem);
        table.addOrder(order);
        if (table.getStatus().equals("Vacant")) {
          table.setStatus("Occupied");
        }
        System.out.println("Order taken for Table " + tableNumber);
      } else {
        System.out.println("Item does not exist in the menu");
      }
    } else {
      System.out.println("Table doesnt exist");
    }
  }

  public void displayTableStatus() {
    System.out.println("Table Status:");
    for (Table table : tables) {
      System.out.println("Table " + table.getTableNumber() + ": " + table.getStatus());
    }
  }


  public void generateInvoice(int tableNumber) {
    Table table = getTable(tableNumber);
    if (table != null && table.getStatus().equals("Occupied")) {
      List<Order> orders = table.getOrders();
      if (!orders.isEmpty()) {
        System.out.println("Invoices for Table " + tableNumber + ":");
        double grandTotal = 0;
        for (Order order : orders) {
          for (OrderItem orderItem : order.getItems()) {
            MenuItem item = orderItem.getItem();
            String specialRequest = orderItem.getSpecialRequest();
            System.out.print(item.getName() + " - Bs" + item.getPrice());
            if (specialRequest != null && !specialRequest.isEmpty()) {
              System.out.print(" (" + specialRequest + ")");
            }
            System.out.println();
            grandTotal += item.getPrice();
          }
          System.out.println("-----");
        }
        System.out.println("Total: Bs" + grandTotal);
      } else {
        System.out.println("No orders found for this table.");
      }
    } else {
      System.out.println("Table is not occupied or doesn't exist.");
    }
  }

  public void updateMenuItem(String itemName, double itemPrice) {
    if (menu.containsKey(itemName)) {
      menu.get(itemName).setPrice(itemPrice);
      System.out.println("Updated the price of " + itemName + " to Bs" + itemPrice);
    } else {
      addMenuItem(itemName, itemPrice);
      System.out.println("Added new item " + itemName + " with price Bs" + itemPrice);
    }
  }

  public void deleteMenuItem(String itemName) {
    if (menu.containsKey(itemName)) {
      menu.remove(itemName);
      System.out.println("Deleted " + itemName + " from the menu.");
    } else {
      System.out.println("Item not found in the menu.");
    }
  }

  public void createMenuItem(String itemName, double itemPrice) {
    menu.put(itemName, new MenuItem(itemName, itemPrice));
  }

  public void markOrderAsCompleted(int tableNumber, int orderNumber) {
    Table table = getTable(tableNumber);
    if (table != null) {
      Order order = table.getOrder(orderNumber);
      if (order != null) {
        order.setStatus("Completed");
        System.out.println("Order " + orderNumber + " for Table " + tableNumber + " marked as completed");
      } else {
        System.out.println("Order not found");
      }
    } else {
      System.out.println("Table doesnt exist");
    }
  }

  public void displayOrderStatus(int tableNumber) {
    Table table = getTable(tableNumber);
    if (table != null) {
      List<Order> orders = table.getOrders();
      if (!orders.isEmpty()) {
        System.out.println("Order status for Table " + tableNumber + ":");
        int orderNumber = 1;
        for (Order order : orders) {
          for (OrderItem orderItem : order.getItems()) {
            MenuItem item = orderItem.getItem();
            String specialRequest = orderItem.getSpecialRequest();
            System.out.println("Number of Order: " + orderNumber + ", Item: " + item.getName() + ", Special Request: " + specialRequest + ", Status: " + order.getStatus());
          }
          orderNumber++;
        }
      } else {
        System.out.println("No orders found for this table");
      }
    } else {
      System.out.println("Table doesnt exist");
    }
  }

}