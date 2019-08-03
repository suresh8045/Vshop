package com.vshopping.vshop.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vshopping.vshop.R;
import com.vshopping.vshop.room.Model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.OrderHolder> {

    private List<Order> orders = new ArrayList<>();

    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_item, parent, false);
        return new OrderHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHolder holder, int position) {
        Order order = orders.get(position);
        holder.textViewTitle.setText(order.getTitle());
        //holder.textViewDescription.setText(order.getWeight());
        holder.dateView.setText(order.getDate());
        holder.textViewWeight.setText(order.getWeight());
        if(order.getMaterial_type()==0) {
            holder.weight_icon.setImageResource(R.drawable.ic_weight_gold);
        }else {
            holder.weight_icon.setImageResource(R.drawable.ic_weight_silver);
        }
//        holder.textViewPriority.setText(order.getMaterial_type());
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class OrderHolder extends RecyclerView.ViewHolder {
        private final ImageView weight_icon;
        private TextView textViewWeight;
        private TextView dateView;
        private TextView textViewTitle;
        private TextView textViewDescription;
        private TextView textViewPriority;

        public OrderHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.title);
            textViewWeight = itemView.findViewById(R.id.weight);
            dateView = itemView.findViewById(R.id.date);
            textViewDescription = itemView.findViewById(R.id.description);
            textViewPriority = itemView.findViewById(R.id.priority);
            weight_icon = itemView.findViewById(R.id.weight_ic);
        }
    }

}
