package com.vshopping.vshop.room.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.vshopping.vshop.room.Model.Customer;
import com.vshopping.vshop.room.dao.CustomerDao;
import com.vshopping.vshop.room.database.VshopDatabase;

import java.util.List;

public class VshopRepository {

    private static VshopRepository instance;
    private CustomerDao mCustomerDao;
    private LiveData<List<Customer>> mAllCustomers;


    public static VshopRepository getInstance(Application application){
        if(instance == null){
            instance = new VshopRepository(application);
        }
        return instance;
    }

    public VshopRepository(Application application) {
        VshopDatabase db = VshopDatabase.getDatabase(application);
        mCustomerDao = db.customerDao();
        // mAllCustomers = mCustomerDao.getAllCustomers();
    }

     
    public LiveData<List<Customer>> getAllCustomers() {
        return mAllCustomers;
    }

    public void insert (Customer customer) {
        new insertAsyncTask(mCustomerDao).execute(customer);
    }

    private static class insertAsyncTask extends AsyncTask<Customer, Void, Void> {

        private CustomerDao mAsyncTaskDao;

        insertAsyncTask(CustomerDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Customer... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
