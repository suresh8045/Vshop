package com.vshopping.vshop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.os.Environment;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.vshopping.vshop.backup_restore.BackupAndRestore;
import com.vshopping.vshop.backup_restore.DBHelper;
import com.vshopping.vshop.backup_restore.LocalBackup;
import com.vshopping.vshop.fragments.DashboardFragment;
import com.vshopping.vshop.fragments.OrdersFragment;
import com.vshopping.vshop.room.database.VshopDatabase;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.view.Menu;

import java.io.File;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
        ,DashboardFragment.OnDashBoardFragmentInteractionListener
        , OrdersFragment.OnOrdersFragmentInteractionListener {

    public static final String TAG="MainActivity";

    public static final int REQUEST_CODE_SIGN_IN = 0;
    public static final int REQUEST_CODE_OPENING = 1;
    public static final int REQUEST_CODE_CREATION = 2;
    public static final int REQUEST_CODE_PERMISSIONS = 2;


    FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    Fragment mFragment;
    private MainActivityViewModel mViewModel;
    private LocalBackup localBackup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                 //       .setAction("Action", null).show();
                startCreateOrderActivity();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void startCreateOrderActivity() {
        Intent intent = new Intent(this, CreateOrderActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                Log.i(TAG, "onActivityResult: ok");
               // String result=data.getStringExtra("result");
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Log.i(TAG, "onActivityResult: canceled");
                //Write your code if there's no result
            }
        }
    }

    public void transactFragment(int id){

        if (id == R.id.nav_home) {
            mFragment = new DashboardFragment();
        } else if (id == R.id.nav_orders) {
            mFragment = new OrdersFragment();
        } else if (id == R.id.nav_accounts) {
            //mFragment = new DashboardFragment();
        } else if (id == R.id.nav_tools) {
        //    mFragment = new DashboardFragment();
        } else if (id == R.id.nav_share) {
          //  mFragment = new DashboardFragment();
        } else if (id == R.id.nav_send) {

        }

        if(mFragment!=null) {
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, mFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        final DBHelper db = new DBHelper(getApplicationContext());
        Log.i(TAG, "onOptionsItemSelected: "+id);
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            mViewModel.deleteAllOrders();

            return true;
        }
        if (id == R.id.action_backup) {
            Log.i(TAG, "onOptionsItemSelected: ");
            VshopDatabase vshopDatabase = VshopDatabase.getDatabase(getApplicationContext());
            vshopDatabase.close();
            localBackup = new LocalBackup(this);
            String outFileName = Environment.getExternalStorageDirectory() + File.separator + getResources().getString(R.string.app_name) + File.separator;
            localBackup.performBackup(db, outFileName);
            //BackupAndRestore.exportDB(this);
            return true;
        }
        if (id == R.id.action_restore) {
            VshopDatabase vshopDatabase = VshopDatabase.getDatabase(getApplicationContext());
            vshopDatabase.close();
            localBackup = new LocalBackup(this);
            localBackup.performRestore(db);
            //BackupAndRestore.importDB(this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            transactFragment(id);
        } else if (id == R.id.nav_orders) {
            transactFragment(id);
        } else if (id == R.id.nav_accounts) {
            transactFragment(id);
        } else if (id == R.id.nav_tools) {
            transactFragment(id);
        } else if (id == R.id.nav_share) {
            transactFragment(id);
        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onDashBoardFragmentInteraction(String uri) {

    }

    @Override
    public void onOrdersFragmentInteraction(String uri) {

    }
}
