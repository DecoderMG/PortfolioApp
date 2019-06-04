package com.dakota.gallimore.portfolio.Fragments

import android.content.Context
import android.content.res.TypedArray
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.TextView

import com.dakota.gallimore.portfolio.ChildEducation
import com.dakota.gallimore.portfolio.Education
import com.dakota.gallimore.portfolio.R
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder

/**
 * Created by Dakota on 10/25/2017.
 */

class EducationRecyclerAdapter internal constructor(private val mContext: Context, groups: MutableList<ExpandableGroup<*>>) : ExpandableRecyclerViewAdapter<GroupViewHolder, ChildViewHolder>(groups) {

    internal var categoryIcons: TypedArray


    init {
        categoryIcons = mContext.resources.obtainTypedArray(R.array.education_parent_icons)
    }

    override fun onCreateGroupViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        val parentView = LayoutInflater.from(mContext).inflate(R.layout.education_parent_list_item,
                parent, false)

        val height = parent.measuredHeight / 4
        val width = parent.measuredWidth

        parentView.layoutParams = RecyclerView.LayoutParams(width, height)
        return ParentViewHolder(parentView)
    }

    override fun onCreateChildViewHolder(parent: ViewGroup, viewType: Int): ChildEducationViewHolder {
        val childView = LayoutInflater.from(mContext).inflate(R.layout.education_inner_child_list_item,
                parent, false)
        return ChildEducationViewHolder(childView)
    }

    override fun onBindChildViewHolder(holder: ChildViewHolder, flatPosition: Int, group: ExpandableGroup<*>, childIndex: Int) {
        val cevh = holder as ChildEducationViewHolder

        val child = (group as Education).items[childIndex]

        cevh.header.text = child.header
        cevh.date.text = child.date
        cevh.details.text = child.details
    }

    override fun onBindGroupViewHolder(holder: GroupViewHolder, flatPosition: Int, group: ExpandableGroup<*>) {
        val pvh = holder as ParentViewHolder

        pvh.setEducationTitle(mContext, group)
        pvh.categoryIcon.setImageDrawable(categoryIcons.getDrawable(flatPosition))
    }

    inner class ParentViewHolder(itemView: View) : GroupViewHolder(itemView), View.OnClickListener {

        var parentSection: TextView
        var categoryIcon: ImageView
        var icon: ImageView
        private val wibExpanded: Boolean
        private val educationExpanded: Boolean
        private val experienceExpanded: Boolean
        private val skillsExpanded: Boolean
        private val scrollCounter: Int

        init {
            parentSection = itemView.findViewById(R.id.education_parent_textview)
            icon = itemView.findViewById(R.id.parent_icon)
            categoryIcon = itemView.findViewById(R.id.category_icon)
            itemView.setOnClickListener(this)
            wibExpanded = false
            experienceExpanded = false
            educationExpanded = false
            skillsExpanded = false
            scrollCounter = 7
        }

        override fun onClick(v: View?) {
            super.onClick(v)
            val tv = v!!.findViewById<TextView>(R.id.education_parent_textview)
            if (tv.text == "Skills") {
                EducationFragment.ScrollRecycler(itemCount - 1)
            }
        }

        override fun expand() {
            animateExpand()
        }

        override fun collapse() {
            animateCollapse()
        }


        private fun animateExpand() {
            val rotate = RotateAnimation(360f, 180f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
            rotate.duration = 300
            rotate.fillAfter = true
            icon.animation = rotate
        }

        private fun animateCollapse() {
            val rotate = RotateAnimation(180f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
            rotate.duration = 300
            rotate.fillAfter = true
            icon.animation = rotate
        }

        fun setEducationTitle(context: Context, education: ExpandableGroup<*>) {
            if (education is Education) {
                parentSection.text = education.getTitle()
            }
        }
    }

    inner class ChildEducationViewHolder(itemView: View) : ChildViewHolder(itemView) {

        val header: TextView
        val date: TextView
        val details: TextView

        init {
            header = itemView.findViewById(R.id.textView_education_header)
            date = itemView.findViewById(R.id.textView_education_date)
            details = itemView.findViewById(R.id.textView_education_details)

        }
    }
}
