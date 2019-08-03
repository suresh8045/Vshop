package com.vshopping.vshop;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.vshopping.vshop.room.Model.Order;
import com.vshopping.vshop.room.repository.VshopRepository;

public class CreateOrderActivityViewModel extends AndroidViewModel {
    VshopRepository vshopRepository;

    public CreateOrderActivityViewModel(@NonNull Application application) {
        super(application);
        vshopRepository = VshopRepository.getInstance(application);
    }


    public void saveOrder(Order order){
        vshopRepository.insertOrder(order);
    }

    public LiveData getAllOrders() {
        return vshopRepository.getAllOrders();
    }
}
