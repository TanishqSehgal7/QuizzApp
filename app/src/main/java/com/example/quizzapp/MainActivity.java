package com.example.quizzapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ChipNavigationBar navView;
    Fragment categoryFragment = new  CategoryFragment();
    Fragment scoresFragment = new ScoresFragment();
    Fragment settingsFragment = new SettingsFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navView = findViewById(R.id.bottom_nav);

        loadFragments(categoryFragment);
        navView.setItemSelected(R.id.Categories,true);

        navView.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                switch (id) {
                    case R.id.Categories:
                        loadFragments(categoryFragment);
                        break;

                    case R.id.my_scores:
                        loadFragments(scoresFragment);
                        break;

                    case R.id.settings:
                        loadFragments(settingsFragment);
                        break;

                    default:
                        loadFragments(categoryFragment);
                }
            }
        });


    }

    private void loadFragments(Fragment fragment){
        if (fragment!=null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frag_container,fragment)
                    .addToBackStack(fragment.getClass().getName())
                    .commit();
        }
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().findFragmentById(R.id.frag_container) instanceof CategoryFragment) {
            finish();
        }

        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            navView.setItemSelected(R.id.Categories, true);
        } else {
            super.onBackPressed();
        }
    }

}