package me.doapps.miraflores.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import me.doapps.miraflores.R;
import me.doapps.miraflores.util.FontUtil;

/**
 * Created by william on 17/05/2015.
 */
public class SettingsFragment extends Fragment implements View.OnClickListener {
    private ImageView imgMuseum;
    private ImageView imgFood;
    private ImageView imgCulture;
    private ImageView imgPark;
    private ImageView imgTourist;
    private TextView labelDistance;
    private TextView labelEvents;
    private TextView labelMeter;
    private DiscreteSeekBar discreteSeekBar;
    private Button btnSettings;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        imgMuseum = (ImageView)view.findViewById(R.id.imgMuseum);
        imgFood = (ImageView)view.findViewById(R.id.imgFood);
        imgCulture = (ImageView)view.findViewById(R.id.imgCulture);
        imgPark = (ImageView)view.findViewById(R.id.imgPark);
        imgTourist = (ImageView)view.findViewById(R.id.imgTourist);
        labelDistance = (TextView) view.findViewById(R.id.labelDistance);
        labelEvents = (TextView) view.findViewById(R.id.labelEvents);
        labelMeter = (TextView) view.findViewById(R.id.labelMeter);
        discreteSeekBar = (DiscreteSeekBar) view.findViewById(R.id.discreteSeekBar);
        btnSettings = (Button) view.findViewById(R.id.btnSettings);
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

        btnSettings.setOnClickListener(this);

        labelDistance.setTypeface(FontUtil.setSohoLight(getActivity()));
        labelEvents.setTypeface(FontUtil.setSohoLight(getActivity()));
        labelMeter.setTypeface(FontUtil.setSohoLight(getActivity()));

        labelMeter.setText("");

        discreteSeekBar.setNumericTransformer(new DiscreteSeekBar.NumericTransformer() {
            @Override
            public int transform(int value) {
                labelMeter.setText(String.valueOf(value) + " m");
                return value;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgMuseum:
                imgMuseum.setBackgroundResource(R.drawable.selector_brown_disable);
                break;
            case R.id.imgFood:
                imgFood.setBackgroundResource(R.drawable.selector_red_disable);
                break;
            case R.id.imgCulture:
                imgCulture.setBackgroundResource(R.drawable.selector_green_disable);
                break;
            case R.id.imgPark:
                imgPark.setBackgroundResource(R.drawable.selector_yellow_disable);
                break;
            case R.id.imgTourist:
                imgTourist.setBackgroundResource(R.drawable.selector_orange_disable);
                break;
            /*
            case R.id.btnSettings:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new RandomTimerFragment()).commit();
                break;
            */
            default:break;
        }
    }
}

