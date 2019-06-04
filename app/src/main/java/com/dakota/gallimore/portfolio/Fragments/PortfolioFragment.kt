package com.dakota.gallimore.portfolio.Fragments


import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.dakota.gallimore.portfolio.R


/**
 * A simple [Fragment] subclass.
 * Use the [PortfolioFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PortfolioFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater!!.inflate(R.layout.fragment_portfolio, container, false)

        val mRecycerView = rootView.findViewById<RecyclerView>(R.id.portfolio_recyclerview)
        if (context.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            mRecycerView.layoutManager = layoutManager
        } else {
            val layoutManager = GridLayoutManager(context, 2)
            mRecycerView.layoutManager = layoutManager
        }

        mRecycerView.setHasFixedSize(true)

        val mAdapter = PortfolioRecyclerAdapter(context)
        mRecycerView.adapter = mAdapter
        // Inflate the layout for this fragment
        return rootView
    }

    companion object {

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment PortfolioFragment.
         */
        fun newInstance(): PortfolioFragment {
            val fragment = PortfolioFragment()
            return fragment
        }
    }

}// Required empty public constructor
