package me.doapps.miraflores.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.doapps.miraflores.R;
import me.doapps.miraflores.adapter.TabsPagerAdapter;

/**
 * Created by william on 17/05/2015.
 */
public class TabsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabs, container, false);

        return view;
    }

}
