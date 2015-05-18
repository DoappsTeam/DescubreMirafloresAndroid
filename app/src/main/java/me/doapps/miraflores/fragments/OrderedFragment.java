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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import me.doapps.miraflores.R;
import me.doapps.miraflores.adapter.SwipeListAdapter;
import me.doapps.miraflores.model.Entity_DTO;

/**
 * Created by william on 17/05/2015.
 */
public class OrderedFragment extends Fragment {
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
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        toolbar = (Toolbar)getActivity().findViewById(R.id.toolbar);

        entity_dtos = new ArrayList<>();
        entity_dtos.add(new Entity_DTO("1","name","address","123456","sulca@gmail.com","","http://res.cloudinary.com/drggnfl1o/image/upload/v1431882007/21_bmtqsw.jpg","http://res.cloudinary.com/drggnfl1o/image/upload/v1431884285/imagenes/23.jpg",-12.111373,-77.030002));
        entity_dtos.add(new Entity_DTO("1","name","address","123456","sulca@gmail.com","","http://res.cloudinary.com/drggnfl1o/image/upload/v1431882007/22_dv0mnn.jpg","http://res.cloudinary.com/drggnfl1o/image/upload/v1431885805/imagenes/eventos/22.jpg",-12.125928,-77.022991));
        entity_dtos.add(new Entity_DTO("1","name","address","123456","sulca@gmail.com","","http://res.cloudinary.com/drggnfl1o/image/upload/v1431882007/23_bkfzgq.jpg","http://res.cloudinary.com/drggnfl1o/image/upload/v1431885805/imagenes/eventos/23.jpg",-12.118457,-77.027588));
        entity_dtos.add(new Entity_DTO("1","name","address","123456","sulca@gmail.com","","http://res.cloudinary.com/drggnfl1o/image/upload/v1431882008/24_m8aff3.jpg","http://res.cloudinary.com/drggnfl1o/image/upload/v1431885805/imagenes/eventos/24.jpg",-12.125928,-77.022991));
        entity_dtos.add(new Entity_DTO("1","name","address","123456","sulca@gmail.com","","http://res.cloudinary.com/drggnfl1o/image/upload/v1431882008/25_tabu0p.jpg","http://res.cloudinary.com/drggnfl1o/image/upload/v1431884282/imagenes/1.jpg",-12.118457,-77.027588));

        adapter = new SwipeListAdapter(entity_dtos, getActivity());
        listEvents.setAdapter(adapter);
        listEvents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Entity_DTO  entity_dto  = (Entity_DTO) parent.getAdapter().getItem(position);
                double lat = entity_dto.getLatitude();
                double lng = entity_dto.getLongitide();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new DetailFragment()).commit();

            }
        });

    }



    private void fetchMovies() {

        // showing refresh animation before making http call
        swipeRefreshLayout.setRefreshing(true);

    }


}

