package org.example.pagination;

public interface IListManager {
  void addItem(Item item);
  void setPageSize(int size);
  void displayPage(int page);
  void displayCurrentPage();
  void firstPage();
  void lastPage();
  void nextPage();
  void previousPage();
  void goToPage(int page);
}