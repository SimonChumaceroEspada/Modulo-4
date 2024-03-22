package org.example.restaurant;

import java.util.ArrayList;
import java.util.List;

class Table {
  private int tableNumber;
  private List<Order> orders;
  private String status;

  public Table(int tableNumber) {
    this.tableNumber = tableNumber;
    this.orders = new ArrayList<>();
    status = "Free";
  }

  public void addOrder(Order order) {
    this.orders.add(order);
  }

  public List<Order> getOrders() {
    return orders;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public int getTableNumber() {
    return tableNumber;
  }

  public Order getOrder(int orderNumber) {
    return orders.get(orderNumber);
  }

  public void setOrder(Order order) {
    orders.add(order);
  }
}