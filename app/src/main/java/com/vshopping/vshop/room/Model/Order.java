package com.vshopping.vshop.room.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "orders")
public class Order {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int order_id;
    private String date;
    private String title;
    private int material_type;
    private int making_charge;
    private String gold_rate;
    private String silver_rate;
    private String weight;
    private String wastage;
    private String stones_cost;
    private String other_cost;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMaterial_type() {
        return material_type;
    }

    public void setMaterial_type(int material_type) {
        this.material_type = material_type;
    }

    public int getMaking_charge() {
        return making_charge;
    }

    public void setMaking_charge(int making_charge) {
        this.making_charge = making_charge;
    }

    public String getGold_rate() {
        return gold_rate;
    }

    public void setGold_rate(String gold_rate) {
        this.gold_rate = gold_rate;
    }

    public String getSilver_rate() {
        return silver_rate;
    }

    public void setSilver_rate(String silver_rate) {
        this.silver_rate = silver_rate;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWastage() {
        return wastage;
    }

    public void setWastage(String wastage) {
        this.wastage = wastage;
    }

    public String getStones_cost() {
        return stones_cost;
    }

    public void setStones_cost(String stones_cost) {
        this.stones_cost = stones_cost;
    }

    public String getOther_cost() {
        return other_cost;
    }

    public void setOther_cost(String other_cost) {
        this.other_cost = other_cost;
    }

}
