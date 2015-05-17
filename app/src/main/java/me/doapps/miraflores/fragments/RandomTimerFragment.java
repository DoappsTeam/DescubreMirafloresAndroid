package me.doapps.miraflores.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.andtinder.model.CardModel;
import com.andtinder.view.CardContainer;
import com.andtinder.view.SimpleCardStackAdapter;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import me.doapps.miraflores.model.Entity_DTO;

/**
 * Created by william on 17/05/2015.
 */
public class RandomTimerFragment extends Fragment {
    private String receive;
    int count = 0;
/*
    public static final RandomTimerFragment newInstance(String flag) {
        RandomTimerFragment randomTimerFragment = new RandomTimerFragment();
        Bundle bundle = new Bundle();
        bundle.putString("FLAG", flag);
        randomTimerFragment.setArguments(bundle);
        return randomTimerFragment;
    }
*/
    SimpleCardStackAdapter adapter;
    CardContainer mCardContainer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabs, container, false);
        mCardContainer = (CardContainer) view.findViewById(R.id.layoutview);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new SimpleCardStackAdapter(getActivity());
        count = 3;
        for(int i=0; i<count; i++){
            new downloadShow().execute(new Entity_DTO("1","name1","address1","123","","","","",0,0));
        }
    }

    int i = 0;
    class downloadShow extends AsyncTask<Entity_DTO, Void, Entity_DTO> {

        @Override
        protected Entity_DTO doInBackground(Entity_DTO... params) {
            try {
                URL url = new URL(params[0].getUrlBanner());
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                params[0].setBitmap(BitmapFactory.decodeStream(input));
                return params[0];
            } catch (Exception e1) {
                Log.e("imageUtil", e1.toString());
                return null;
            }
        }

        @Override
        protected void onPostExecute(Entity_DTO entity_dto) {
            super.onPostExecute(entity_dto);
            i++;
            adapter.add(new CardModel(entity_dto.getName(), entity_dto.getAddress() + ", 18/05/2015", entity_dto.getBitmap()));
            if(i == count){
                mCardContainer.setAdapter(adapter);
            }

        }
    }
}

