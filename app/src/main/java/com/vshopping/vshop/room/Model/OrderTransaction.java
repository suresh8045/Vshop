package com.vshopping.vshop.room.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "order_transactions")
public class OrderTransaction {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int order_id;
    private String date;
    private String type;
    private String gold_rate;
    private String paid_gold;
    private String paid_gold_money;
    private String paid_makingcharge;
    private String paid_stones;
    private String paid_total;
    private String balance_gold;
    private String balance_gold_money;
    private String balance_makingcharge;
    private String balance_stones;
    private String balance_total;
    private String other_amount;
    private String balance_other_amount;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGold_rate() {
        return gold_rate;
    }

    public void setGold_rate(String gold_rate) {
        this.gold_rate = gold_rate;
    }

    public String getPaid_gold() {
        return paid_gold;
    }

    public void setPaid_gold(String paid_gold) {
        this.paid_gold = paid_gold;
    }

    public String getPaid_gold_money() {
        return paid_gold_money;
    }

    public void setPaid_gold_money(String paid_gold_money) {
        this.paid_gold_money = paid_gold_money;
    }

    public String getPaid_makingcharge() {
        return paid_makingcharge;
    }

    public void setPaid_makingcharge(String paid_makingcharge) {
        this.paid_makingcharge = paid_makingcharge;
    }

    public String getPaid_stones() {
        return paid_stones;
    }

    public void setPaid_stones(String paid_stones) {
        this.paid_stones = paid_stones;
    }

    public String getPaid_total() {
        return paid_total;
    }

    public void setPaid_total(String paid_total) {
        this.paid_total = paid_total;
    }

    public String getBalance_gold() {
        return balance_gold;
    }

    public void setBalance_gold(String balance_gold) {
        this.balance_gold = balance_gold;
    }

    public String getBalance_gold_money() {
        return balance_gold_money;
    }

    public void setBalance_gold_money(String balance_gold_money) {
        this.balance_gold_money = balance_gold_money;
    }

    public String getBalance_makingcharge() {
        return balance_makingcharge;
    }

    public void setBalance_makingcharge(String balance_makingcharge) {
        this.balance_makingcharge = balance_makingcharge;
    }

    public String getBalance_stones() {
        return balance_stones;
    }

    public void setBalance_stones(String balance_stones) {
        this.balance_stones = balance_stones;
    }

    public String getBalance_total() {
        return balance_total;
    }

    public void setBalance_total(String balance_total) {
        this.balance_total = balance_total;
    }

    public String getOther_amount() {
        return other_amount;
    }

    public void setOther_amount(String other_amount) {
        this.other_amount = other_amount;
    }

    public String getBalance_other_amount() {
        return balance_other_amount;
    }

    public void setBalance_other_amount(String balance_other_amount) {
        this.balance_other_amount = balance_other_amount;
    }
}
