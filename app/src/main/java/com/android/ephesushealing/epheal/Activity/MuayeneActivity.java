package com.android.ephesushealing.epheal.Activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.ephesushealing.epheal.Activity.Fragment.MuayeneFragment;
import com.android.ephesushealing.epheal.Activity.Fragment.ReceteFragment;
import com.android.ephesushealing.epheal.Activity.Fragment.TanrilarFragment;
import com.android.ephesushealing.epheal.R;

import java.util.ArrayList;
import java.util.List;

public class MuayeneActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs_muayene);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
 changeTabsFont();
        tabLayout.setupWithViewPager(viewPager);
    }
    private void changeTabsFont() {
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Avenir-Heavy.ttf");
        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(font);
                    ((TextView) tabViewChild).setTextSize(30);

                }
            }
        }
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MuayeneFragment(), "Muayene");
        adapter.addFragment(new ReceteFragment(), "Reçete");
        adapter.addFragment(new TanrilarFragment(), "Tanrılar");
        adapter.addFragment(new MuayeneFragment(), "İstemler");
        adapter.addFragment(new MuayeneFragment(), "Öncelikler");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
