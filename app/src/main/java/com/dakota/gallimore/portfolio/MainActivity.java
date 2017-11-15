package com.dakota.gallimore.portfolio;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dakota.gallimore.portfolio.Fragments.AboutMeFragment;
import com.dakota.gallimore.portfolio.Fragments.EducationFragment;
import com.dakota.gallimore.portfolio.Fragments.PortfolioFragment;
import com.dakota.gallimore.portfolio.Fragments.TestimonyFragment;

public class MainActivity extends AppCompatActivity {

    private static final int ABOUT_ME_FRAGMENT = 0;
    private static final int EDUCATION_FRAGMENT = 1;
    private static final int TESTIMONY_FRAGMENT = 2;
    private static final int PORTFOLIO_FRAGMENT = 3;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setType("message/rfc822");
                intent.setData(Uri.parse("mailto: gallimoredakota@gmail.com"));
                //intent.putExtra(Intent.EXTRA_EMAIL, "gallimoredakota@gmail.com");
                PackageManager packageManager = getPackageManager();
                if (packageManager.queryIntentActivities(intent, 0).size() != 0) {
                    startActivity(intent);
                } else {
                    Snackbar.make(v, "No email client detected, please install one.", Snackbar.LENGTH_SHORT).show();
                }

            }
        });
    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {
                case ABOUT_ME_FRAGMENT:
                    return AboutMeFragment.newInstance();
                case EDUCATION_FRAGMENT:
                    return EducationFragment.newInstance();
                case TESTIMONY_FRAGMENT:
                    return TestimonyFragment.newInstance();
                case PORTFOLIO_FRAGMENT:
                    return PortfolioFragment.newInstance();
                default:
                    return AboutMeFragment.newInstance();
            }

        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case ABOUT_ME_FRAGMENT:
                    return "ABOUT ME";
                case EDUCATION_FRAGMENT:
                    return "EDUCATION";
                case TESTIMONY_FRAGMENT:
                    return "REFERRALS";
                case PORTFOLIO_FRAGMENT:
                    return "PORTFOLIO";
                default:
                    return "";
            }
        }
    }
}
