package com.example.sorting;

import com.example.model.Item;

import java.util.Comparator;

public class SortByPrice implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
