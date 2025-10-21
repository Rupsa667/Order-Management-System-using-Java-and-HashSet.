package com.example.service;

import com.example.exception.DuplicateItemException;
import com.example.exception.ItemNotFoundException;
import com.example.model.Item;

import java.util.Set;

public interface OrderOperations {
    void addItem(Item item) throws DuplicateItemException;
    void viewItems();
    void updateItem(int itemId, String newName, double newPrice) throws ItemNotFoundException;
    void deleteItem(int itemId) throws ItemNotFoundException;
    Item searchItem(String name) throws ItemNotFoundException;
    Set<Item> getAllItems();
}
