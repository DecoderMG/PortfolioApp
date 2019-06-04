package com.dakota.gallimore.portfolio.Fragments

import android.content.res.Resources
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.TextView

import com.dakota.gallimore.portfolio.R

/**
 * Created by Dakota on 10/23/2017.
 */

class AboutMeFragment : Fragment() {

    private var mResources: Resources? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.about_me_fragment, container, false)

        mResources = context.resources

        val mSpinner = rootView.findViewById<Spinner>(R.id.spinner_about_me)
        val mTextView = rootView.findViewById<TextView>(R.id.textView_about_me)
        mSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View?, index: Int, l: Long) {
                when (index) {
                    ABOUT_ME -> mTextView.text = mResources!!.getString(R.string.about_me)
                    PERSONALITY -> mTextView.text = mResources!!.getString(R.string.personality)
                    MISSION -> mTextView.text = mResources!!.getString(R.string.mission)
                    STORY -> mTextView.text = mResources!!.getString(R.string.story)
                    else -> mTextView.text = mResources!!.getString(R.string.about_me)
                }
            }
            override fun onNothingSelected(adapterView: AdapterView<*>) { }
        }

        return rootView
    }

    companion object {

        private val ABOUT_ME = 0
        private val PERSONALITY = 1
        private val MISSION = 2
        private val STORY = 3

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(): AboutMeFragment {
            val fragment = AboutMeFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
