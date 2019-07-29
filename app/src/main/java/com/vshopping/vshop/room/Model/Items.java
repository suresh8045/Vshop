package com.vshopping.vshop.room.Model;

import androidx.room.Entity;

import java.util.List;

@Entity
public class Items {
    public String category;
    public List<Item> items;
}
