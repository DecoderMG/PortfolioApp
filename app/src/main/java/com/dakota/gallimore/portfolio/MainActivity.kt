package com.dakota.gallimore.portfolio

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View

import com.dakota.gallimore.portfolio.Fragments.AboutMeFragment
import com.dakota.gallimore.portfolio.Fragments.EducationFragment
import com.dakota.gallimore.portfolio.Fragments.PortfolioFragment
import com.dakota.gallimore.portfolio.Fragments.TestimonyFragment

class MainActivity : AppCompatActivity() {
    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * [FragmentPagerAdapter] derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].
     */
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    /**
     * The [ViewPager] that will host the section contents.
     */
    private var mViewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container)
        mViewPager!!.adapter = mSectionsPagerAdapter

        val tabLayout = findViewById<TabLayout>(R.id.tabs)
        tabLayout.setupWithViewPager(mViewPager)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { v ->
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.type = "message/rfc822"
            intent.data = Uri.parse("mailto: gallimoredakota@gmail.com")
            //intent.putExtra(Intent.EXTRA_EMAIL, "gallimoredakota@gmail.com");
            val packageManager = packageManager
            if (packageManager.queryIntentActivities(intent, 0).size != 0) {
                startActivity(intent)
            } else {
                Snackbar.make(v, "No email client detected, please install one.", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            when (position) {
                ABOUT_ME_FRAGMENT -> return AboutMeFragment.newInstance()
                EDUCATION_FRAGMENT -> return EducationFragment.newInstance()
                TESTIMONY_FRAGMENT -> return TestimonyFragment.newInstance()
                PORTFOLIO_FRAGMENT -> return PortfolioFragment.newInstance()
                else -> return AboutMeFragment.newInstance()
            }

        }

        override fun getCount(): Int {
            // Show 4 total pages.
            return 4
        }

        override fun getPageTitle(position: Int): CharSequence {
            when (position) {
                ABOUT_ME_FRAGMENT -> return "ABOUT ME"
                EDUCATION_FRAGMENT -> return "EDUCATION"
                TESTIMONY_FRAGMENT -> return "REFERRALS"
                PORTFOLIO_FRAGMENT -> return "PORTFOLIO"
                else -> return ""
            }
        }
    }

    companion object {

        private val ABOUT_ME_FRAGMENT = 0
        private val EDUCATION_FRAGMENT = 1
        private val TESTIMONY_FRAGMENT = 2
        private val PORTFOLIO_FRAGMENT = 3
    }
}
