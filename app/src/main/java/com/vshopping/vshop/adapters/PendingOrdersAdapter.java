package com.vshopping.vshop.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vshopping.vshop.R;
import com.vshopping.vshop.room.Model.PendingOrder;

import java.util.ArrayList;
import java.util.List;

public class PendingOrdersAdapter extends RecyclerView.Adapter<PendingOrdersAdapter.PendingOrderHolder> {

    private List<PendingOrder> pendingOrders = new ArrayList<>();

    @NonNull
    @Override
    public PendingOrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pending_order_item, parent, false);
        return new PendingOrderHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PendingOrderHolder holder, int position) {
        PendingOrder currentNote = pendingOrders.get(position);
        holder.textViewTitle.setText(currentNote.getTitle());
        holder.textViewDescription.setText(currentNote.getDescription());
        holder.textViewPriority.setText(String.valueOf(currentNote.getPriority()));
    }

    public void setPendingOrders(List<PendingOrder> pendingOrders) {
        this.pendingOrders = pendingOrders;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return pendingOrders.size();
    }

    public class PendingOrderHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewDescription;
        private TextView textViewPriority;

        public PendingOrderHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.title);
            textViewDescription = itemView.findViewById(R.id.description);
            textViewPriority = itemView.findViewById(R.id.priority);
        }
    }

}
