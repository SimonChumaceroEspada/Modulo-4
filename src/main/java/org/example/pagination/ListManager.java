package org.example.pagination;

import java.util.ArrayList;
import java.util.List;

public class ListManager implements IListManager {
  private static final int DEFAULT_PAGE_SIZE = 3;
  private final List<Item> items;
  private int pageSize;
  private int currentPage;

  public ListManager() {
    items = new ArrayList<>();
    pageSize = DEFAULT_PAGE_SIZE;
    currentPage = 0;
  }

  public void addItem(Item item) {
    items.add(item);
  }

  public void setPageSize(int size) {
    pageSize = size;
  }

  public void displayPage(int page) {
    int startIdx = page * pageSize;
    int endIdx = Math.min(startIdx + pageSize, items.size());

    for (int i = startIdx; i < endIdx; i++) {
      System.out.println(items.get(i).getName());
    }
  }

  public void displayCurrentPage() {
    displayPage(currentPage);
  }

  public void firstPage() {
    currentPage = 0;
    displayCurrentPage();
  }

  public void lastPage() {
    currentPage = items.size() / pageSize;
    displayCurrentPage();
  }

  public void nextPage() {
    if (currentPage < items.size() / pageSize) {
      currentPage++;
      displayCurrentPage();
    } else {
      System.out.println("Already on the last page.");
    }
  }

  public void previousPage() {
    if (currentPage > 0) {
      currentPage--;
      displayCurrentPage();
    } else {
      System.out.println("Already on the first page.");
    }
  }

  public void goToPage(int page) {
    if (page >= 0 && page <= items.size() / pageSize) {
      currentPage = page;
      displayCurrentPage();
    } else {
      System.out.println("Invalid page number.");
    }
  }
}