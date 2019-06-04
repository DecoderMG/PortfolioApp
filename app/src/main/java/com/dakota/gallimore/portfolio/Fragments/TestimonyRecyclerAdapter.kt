package com.dakota.gallimore.portfolio.Fragments

import android.content.Context
import android.content.res.TypedArray
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.dakota.gallimore.portfolio.R

/**
 * Created by Dakota on 10/24/2017.
 */

class TestimonyRecyclerAdapter(private val mContext: Context) : RecyclerView.Adapter<TestimonyRecyclerAdapter.TestimonyViewHolder>() {
    private val testimonyImgs: TypedArray
    private val testimonies: TypedArray
    private val testimonyNames: TypedArray


    init {
        testimonyImgs = mContext.resources.obtainTypedArray(R.array.testimony_mipmaps)
        testimonies = mContext.resources.obtainTypedArray(R.array.testimony_strings)
        testimonyNames = mContext.resources.obtainTypedArray(R.array.testimony_names)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestimonyRecyclerAdapter.TestimonyViewHolder {
        val layoutId: Int

        if (viewType % 2 == 0) {
            layoutId = R.layout.testimony_even
        } else {
            layoutId = R.layout.testimony_odd
        }
        val view = LayoutInflater.from(mContext).inflate(layoutId, parent, false)
        view.isFocusable = true
        return TestimonyViewHolder(view)
    }

    override fun onBindViewHolder(holder: TestimonyViewHolder, position: Int) {
        holder.testimonyText.text = testimonies.getString(position)
        holder.testimonyImage.setImageResource(testimonyImgs.getResourceId(position, 0))
        holder.testimonyName.text = testimonyNames.getString(position)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return 3
    }

    class TestimonyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        internal val testimonyText: TextView
        internal val testimonyName: TextView
        internal val testimonyImage: ImageView

        init {

            testimonyImage = view.findViewById(R.id.imageView_testimony)
            testimonyText = view.findViewById(R.id.textView_testimony_statement)
            testimonyName = view.findViewById(R.id.textView_testimony_name)
        }
    }
}
