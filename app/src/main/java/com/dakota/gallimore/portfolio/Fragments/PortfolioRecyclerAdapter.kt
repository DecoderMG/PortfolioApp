package com.dakota.gallimore.portfolio.Fragments

import android.content.Context
import android.content.Intent
import android.content.res.TypedArray
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide
import com.dakota.gallimore.portfolio.R

/**
 * Created by galli_000 on 10/27/2017.
 */

class PortfolioRecyclerAdapter(private val mContext: Context) : RecyclerView.Adapter<PortfolioRecyclerAdapter.PortfolioViewHolder>() {
    private val portfolioImages: TypedArray
    private val portfolioTitles: TypedArray
    private val portfolioSubtitles: TypedArray
    private val portfolioDetails: TypedArray
    private val portfolioLinks: TypedArray
    private val hasBrowser: Boolean

    init {
        portfolioImages = mContext.resources.obtainTypedArray(R.array.portfolio_images)
        portfolioTitles = mContext.resources.obtainTypedArray(R.array.portfolio_titles)
        portfolioSubtitles = mContext.resources.obtainTypedArray(R.array.portfolio_subtitles)
        portfolioDetails = mContext.resources.obtainTypedArray(R.array.portfolio_details)
        portfolioLinks = mContext.resources.obtainTypedArray(R.array.portfolio_links)

        val packageManager = mContext.packageManager
        val intent = Intent(Intent.ACTION_VIEW)
        hasBrowser = packageManager.queryIntentActivities(intent, 0).size != 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioViewHolder {
        val rootView = LayoutInflater.from(mContext).inflate(
                R.layout.portfolio_list_item, parent, false)

        return PortfolioViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: PortfolioViewHolder, position: Int) {
        Glide.with(mContext).load(portfolioImages.getResourceId(position, R.mipmap.amp)).into(
                holder.projectImage)
        holder.projectTitle.text = portfolioTitles.getString(position)
        holder.projectSubtitle.text = portfolioSubtitles.getString(position)
        holder.projectText.text = portfolioDetails.getString(position)
        if (position == 1 || position == 2) {
            holder.projectButton.text = "Visit Website"
        }

        if (hasBrowser) {
            holder.projectButton.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(portfolioLinks.getString(position))
                mContext.startActivity(intent)
            }
        }

    }

    override fun getItemCount(): Int {
        return 6
    }

    inner class PortfolioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var projectImage: ImageView
        var projectTitle: TextView
        var projectText: TextView
        var projectSubtitle: TextView
        var projectButton: Button

        init {

            projectImage = itemView.findViewById(R.id.portfolio_project_image)
            projectTitle = itemView.findViewById(R.id.portfolio_project_title_textview)
            projectText = itemView.findViewById(R.id.portfolio_project_info_text)
            projectSubtitle = itemView.findViewById(R.id.portfolio_project_subtitle_textview)
            projectButton = itemView.findViewById(R.id.portfolio_project_button_view_more)
        }
    }
}
