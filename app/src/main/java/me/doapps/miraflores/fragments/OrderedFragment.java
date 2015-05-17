package me.doapps.miraflores.fragments;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import me.doapps.miraflores.R;
import me.doapps.miraflores.adapter.SwipeListAdapter;
import me.doapps.miraflores.model.Entity_DTO;

/**
 * Created by william on 17/05/2015.
 */
public class OrderedFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private String TAG = ListActivity.class.getSimpleName();

    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listEvents;
    private SwipeListAdapter adapter;
    private List<Entity_DTO> entity_dtos;

    private Toolbar toolbar;

    // initially offset will be 0, later will be updated while parsing the json
    private int offSet = 0;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ordered, container, false);
        listEvents = (ListView) view.findViewById(R.id.listEvents);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);

        entity_dtos = new ArrayList<>();
        entity_dtos.add(new Entity_DTO("Mc Donals"));
        entity_dtos.add(new Entity_DTO("Rockys"));
        entity_dtos.add(new Entity_DTO("Popeyes"));
        entity_dtos.add(new Entity_DTO("Ripley"));

        adapter = new SwipeListAdapter(entity_dtos, getActivity());
        listEvents.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        swipeRefreshLayout.setRefreshing(true);
                                        fetchMovies();
                                    }
                                }
        );
    }

    @Override
    public void onRefresh() {

    }

    private void fetchMovies() {

        // showing refresh animation before making http call
        swipeRefreshLayout.setRefreshing(true);

    }
}

