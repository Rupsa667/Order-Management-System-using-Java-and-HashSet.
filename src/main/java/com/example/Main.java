package com.example;

import com.example.exception.DuplicateItemException;
import com.example.exception.ItemNotFoundException;
import com.example.model.Item;
import com.example.service.impl.Order;
import com.example.sorting.SortByName;
import com.example.sorting.SortByPrice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        Scanner sc = new Scanner(System.in);
      try {
          while (true) {
              System.out.println("1.add items");
              System.out.println("2.display items");
              System.out.println("3.update items");
              System.out.println("4.remove items");
              System.out.println("5.search items");
              System.out.println("6.sort all items by 1.name 2.price");
              System.out.println("7.exit");

              System.out.println("Enter your choice:");
              int choice = sc.nextInt();
              if (choice == 7) {
                  System.out.println("Exit");
                  break;
              }
              switch (choice) {
                  case 1:
                      System.out.println("Enter item no:");
                      int itemId = sc.nextInt();
                      sc.nextLine();
                      System.out.println("Enter item name:");
                      String itemName = sc.nextLine();
                      System.out.println("Enter price:");
                      double price = sc.nextDouble();
                      order.addItem(new Item(itemId, itemName, price));
                      break;
                  case 2:
                      order.viewItems();
                      break;
                  case 3:
                      System.out.println("Enter item no to update:");
                      itemId = sc.nextInt();
                      sc.nextLine();
                      System.out.println("Enter new name:");
                      String newItemName = sc.nextLine();
                      System.out.println("Enter new price:");
                      double newPrice = sc.nextDouble();
                      order.updateItem(itemId, newItemName, newPrice);
                      break;
                  case 4:
                      System.out.println("Enter item no:");
                      itemId = sc.nextInt();
                      order.deleteItem(itemId);
                      break;
                  case 5:
                      itemName = IO.readln("Enter item name to be searched:");
                          Item foundItem = order.searchItem(itemName);
                          System.out.println("item id is: "+order.searchItem(itemName).getItemId()+" and price is: "+foundItem.getPrice());
                      break;

                  case 6:
                      System.out.println("Enter option");
                      int option = sc.nextInt();
                      if (option == 1) {
                          List<Item> listByName = new ArrayList<>(order.getAllItems());
                          Collections.sort(listByName, new SortByName());
                          listByName.forEach(System.out::println);
                      }
                      else if (option == 2) {
                          List<Item> listByPrice = new ArrayList<>(order.getAllItems());
                      Collections.sort(listByPrice, new SortByPrice());
                      listByPrice.forEach(System.out::println);
              }
                      else
                          System.out.println("Invalid option");
                      break;
              }
          }
      }
      catch (DuplicateItemException |ItemNotFoundException e) {
          System.out.println(e.getMessage());
      }
      catch (Exception e) {
          System.out.println(e.getMessage());
      }
    }
}
