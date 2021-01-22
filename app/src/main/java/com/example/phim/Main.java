package com.example.phim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.phim.Account.AccountFragment;
import com.example.phim.Home.HomeFragment;
import com.example.phim.Notification.NotificationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main extends AppCompatActivity {
    private ActionBar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = getSupportActionBar();

        //set default tab
        Fragment fragment = new HomeFragment();
        loadFragment(fragment);

        BottomNavigationView navigation = (BottomNavigationView)findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()){
                case R.id.navigation_home:
                    mToolbar.setTitle(R.string.home);
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_notification:
                    mToolbar.setTitle(R.string.notification);
                    fragment = new NotificationFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_account:
                    mToolbar.setTitle(R.string.account);
                    fragment = new AccountFragment();
                    loadFragment(fragment);
                    return true;
            }return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}