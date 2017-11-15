package com.dakota.gallimore.portfolio.Fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.dakota.gallimore.portfolio.R;

/**
 * Created by Dakota on 10/23/2017.
 */

public class AboutMeFragment extends Fragment {

    private static final int ABOUT_ME = 0;
    private static final int PERSONALITY = 1;
    private static final int MISSION = 2;
    private static final int STORY = 3;

    private Resources mResources;

    public AboutMeFragment() {
        super();
    }


    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static AboutMeFragment newInstance() {
        AboutMeFragment fragment = new AboutMeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedState) {
        View rootView = inflater.inflate(R.layout.about_me_fragment, container, false);

        mResources = getContext().getResources();

        Spinner mSpinner = rootView.findViewById(R.id.spinner_about_me);
        final TextView mTextView = rootView.findViewById(R.id.textView_about_me);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case ABOUT_ME:
                        mTextView.setText(mResources.getString(R.string.about_me));
                        break;
                    case PERSONALITY:
                        mTextView.setText(mResources.getString(R.string.personality));
                        break;
                    case MISSION:
                        mTextView.setText(mResources.getString(R.string.mission));
                        break;
                    case STORY:
                        mTextView.setText(mResources.getString(R.string.story));
                        break;
                    default:
                        mTextView.setText(mResources.getString(R.string.about_me));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return rootView;
    }
}
