package org.example.pagination;
import java.util.Scanner;

public class MainPagination {
  public static void main(String[] args) {
    IListManager listManager = new ListManager();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("Commands: add, setPageSize, first, last, next, prev, goto <page_number>, exit");
      String command = scanner.nextLine();
      handleCommand(listManager, scanner, command);
    }

  }

  private static void handleCommand(IListManager listManager, Scanner scanner, String command) {
    if (command.equals("add")) {
      handleAddCommand(listManager, scanner);
    } else if (command.equals("setPageSize")) {
      handleSetPageSizeCommand(listManager, scanner);
    } else if (command.equals("first")) {
      listManager.firstPage();
    } else if (command.equals("last")) {
      listManager.lastPage();
    } else if (command.equals("next")) {
      listManager.nextPage();
    } else if (command.equals("prev")) {
      listManager.previousPage();
    } else if (command.startsWith("goto")) {
      handleGotoCommand(listManager, command);
    } else if (command.equals("exit")) {
      System.out.println("Exiting program...");
    } else {
      System.out.println("Invalid command.");
    }
  }

  private static void handleAddCommand(IListManager listManager, Scanner scanner) {
    System.out.print("Enter item: ");
    String itemName = scanner.nextLine();
    Item item = new Item(itemName);
    listManager.addItem(item);
  }

  private static void handleSetPageSizeCommand(IListManager listManager, Scanner scanner) {
    System.out.print("Enter page size: ");
    int size = scanner.nextInt();
    scanner.nextLine();
    listManager.setPageSize(size);
  }

  private static void handleGotoCommand(IListManager listManager, String command) {
    int page = Integer.parseInt(command.split(" ")[1]);
    listManager.goToPage(page);
  }
}