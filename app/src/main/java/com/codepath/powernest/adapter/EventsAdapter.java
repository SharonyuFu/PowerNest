package com.codepath.powernest.adapter;

/**
 * Created by sharonyu on 2017/7/29.
 */
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.powernest.R;
import com.codepath.powernest.model.Event;
import com.squareup.picasso.Picasso;

import java.util.List;


public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {
    private List<Event> events;
    private Context mContext;
    private static OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    // Pass in the contact array into the constructor
    public EventsAdapter(Context context, List<Event> events) {
        mContext = context;
        if (events == null) {
            throw new IllegalArgumentException("contacts must not be null");
        }
        this.events = events;

    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public EventsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View eventView = inflater.inflate(R.layout.item_event, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(eventView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EventsAdapter.ViewHolder holder, int position) {
        Event e = events.get(position);

        TextView cName = holder.clubName;
        cName.setText(e.getcName());

        TextView eName = holder.eventName;
        eName.setText(e.geteName());

        TextView eDate = holder.eventDate;
        eDate.setText(e.geteDate());

        TextView eType = holder.eventType;
        eType.setText(e.geteType());

        TextView eTime = holder.eventTime;
        eTime.setText(e.geteTime());

        ImageView img = holder.clubImg;
        Picasso.with(mContext).load(e.getClubImg()).fit().centerCrop().into(holder.clubImg);


    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView clubName;
        public TextView eventName;
        public TextView eventType;
        public TextView eventTime;
        public TextView eventDate;
        public ImageView clubImg;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(final View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            clubName = (TextView) itemView.findViewById(R.id.clubName);
            eventName = (TextView) itemView.findViewById(R.id.eventName);
            eventType = (TextView) itemView.findViewById(R.id.eventType);
            eventTime = (TextView) itemView.findViewById(R.id.eventTime);
            eventDate = (TextView) itemView.findViewById(R.id.eventDate);
            clubImg = (ImageView) itemView.findViewById(R.id.imageView);

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