package com.vshopping.vshop.fragments;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vshopping.vshop.MainActivity;
import com.vshopping.vshop.R;
import com.vshopping.vshop.adapters.OrdersAdapter;
import com.vshopping.vshop.adapters.PendingOrdersAdapter;
import com.vshopping.vshop.room.Model.Order;
import com.vshopping.vshop.room.Model.PendingOrder;

import java.util.ArrayList;
import java.util.List;

public class OrdersFragment extends Fragment {

    private OrdersViewModel mViewModel;
    private MainActivity mActivity;
    private OnOrdersFragmentInteractionListener mListener;
    private RecyclerView ordersRecyclerView;
    OrdersAdapter ordersAdapter;

    List<Order> ordersList=new ArrayList<>();

    public static OrdersFragment newInstance() {
        return new OrdersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.orders_fragment, container, false);
        ordersRecyclerView = view.findViewById(R.id.orders_recyclerview);

        ordersRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity, RecyclerView.VERTICAL,false));
        ordersRecyclerView.setHasFixedSize(true);

        ordersAdapter = new OrdersAdapter();
        ordersRecyclerView.setAdapter(ordersAdapter);

      /*  for(int i=0; i<3; i++){
            PendingOrder pendingOrder = new PendingOrder();
            pendingOrder.setTitle("Ring "+i);
            pendingOrder.setDescription("Ring desc "+i);
            pendingOrder.setTitle("priority "+i);
            ordersList.add(pendingOrder);
        }*/

        ordersAdapter.setOrders(ordersList);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(OrdersViewModel.class);

        mViewModel.getOrdersLiveData().observe(getViewLifecycleOwner(), new Observer<List<Order>>() {
            @Override
            public void onChanged(List<Order> orders) {
                if(orders!=null){
                    if(ordersAdapter!=null){
                        ordersAdapter.setOrders(orders);
                    }
                }
            }
        });
        // TODO: Use the ViewModel
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof MainActivity){
            mActivity = (MainActivity)context;
        }
        if (context instanceof OnOrdersFragmentInteractionListener) {
            mListener = (OnOrdersFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnOrdersFragmentInteractionListener {
        // TODO: Update argument type and name
        void onOrdersFragmentInteraction(String uri);
    }

}
