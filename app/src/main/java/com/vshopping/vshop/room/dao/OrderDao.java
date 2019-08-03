package com.vshopping.vshop.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.vshopping.vshop.room.Model.Order;

import java.util.List;


@Dao
public interface OrderDao {
    @Insert
    void insert(Order order);

    @Delete
    void delete(Order order);

    @Update
    void update(Order order);

    @Query("SELECT * from orders ORDER BY order_id ASC")
    LiveData<List<Order>> getAllOrders();

    @Query("DELETE from orders")
    void deleteAllOrders();

}
