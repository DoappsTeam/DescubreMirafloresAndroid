package me.doapps.miraflores.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import me.doapps.miraflores.R;

/**
 * Created by william on 17/05/2015.
 */
public class OrderedFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
    private ListView listEvents;

    /*private String TAG = ListActivity.class.getSimpleName();

    private String URL_TOP_250 = "http://api.androidhive.info/json/imdb_top_250.php?offset=";

    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;
    private SwipeListAdapter adapter;
    private List<Movie> movieList;*/

    // initially offset will be 0, later will be updated while parsing the json
    private int offSet = 0;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ordered, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onRefresh() {

    }
}

