package com.vshopping.vshop.room.cloud.webservice;

import com.vshopping.vshop.room.Model.Customer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CustomerApi {

    @GET("index.php")
    Call<List<Customer>> getCustomers();

}
