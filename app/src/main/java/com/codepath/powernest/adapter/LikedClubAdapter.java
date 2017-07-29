package com.codepath.powernest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.powernest.R;
import com.codepath.powernest.model.Club;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by sharonyu on 2017/7/30.
 */

public class LikedClubAdapter extends ArrayAdapter<Club> {
    private Context mContext;

    public LikedClubAdapter(Context context, List<Club> clubs) {
        super(context, 0, clubs);
        mContext=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Club club = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_liked_club, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tvClubNameLiked);
        TextView tvMembers = (TextView) convertView.findViewById(R.id.tvClubMembersLiked);
        ImageView ivClubImg = (ImageView) convertView.findViewById(R.id.ivClubImgLiked);

        tvName.setText(club.getcName());
        tvMembers.setText(String.valueOf(club.getcGroupmembers()));

        Picasso.with(mContext).load(club.getcPhoto()).fit().centerCrop().into(ivClubImg);

        // Return the completed view to render on screen
        return convertView;
    }



}
