package com.vshopping.vshop.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.vshopping.vshop.room.Model.User;

@Dao
public interface UserDao {

    @Insert
    void save(User user);

    @Delete
    void delete(User user);

    @Update
    void update(User user);

    @Query("DELETE from users")
    void deleteAllUsers();
}
