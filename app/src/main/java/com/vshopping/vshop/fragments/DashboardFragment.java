package com.vshopping.vshop.fragments;

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
import com.vshopping.vshop.adapters.PendingOrdersAdapter;
import com.vshopping.vshop.room.Model.PendingOrder;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel mViewModel;
    RecyclerView pendingOrdersRecyclerview;
    private MainActivity mActivity;
    private OnDashBoardFragmentInteractionListener mListener;
    List<PendingOrder> pendingOrderList=new ArrayList<>();

    public static DashboardFragment newInstance() {
        return new DashboardFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dash_board_fragment, container, false);
        pendingOrdersRecyclerview = view.findViewById(R.id.pending_orders_recyclerview);
        pendingOrdersRecyclerview.setLayoutManager(new LinearLayoutManager(mActivity, RecyclerView.HORIZONTAL,false));
        pendingOrdersRecyclerview.setHasFixedSize(true);

        final PendingOrdersAdapter pendingOrdersAdapter = new PendingOrdersAdapter();
        pendingOrdersRecyclerview.setAdapter(pendingOrdersAdapter);

        for(int i=0; i<3; i++){
            PendingOrder pendingOrder = new PendingOrder();
            pendingOrder.setTitle("Ring "+i);
            pendingOrder.setDescription("Ring desc "+i);
            pendingOrder.setTitle("priority "+i);
            pendingOrderList.add(pendingOrder);
        }

        pendingOrdersAdapter.setPendingOrders(pendingOrderList);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof MainActivity){
            mActivity = (MainActivity)context;
        }
        if (context instanceof OnDashBoardFragmentInteractionListener) {
            mListener = (OnDashBoardFragmentInteractionListener) context;
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

    public interface OnDashBoardFragmentInteractionListener {
        // TODO: Update argument type and name
        void OnDashBoardFragmentInteraction(String uri);
    }
}
