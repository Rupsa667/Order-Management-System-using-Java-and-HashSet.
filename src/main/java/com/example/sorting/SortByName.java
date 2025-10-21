package com.example.sorting;

import com.example.model.Item;
import module java.base;

public class SortByName implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return o1.getItemName().compareToIgnoreCase(o2.getItemName());
    }
}
