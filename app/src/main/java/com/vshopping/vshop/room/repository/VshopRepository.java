package com.vshopping.vshop.room.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.vshopping.vshop.room.Model.Customer;
import com.vshopping.vshop.room.Model.Order;
import com.vshopping.vshop.room.Model.OrderTransaction;
import com.vshopping.vshop.room.dao.CustomerDao;
import com.vshopping.vshop.room.dao.OrderDao;
import com.vshopping.vshop.room.dao.OrderTransactionDao;
import com.vshopping.vshop.room.database.VshopDatabase;

import java.util.List;

public class VshopRepository {

    private static VshopRepository instance;
    private CustomerDao mCustomerDao;
    private OrderDao mOrderDao;
    private OrderTransactionDao mOrderTransactionDao;


    private LiveData<List<Customer>> mAllCustomers;
    private LiveData<List<Order>> mAllOrders;
    private LiveData<List<OrderTransaction>> mAllOrderTransactions;


    public static VshopRepository getInstance(Application application){
        if(instance == null){
            instance = new VshopRepository(application);
        }
        return instance;
    }

    public VshopRepository(Application application) {
        VshopDatabase db = VshopDatabase.getDatabase(application);
        mCustomerDao = db.customerDao();
        mOrderDao = db.orderDao();
        mOrderTransactionDao = db.orderTransactionDao();

        mAllOrders = mOrderDao.getAllOrders();
        mAllOrderTransactions = mOrderTransactionDao.getAllOrderTransactions();
        mAllCustomers = mCustomerDao.getAllCustomers();

    }

     
    public LiveData<List<Customer>> getAllCustomers() {
        return mAllCustomers;
    }
    public LiveData<List<Order>> getAllOrders() {
        return mAllOrders;
    }
    public LiveData<List<OrderTransaction>> getAllOrderTransactions() {
        return mAllOrderTransactions;
    }

    public void deleteAllOrders() {
        new DeleteAllOrderAsyncTask(mOrderDao).execute();
    }

    private static class DeleteAllOrderAsyncTask extends AsyncTask<Void, Void, Void> {
        private OrderDao orderDao;

        private DeleteAllOrderAsyncTask(OrderDao orderDao) {
            this.orderDao = orderDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            orderDao.deleteAllOrders();
            return null;
        }
    }

    public void insertOrder (Order order) {
        new InsertOrderAsyncTask(mOrderDao).execute(order);
    }

    private static class InsertOrderAsyncTask extends AsyncTask<Order, Void, Void> {

        private OrderDao mAsyncTaskDao;

        InsertOrderAsyncTask(OrderDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Order... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    public void insert (Customer customer) {
        new InsertAsyncTask(mCustomerDao).execute(customer);
    }

    private static class InsertAsyncTask extends AsyncTask<Customer, Void, Void> {

        private CustomerDao mAsyncTaskDao;

        InsertAsyncTask(CustomerDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Customer... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }




}
