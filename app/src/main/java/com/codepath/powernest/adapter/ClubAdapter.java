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
 * Created by Zen on 2017/7/29.
 */

public class ClubAdapter extends ArrayAdapter<Club> {
    private Context mContext;

    public ClubAdapter(Context context, List<Club> clubs) {
        super(context, 0, clubs);
        mContext=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Club club = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_club, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tvClubName);
        TextView tvMembers = (TextView) convertView.findViewById(R.id.tvClubMembers);
        TextView tvUpcomingMembers = (TextView) convertView.findViewById(R.id.tvUpcomingMembers);
        TextView tvMessages = (TextView) convertView.findViewById(R.id.tvMessages);
        ImageView ivClubImg = (ImageView) convertView.findViewById(R.id.ivClubImg);
        // Populate the data into the template view using the data object
        tvName.setText(club.getcName());
        tvMembers.setText(String.valueOf(club.getcGroupmembers()));
        tvUpcomingMembers.setText(String.valueOf(club.getcUpcomingmembers()));
        tvMessages.setText(String.valueOf(club.getcMessages()));
        Picasso.with(mContext).load(club.getcPhoto()).fit().centerCrop().into(ivClubImg);

        // Return the completed view to render on screen
        return convertView;
    }



}
