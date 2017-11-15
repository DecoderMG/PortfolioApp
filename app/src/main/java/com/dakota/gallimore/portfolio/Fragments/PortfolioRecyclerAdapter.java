package com.dakota.gallimore.portfolio.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dakota.gallimore.portfolio.R;

/**
 * Created by galli_000 on 10/27/2017.
 */

public class PortfolioRecyclerAdapter extends RecyclerView.Adapter<PortfolioRecyclerAdapter.PortfolioViewHolder> {

    private final Context mContext;
    private final TypedArray portfolioImages;
    private final TypedArray portfolioTitles;
    private final TypedArray portfolioSubtitles;
    private final TypedArray portfolioDetails;
    private final TypedArray portfolioLinks;
    private boolean hasBrowser;

    public PortfolioRecyclerAdapter(Context context) {
        mContext = context;
        portfolioImages = mContext.getResources().obtainTypedArray(R.array.portfolio_images);
        portfolioTitles = mContext.getResources().obtainTypedArray(R.array.portfolio_titles);
        portfolioSubtitles = mContext.getResources().obtainTypedArray(R.array.portfolio_subtitles);
        portfolioDetails = mContext.getResources().obtainTypedArray(R.array.portfolio_details);
        portfolioLinks = mContext.getResources().obtainTypedArray(R.array.portfolio_links);

        final PackageManager packageManager = mContext.getPackageManager();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        hasBrowser = packageManager.queryIntentActivities(intent, 0).size() != 0;
    }

    @Override
    public PortfolioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(mContext).inflate(
                R.layout.portfolio_list_item, parent, false);

        return new PortfolioViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(PortfolioViewHolder holder, final int position) {
        Glide.with(mContext).load(portfolioImages.getResourceId(position, R.mipmap.amp)).into(
                holder.projectImage);
        holder.projectTitle.setText(portfolioTitles.getString(position));
        holder.projectSubtitle.setText(portfolioSubtitles.getString(position));
        holder.projectText.setText(portfolioDetails.getString(position));
        if (position == 1 || position == 2) {
            holder.projectButton.setText("Visit Website");
        }

        if (hasBrowser) {
            holder.projectButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(portfolioLinks.getString(position)));
                    mContext.startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class PortfolioViewHolder extends RecyclerView.ViewHolder {

        public ImageView projectImage;
        public TextView projectTitle;
        public TextView projectText;
        public TextView projectSubtitle;
        public Button projectButton;

        public PortfolioViewHolder(View itemView) {
            super(itemView);

            projectImage = itemView.findViewById(R.id.portfolio_project_image);
            projectTitle = itemView.findViewById(R.id.portfolio_project_title_textview);
            projectText = itemView.findViewById(R.id.portfolio_project_info_text);
            projectSubtitle = itemView.findViewById(R.id.portfolio_project_subtitle_textview);
            projectButton = itemView.findViewById(R.id.portfolio_project_button_view_more);
        }
    }
}
