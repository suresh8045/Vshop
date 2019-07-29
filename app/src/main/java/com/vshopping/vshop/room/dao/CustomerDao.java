package com.vshopping.vshop.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.vshopping.vshop.room.Model.Customer;

import java.util.List;


@Dao
public interface CustomerDao {
    @Insert
    void insert(Customer customer);

    @Delete
    void delete(Customer customer);

    @Update
    void update(Customer customer);

    @Query("SELECT * from customers ORDER BY name ASC")
    LiveData<List<Customer>> getAllCustomers();

    @Query("DELETE from customers")
    void deleteAllCustomers();

}
