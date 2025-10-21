package com.example.service.impl;

import com.example.exception.DuplicateItemException;
import com.example.exception.ItemNotFoundException;
import com.example.model.Item;
import com.example.service.OrderOperations;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Order implements OrderOperations {
    Set<Item> items=new LinkedHashSet<>();
    @Override
    public void addItem(Item item)throws DuplicateItemException {
        for (Item i1 : items) {
            if (i1.getItemId() == item.getItemId())
                throw new DuplicateItemException("Item already exists");
        }
        items.add(item);
        System.out.println("Item added successfully");
    }
    @Override
    public void viewItems() {
        if(items.size()==0){
            System.out.println("There are no items in this order");
        }
        for (Item item : items) {
            System.out.println(item);
        }
    }

    @Override
    public void updateItem(int itemId, String newName, double newPrice)throws ItemNotFoundException {
        Item found=null;
        for (Item item : items) {
            if (item.getItemId() == itemId) {
                found=item;
                break;
            }
        }
        if(found==null){
            throw new ItemNotFoundException("Item not found");
        }
        found.setItemName(newName);
        found.setPrice(newPrice);
        System.out.println("Item updated successfully");

    }

    @Override
    public void deleteItem(int itemId) throws ItemNotFoundException{
        Item toRemove=null;
        for (Item item : items) {
            if (item.getItemId() == itemId) {
                toRemove=item;
                break;
            }
        }
        if(toRemove==null) {
            throw new ItemNotFoundException("Item not found");
        }
        items.remove(toRemove);
        System.out.println("Item deleted successfully");
    }

@Override
public Item searchItem(String name) throws ItemNotFoundException {

    for (Item item : items) {
        if (item.getItemName().equalsIgnoreCase(name)) {
            return item;
        }
    }
    throw new ItemNotFoundException("Item not found");
}

    @Override
    public Set<Item> getAllItems() {
        return items;
    }
}
