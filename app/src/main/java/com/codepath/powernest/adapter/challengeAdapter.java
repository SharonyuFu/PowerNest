package com.codepath.powernest.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.codepath.powernest.R;
import com.codepath.powernest.model.Challenge;
import com.codepath.powernest.model.Event;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by sharonyu on 2017/7/29.
 */

public class challengeAdapter extends RecyclerView.Adapter<challengeAdapter.ViewHolder> {
    private List<Challenge> challenges;
    private Context mContext;
    private static OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    public challengeAdapter(Context context, List<Challenge> challen) {
        mContext = context;
        if (challen == null) {
            throw new IllegalArgumentException("contacts must not be null");
        }
        this.challenges = challen;

    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public challengeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);


        View eventView = inflater.inflate(R.layout.item_challenge, parent, false);


        ViewHolder viewHolder = new ViewHolder(eventView);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(challengeAdapter.ViewHolder holder, int position) {
        Challenge c = challenges.get(position);

        TextView challenDes = holder.challenDes;
        challenDes.setText(c.getChallenDes());

        TextView challenType = holder.challenType;
        challenType.setText(c.getChallenType());

        holder.cdView.setTag(position);

        if(position!=0){
            holder.li.setBackgroundResource(R.drawable.rush_lock);
        }


    }

    @Override
    public int getItemCount() {
        return challenges.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView challenDes;
        public TextView challenType;
        public CardView cdView;
        public LinearLayout li;

        public ViewHolder(final View itemView) {

            super(itemView);

            challenDes= (TextView) itemView.findViewById(R.id.challengeDes);
            challenType = (TextView) itemView.findViewById(R.id.challengeType);
            cdView = (CardView) itemView.findViewById(R.id.cvRoot);
            li = (LinearLayout) itemView.findViewById(R.id.line1);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(itemView, position);
                        }
                    }


                }
            });

        }


    }
}
