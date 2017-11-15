package com.dakota.gallimore.portfolio.Fragments;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dakota.gallimore.portfolio.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PortfolioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PortfolioFragment extends Fragment {


    public PortfolioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PortfolioFragment.
     */
    public static PortfolioFragment newInstance() {
        PortfolioFragment fragment = new PortfolioFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_portfolio, container, false);

        RecyclerView mRecycerView = rootView.findViewById(R.id.portfolio_recyclerview);
        if (getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            LinearLayoutManager layoutManager =
                    new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            mRecycerView.setLayoutManager(layoutManager);
        } else {
            GridLayoutManager layoutManager =
                    new GridLayoutManager(getContext(), 2);
            mRecycerView.setLayoutManager(layoutManager);
        }

        mRecycerView.setHasFixedSize(true);

        PortfolioRecyclerAdapter mAdapter = new PortfolioRecyclerAdapter(getContext());
        mRecycerView.setAdapter(mAdapter);
        // Inflate the layout for this fragment
        return rootView;
    }

}
