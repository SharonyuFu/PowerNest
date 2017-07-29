package com.codepath.powernest.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codepath.powernest.EventDetailActivity;
import com.codepath.powernest.R;
import com.codepath.powernest.adapter.EventsAdapter;
import com.codepath.powernest.model.Event;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;

public class StarClubFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

    private RecyclerView rvEvents;
    private EventsAdapter eAdapter;
    private List<Event> events = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        events = Event.getEvents();
        super.onCreate(savedInstanceState);
    }

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_star_club, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        rvEvents = (RecyclerView) view.findViewById(R.id.rvStrClub);
        rvEvents.setHasFixedSize(true);
        rvEvents.setItemAnimator(new SlideInDownAnimator());


        eAdapter = new EventsAdapter(this.getActivity().getApplicationContext(),events);

        rvEvents.setAdapter(eAdapter);
        rvEvents.setLayoutManager(new LinearLayoutManager(this.getActivity().getApplicationContext()));

        eAdapter.setOnItemClickListener( new EventsAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View itemView, int position) {
                Intent intent = new Intent(getActivity(), EventDetailActivity.class);
                startActivity(intent);
            }
        });

    }
}
