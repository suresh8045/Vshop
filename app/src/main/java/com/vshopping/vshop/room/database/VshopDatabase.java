package com.vshopping.vshop.room.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.vshopping.vshop.BuildConfig;
import com.vshopping.vshop.constants.Constant;
import com.vshopping.vshop.room.Model.Customer;
import com.vshopping.vshop.room.Model.Order;
import com.vshopping.vshop.room.Model.OrderTransaction;
import com.vshopping.vshop.room.Model.User;
import com.vshopping.vshop.room.dao.CustomerDao;
import com.vshopping.vshop.room.dao.OrderDao;
import com.vshopping.vshop.room.dao.OrderTransactionDao;

@Database(entities = {Customer.class, Order.class, User.class, OrderTransaction.class}, version = Constant.DATABASE_VERSION)
public abstract class VshopDatabase extends RoomDatabase {

    public abstract CustomerDao customerDao();
    public abstract OrderDao orderDao();
    public abstract OrderTransactionDao orderTransactionDao();

    private static volatile VshopDatabase INSTANCE;

    public static VshopDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (VshopDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            VshopDatabase.class, Constant.DATABASE_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static String getDatabaseName(){
        return Constant.DATABASE_NAME;
    }




}

