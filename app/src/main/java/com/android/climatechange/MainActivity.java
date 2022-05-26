 package com.android.climatechange;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

 public class MainActivity extends AppCompatActivity {

     BottomNavigationView bottomNavigationView;
     MapFragment homeFragment = new MapFragment();
     ResourceFragment resourceFragment = new ResourceFragment();
     RecycleFragment recycleFragment = new RecycleFragment();


     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = new MapFragment();


        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container,fragment)
                .commit();


         bottomNavigationView = findViewById(R.id.bottom_navigation);
         getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
         bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                 switch (item.getItemId()) {
                     case R.id.home:
                         getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                         return true;

                     case R.id.resource:
                         getSupportFragmentManager().beginTransaction().replace(R.id.container, resourceFragment).commit();
                         return true;

                     case R.id.recycle:
                         getSupportFragmentManager().beginTransaction().replace(R.id.container, recycleFragment).commit();
                         return true;

                 }
                 return false;

             }
         });
     }
    }
