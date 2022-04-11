package com.example.stock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;


    private void run_fragment(Fragment frag)
    {
        FragmentManager manager =getSupportFragmentManager();
        FragmentTransaction trans=manager.beginTransaction();
        trans.replace(R.id.view_pager,frag);
        trans.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.view_pager);

        tabLayout.setupWithViewPager(viewPager);

        Fragment_adapter adapter = new Fragment_adapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapter.Add_fragment(new stock(),"stock");
        adapter.Add_fragment(new news(""),"TOP");
        adapter.Add_fragment(new news("world"),"World");
        adapter.Add_fragment(new news("technology"),"Tech");
        adapter.Add_fragment(new news("sports"),"Sports");
        adapter.Add_fragment(new news("politics"),"Politics");
        adapter.Add_fragment(new news("business"),"Business");
        adapter.Add_fragment(new news("entertainment+movies"),"Entertainment");

        viewPager.setAdapter(adapter);


    }
}

