package com.vshopping.vshop.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.vshopping.vshop.room.Model.Customer;
import com.vshopping.vshop.room.repository.VshopRepository;

import java.util.List;

public class CustomerViewModel extends AndroidViewModel {

    private VshopRepository mVshopRepository;

    private LiveData<List<Customer>> mAllCustomers;

    public CustomerViewModel(@NonNull Application application){
        super(application);
        mVshopRepository = new VshopRepository(application);
        mAllCustomers = mVshopRepository.getAllCustomers();
    }

    LiveData<List<Customer>> getmAllCustomers(){
        return mAllCustomers;
    }

    public void insert(Customer customer){
        mVshopRepository.insert(customer);
    }

}
