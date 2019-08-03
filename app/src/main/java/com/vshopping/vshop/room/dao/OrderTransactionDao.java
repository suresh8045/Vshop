package com.vshopping.vshop.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.vshopping.vshop.room.Model.Order;
import com.vshopping.vshop.room.Model.OrderTransaction;

import java.util.List;


@Dao
public interface OrderTransactionDao {
    @Insert
    void insert(OrderTransaction orderTransaction);

    @Delete
    void delete(OrderTransaction orderTransaction);

    @Update
    void update(OrderTransaction orderTransaction);

    @Query("SELECT * from order_transactions ORDER BY order_id ASC")
    LiveData<List<OrderTransaction>> getAllOrderTransactions();

    @Query("DELETE from order_transactions")
    void deleteAllOrderTransactions();

}
