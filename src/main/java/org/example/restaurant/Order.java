package org.example.restaurant;

import java.util.ArrayList;
import java.util.List;

class Order {
  private List<OrderItem> items;
  private String status;

  public Order() {
    items = new ArrayList<>();
    status = "Pending";
  }

  public void addOrderItem(OrderItem item) {
    items.add(item);
  }

  public List<OrderItem> getItems() {
    return items;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}