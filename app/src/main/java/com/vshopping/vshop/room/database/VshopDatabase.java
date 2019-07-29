package com.vshopping.vshop.room.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.vshopping.vshop.room.Model.Customer;
import com.vshopping.vshop.room.dao.CustomerDao;

@Database(entities = {Customer.class}, version = 1)
public abstract class VshopDatabase extends RoomDatabase {

    public abstract CustomerDao customerDao();
    private static volatile VshopDatabase INSTANCE;

    public static VshopDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (VshopDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            VshopDatabase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

