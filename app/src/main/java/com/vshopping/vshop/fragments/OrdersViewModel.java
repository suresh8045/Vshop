package com.vshopping.vshop.fragments;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.vshopping.vshop.room.Model.Order;
import com.vshopping.vshop.room.repository.VshopRepository;

import java.util.List;

public class OrdersViewModel extends AndroidViewModel {

    VshopRepository vshopRepository;

    public OrdersViewModel(@NonNull Application application) {
        super(application);
        vshopRepository = VshopRepository.getInstance(application);

    }

    public LiveData<List<Order>> getOrdersLiveData() {
        return vshopRepository.getAllOrders();
    }
    // TODO: Implement the ViewModel
}
