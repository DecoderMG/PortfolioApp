package com.dakota.gallimore.portfolio.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dakota.gallimore.portfolio.ChildEducation;
import com.dakota.gallimore.portfolio.Constants;
import com.dakota.gallimore.portfolio.Education;
import com.dakota.gallimore.portfolio.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EducationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EducationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static RecyclerView.LayoutManager mLayoutManager;

    private String[] educationParentText = Constants.parentEducationTitles;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public EducationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment EducationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EducationFragment newInstance() {
        EducationFragment fragment = new EducationFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static void ScrollRecycler(int position) {
        mLayoutManager.scrollToPosition(position);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        //parentSections = getContext().getResources().obtainTypedArray(R.array.education_parent_sections);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_education, container, false);

        EducationRecyclerAdapter educationRecyclerAdapter = new EducationRecyclerAdapter(getContext(), generateList());

        RecyclerView mRecyclerView = rootView.findViewById(R.id.education_recyclerview);
        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(educationRecyclerAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(educationRecyclerAdapter);
        mRecyclerView.setHasFixedSize(true);
        // Inflate the layout for this fragment
        return rootView;
    }

    private List generateList() {

        List<Education> list = new ArrayList<>();
        String[] headers = Constants.childEducationWIBHeaders;
        String[] dates = Constants.childEducationBlankDates;
        String[] details = Constants.childEducationWIBDetails;

        for (int i = 0; i < educationParentText.length; i++) {

            List<ChildEducation> childEducations = new ArrayList<>();

            switch (i) {
                case 0:
                    headers = Constants.childEducationWIBHeaders;
                    details = Constants.childEducationWIBDetails;
                    break;
                case 1:
                    headers = Constants.childEducationEDUHeaders;
                    dates = Constants.childEducationEDUDate;
                    details = Constants.childEducationEDUDetails;
                    break;
                case 2:
                    headers = Constants.childEducationEXPHeaders;
                    details = Constants.childEducationEXPDetails;
                    dates = Constants.childEducationEXPDate;
                    break;
                case 3:
                    headers = Constants.childEducationSkillsHeaders;
                    details = Constants.childEducationSkillsDetails;
                    dates = Constants.childEducationBlankDates;
                    break;
                default:
                    details = Constants.childEducationWIBDetails;
                    break;
            }
            for (int j = 0; j < headers.length; j++) {
                ChildEducation childEducation =
                        new ChildEducation(headers[j],
                                dates[j], details[j]);
                childEducations.add(childEducation);
            }
            Education education = new Education(educationParentText[i], childEducations);
            list.add(education);
        }
        return list;
    }

}
