package com.vshopping.vshop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.vshopping.vshop.room.Model.Order;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CreateOrderActivity extends AppCompatActivity {

    Button next_btn;
    private EditText customer_name, phone_number, address, date;
    private CreateOrderActivityViewModel mViewModel;
    private EditText title;
    private EditText weight;
    private EditText makingCharge;
    private TextView dateView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        mViewModel = ViewModelProviders.of(this).get(CreateOrderActivityViewModel.class);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        dateView = findViewById(R.id.date_view);
        customer_name = findViewById(R.id.customer_name);
        phone_number = findViewById(R.id.phone_number);
        address = findViewById(R.id.address);
        title = findViewById(R.id.order_title);
        final RadioButton radioButtonGold = findViewById(R.id.radioGold);
        final RadioButton radioButtonSilver = findViewById(R.id.radioSilver);
        weight = findViewById(R.id.weight);
        makingCharge = findViewById(R.id.making_charge);
        makingCharge = findViewById(R.id.making_charge);

        next_btn = findViewById(R.id.create_order_btn);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Order order = new Order();
                order.setTitle(title.getText().toString());
                //order.set(customer_name.getText().toString());
                order.setWeight(weight.getText().toString());
                order.setDate(dateView.getText().toString());
                if(radioButtonGold.isChecked()){
                    order.setMaterial_type(0);
                }else if (radioButtonSilver.isChecked()){
                    order.setMaterial_type(1);
                }

                mViewModel.saveOrder(order);
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", customer_name.getText());
                setResult(Activity.RESULT_OK,returnIntent);
                finish();

            }
        });

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY");
        Date date = new Date(System.currentTimeMillis());
        dateView.setText(simpleDateFormat.format(date));


        mViewModel.getAllOrders().observe(this, new Observer<List<Order>>() {
            @Override
            public void onChanged(@Nullable List<Order> orders) {



            }
        });

    }

}
