package com.dakota.gallimore.portfolio.Fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.dakota.gallimore.portfolio.R

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [TestimonyFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [TestimonyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class TestimonyFragment : Fragment() {

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
        // Inflate the layout for this fragment
        val rootView = inflater!!.inflate(R.layout.fragment_testimony, container, false)

        val mRecyclerView = rootView.findViewById<RecyclerView>(R.id.testimony_recycler_view)

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        mRecyclerView.layoutManager = layoutManager
        mRecyclerView.setHasFixedSize(true)

        val mAdapter = TestimonyRecyclerAdapter(context)

        mRecyclerView.adapter = mAdapter

        return rootView
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment TestimonyFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(): TestimonyFragment {
            val fragment = TestimonyFragment()
            val args = Bundle()
            //args.putString(ARG_PARAM1, param1);
            //args.putString(ARG_PARAM2, param2);
            fragment.arguments = args
            return fragment
        }
    }
}