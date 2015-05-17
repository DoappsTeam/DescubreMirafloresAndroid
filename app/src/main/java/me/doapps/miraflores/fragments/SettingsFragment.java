package me.doapps.miraflores.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import me.doapps.miraflores.R;

/**
 * Created by william on 17/05/2015.
 */
public class SettingsFragment extends Fragment implements View.OnClickListener {
    private ImageView imgMuseum;
    private ImageView imgFood;
    private ImageView imgCulture;
    private ImageView imgPark;
    private ImageView imgTourist;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        imgMuseum = (ImageView)view.findViewById(R.id.imgMuseum);
        imgFood = (ImageView)view.findViewById(R.id.imgFood);
        imgCulture = (ImageView)view.findViewById(R.id.imgCulture);
        imgPark = (ImageView)view.findViewById(R.id.imgPark);
        imgTourist = (ImageView)view.findViewById(R.id.imgTourist);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        imgMuseum.setOnClickListener(this);
        imgFood.setOnClickListener(this);
        imgCulture.setOnClickListener(this);
        imgPark.setOnClickListener(this);
        imgTourist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgMuseum:
                imgMuseum.setImageDrawable(getResources().getDrawable(R.drawable.selector_brown_disable));
                break;
            case R.id.imgFood:
                imgFood.setImageDrawable(getResources().getDrawable(R.drawable.selector_red_disable));
                break;
            case R.id.imgCulture:
                imgCulture.setImageDrawable(getResources().getDrawable(R.drawable.selector_green_disable));
                break;
            case R.id.imgPark:
                imgPark.setImageDrawable(getResources().getDrawable(R.drawable.selector_yellow_disable));
                break;
            case R.id.imgTourist:
                imgTourist.setImageDrawable(getResources().getDrawable(R.drawable.selector_orange_disable));
                break;
            default:break;
        }
    }
}

