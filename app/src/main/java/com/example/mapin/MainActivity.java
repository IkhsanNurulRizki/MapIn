package com.example.mapin;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

/**
 * 10119097
 * Ikhsan Nurul Rizki
 * IF-3 */
public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;

    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selecttedFragment = null;

                switch (menuItem.getItemId()){
                    case R.id.home:
                        selecttedFragment = new HomeFragment();
                        break;
                    case R.id.profil:
                        selecttedFragment = new profilFragment();
                        break;
                    case R.id.about:
                        selecttedFragment = new AboutFragment();
                        break;

                }


                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selecttedFragment).commit();

                return true;
            }
        });

    }

}
