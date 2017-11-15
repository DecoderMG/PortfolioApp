package com.dakota.gallimore.portfolio.Fragments;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.dakota.gallimore.portfolio.ChildEducation;
import com.dakota.gallimore.portfolio.Education;
import com.dakota.gallimore.portfolio.R;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import java.util.List;

/**
 * Created by Dakota on 10/25/2017.
 */

public class EducationRecyclerAdapter extends ExpandableRecyclerViewAdapter {
    private final Context mContext;

    TypedArray categoryIcons;


    EducationRecyclerAdapter(Context context, List groups) {
        super(groups);
        mContext = context;
        categoryIcons = mContext.getResources().obtainTypedArray(R.array.education_parent_icons);
    }

    @Override
    public ParentViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View parentView = LayoutInflater.from(mContext).inflate(R.layout.education_parent_list_item,
                parent, false);

        int height = parent.getMeasuredHeight() / 4;
        int width = parent.getMeasuredWidth();

        parentView.setLayoutParams(new RecyclerView.LayoutParams(width, height));
        return new ParentViewHolder(parentView);
    }

    @Override
    public ChildEducationViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(mContext).inflate(R.layout.education_inner_child_list_item,
                parent, false);
        return new ChildEducationViewHolder(childView);
    }

    @Override
    public void onBindChildViewHolder(ChildViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        ChildEducationViewHolder cevh = (ChildEducationViewHolder) holder;

        final ChildEducation child = ((Education) group).getItems().get(childIndex);

        cevh.header.setText(child.getHeader());
        cevh.date.setText(child.getDate());
        cevh.details.setText(child.getDetails());
    }

    @Override
    public void onBindGroupViewHolder(GroupViewHolder holder, int flatPosition, ExpandableGroup group) {
        ParentViewHolder pvh = (ParentViewHolder) holder;

        pvh.setEducationTitle(mContext, group);
        pvh.categoryIcon.setImageDrawable(categoryIcons.getDrawable(flatPosition));
    }

    public class ParentViewHolder extends GroupViewHolder implements View.OnClickListener {

        public TextView parentSection;
        public ImageView categoryIcon;
        public ImageView icon;
        private boolean wibExpanded, educationExpanded, experienceExpanded, skillsExpanded;
        private int scrollCounter;

        public ParentViewHolder(View itemView) {
            super(itemView);
            parentSection = itemView.findViewById(R.id.education_parent_textview);
            icon = itemView.findViewById(R.id.parent_icon);
            categoryIcon = itemView.findViewById(R.id.category_icon);
            itemView.setOnClickListener(this);
            wibExpanded = false;
            experienceExpanded = false;
            educationExpanded = false;
            skillsExpanded = false;
            scrollCounter = 7;
        }

        @Override
        public void onClick(View v) {
            super.onClick(v);
            TextView tv = v.findViewById(R.id.education_parent_textview);
            if (tv.getText().equals("Skills")) {
                EducationFragment.ScrollRecycler(getItemCount() - 1);
            }
        }

        @Override
        public void expand() {
            animateExpand();
        }

        @Override
        public void collapse() {
            animateCollapse();
        }


        private void animateExpand() {
            RotateAnimation rotate =
                    new RotateAnimation(360, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            rotate.setDuration(300);
            rotate.setFillAfter(true);
            icon.setAnimation(rotate);
        }

        private void animateCollapse() {
            RotateAnimation rotate =
                    new RotateAnimation(180, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            rotate.setDuration(300);
            rotate.setFillAfter(true);
            icon.setAnimation(rotate);
        }

        public void setEducationTitle(Context context, ExpandableGroup education) {
            if (education instanceof Education) {
                parentSection.setText(education.getTitle());
            }
        }
    }

    public class ChildEducationViewHolder extends ChildViewHolder {

        private TextView header;
        private TextView date;
        private TextView details;

        public ChildEducationViewHolder(View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.textView_education_header);
            date = itemView.findViewById(R.id.textView_education_date);
            details = itemView.findViewById(R.id.textView_education_details);

        }
    }
}
