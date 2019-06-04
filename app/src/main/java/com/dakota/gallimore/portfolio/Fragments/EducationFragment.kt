package com.dakota.gallimore.portfolio.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.dakota.gallimore.portfolio.ChildEducation
import com.dakota.gallimore.portfolio.Constants
import com.dakota.gallimore.portfolio.Education
import com.dakota.gallimore.portfolio.R
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup

import java.util.ArrayList


/**
 * A simple [Fragment] subclass.
 * Use the [EducationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EducationFragment : Fragment() {

    private val educationParentText: Array<String> = Constants.parentEducationTitles

    //    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
            mParam2 = arguments.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_education, container, false)

        val educationRecyclerAdapter = EducationRecyclerAdapter(context, generateList())

        val mRecyclerView = rootView.findViewById<RecyclerView>(R.id.education_recyclerview)
        mLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        mRecyclerView.layoutManager = mLayoutManager
        mRecyclerView.adapter = educationRecyclerAdapter
        mRecyclerView.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        mRecyclerView.adapter = educationRecyclerAdapter
        mRecyclerView.setHasFixedSize(true)
        // Inflate the layout for this fragment
        return rootView
    }

    private fun generateList(): MutableList<ExpandableGroup<*>> {

        val list = ArrayList<Education>()
        var headers: Array<String> = Constants.childEducationWIBHeaders
        var dates: Array<String> = Constants.childEducationBlankDates
        var details: Array<String> = Constants.childEducationWIBDetails

        for ((index: Number, value: String) in educationParentText.withIndex()) {

            val childEducations = ArrayList<ChildEducation>()

            when (index) {
                0 -> {
                    headers = Constants.childEducationWIBHeaders
                    details = Constants.childEducationWIBDetails
                }
                1 -> {
                    headers = Constants.childEducationEDUHeaders
                    dates = Constants.childEducationEDUDate
                    details = Constants.childEducationEDUDetails
                }
                2 -> {
                    headers = Constants.childEducationEXPHeaders
                    details = Constants.childEducationEXPDetails
                    dates = Constants.childEducationEXPDate
                }
                3 -> {
                    headers = Constants.childEducationSkillsHeaders
                    details = Constants.childEducationSkillsDetails
                    dates = Constants.childEducationBlankDates
                }
                else -> details = Constants.childEducationWIBDetails
            }
            for ((headerIndex: Number, headerValue: String) in headers.withIndex()) {
                val childEducation = ChildEducation(headers[headerIndex],
                        dates[headerIndex], details[headerIndex])
                childEducations.add(childEducation)
            }
            val education = Education(educationParentText[index], childEducations)
            list.add(education)
        }
        return list.toMutableList()
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"
        private var mLayoutManager: RecyclerView.LayoutManager? = null

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment EducationFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(): EducationFragment {
            val fragment = EducationFragment()
            val args = Bundle()
            //args.putString(ARG_PARAM1, param1);
            //args.putString(ARG_PARAM2, param2);
            fragment.arguments = args
            return fragment
        }

        fun ScrollRecycler(position: Int) {
            mLayoutManager!!.scrollToPosition(position)
        }
    }

}// Required empty public constructor
