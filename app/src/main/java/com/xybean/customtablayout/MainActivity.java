package com.xybean.customtablayout;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.xybean.customtablayout.tablayout.CustomTabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<MyFragment> fragmentList = new ArrayList<MyFragment>() {{
        add(MyFragment.newInstance(R.color.md_blue_500, "Blue"));
        add(MyFragment.newInstance(R.color.md_red_700, "Red"));
        add(MyFragment.newInstance(R.color.md_pink_500, "Pink"));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomTabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager = findViewById(R.id.view_pager);

        MyAdapter adapter = new MyAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager, true);
        viewPager.setCurrentItem(0);
    }
}
