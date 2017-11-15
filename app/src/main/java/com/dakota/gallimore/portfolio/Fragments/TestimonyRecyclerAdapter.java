package com.dakota.gallimore.portfolio.Fragments;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dakota.gallimore.portfolio.R;

/**
 * Created by Dakota on 10/24/2017.
 */

public class TestimonyRecyclerAdapter extends RecyclerView.Adapter<TestimonyRecyclerAdapter.TestimonyViewHolder> {

    private final Context mContext;
    private final TypedArray testimonyImgs;
    private final TypedArray testimonies;
    private final TypedArray testimonyNames;


    public TestimonyRecyclerAdapter(Context context) {
        mContext = context;
        testimonyImgs = mContext.getResources().obtainTypedArray(R.array.testimony_mipmaps);
        testimonies = mContext.getResources().obtainTypedArray(R.array.testimony_strings);
        testimonyNames = mContext.getResources().obtainTypedArray(R.array.testimony_names);
    }

    @Override
    public TestimonyRecyclerAdapter.TestimonyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId;

        if (viewType % 2 == 0) {
            layoutId = R.layout.testimony_even;
        } else {
            layoutId = R.layout.testimony_odd;
        }
        View view = LayoutInflater.from(mContext).inflate(layoutId, parent, false);
        view.setFocusable(true);
        return new TestimonyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TestimonyViewHolder holder, int position) {
        holder.testimonyText.setText(testimonies.getString(position));
        holder.testimonyImage.setImageResource(testimonyImgs.getResourceId(position, 0));
        holder.testimonyName.setText(testimonyNames.getString(position));
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public static class TestimonyViewHolder extends RecyclerView.ViewHolder {

        final TextView testimonyText;
        final TextView testimonyName;
        final ImageView testimonyImage;

        public TestimonyViewHolder(View view) {
            super(view);

            testimonyImage = view.findViewById(R.id.imageView_testimony);
            testimonyText = view.findViewById(R.id.textView_testimony_statement);
            testimonyName = view.findViewById(R.id.textView_testimony_name);
        }
    }
}
