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
import android.widget.AdapterView;
import android.widget.ListView;

import com.codepath.powernest.EventDetailActivity;
import com.codepath.powernest.GropuDetailActivity;
import com.codepath.powernest.R;
import com.codepath.powernest.adapter.ClubAdapter;
import com.codepath.powernest.adapter.EventsAdapter;
import com.codepath.powernest.model.Club;
import com.codepath.powernest.model.Event;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;

/**
 * Created by sharonyu on 2017/7/30.
 */

public class GroupManagerFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

    private ListView lvPowerGroup;
    private List<Club> clubs = new ArrayList<>();
    private ClubAdapter adapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        clubs = Club.getClubs();
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_group_manager, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        lvPowerGroup = (ListView) view.findViewById(R.id.lvPowerGroup);
        adapter = new ClubAdapter(this.getActivity().getApplicationContext(), clubs);

        lvPowerGroup.setAdapter(adapter);

        lvPowerGroup.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(),"TEST",Toast.LENGTH_SHORT).show();
                Intent g = new Intent(getActivity(), GropuDetailActivity.class);
                getActivity().startActivity(g);

            }

        });
    }
}

