package com.mobidroid.sooqyemen.app;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.mobidroid.sooqyemen.R;
import com.mobidroid.sooqyemen.adapter.CustomAdapter;
import com.mobidroid.sooqyemen.fragment.OneFragment;
import com.mobidroid.sooqyemen.fragment.ThreeFragment;
import com.mobidroid.sooqyemen.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class AddAdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ad);

        initToolbar();
        init();
    }

    private void init() {
        ViewPager viewPager = (ViewPager)findViewById(R.id.view_pager_ad);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        fragments.add(new ThreeFragment());

        CustomAdapter adapter = new CustomAdapter(getSupportFragmentManager(), fragments);

        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicator);
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_ad);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_android);
        getSupportActionBar().setTitle(" Sooq Yemen ");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
