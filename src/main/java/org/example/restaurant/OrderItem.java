package org.example.restaurant;


// Necesario para especificar cualquier pedido especial
class OrderItem {
  private MenuItem item;
  private String specialRequest;

  public OrderItem(MenuItem item, String specialRequest) {
    this.item = item;
    this.specialRequest = specialRequest;
  }

  public MenuItem getItem() {
    return item;
  }

  public String getSpecialRequest() {
    return specialRequest;
  }
}