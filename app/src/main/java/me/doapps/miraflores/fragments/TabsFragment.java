package me.doapps.miraflores.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viewpagerindicator.TitlePageIndicator;

import me.doapps.miraflores.R;
import me.doapps.miraflores.adapter.TabsPagerAdapter;

/**
 * Created by william on 17/05/2015.
 */
public class TabsFragment extends Fragment {

    TitlePageIndicator titlePageIndicator;
    ViewPager viewPager;
    TabsPagerAdapter tabAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabs, container, false);
        titlePageIndicator = (TitlePageIndicator) view.findViewById(R.id.indicator);
        //Asociar los objetos con las variables
        viewPager = (ViewPager) view.findViewById(R.id.pager);
        //Instanciamos la clase TabAdapter y le enviamos el administrador de fragmentos
        tabAdapter = new TabsPagerAdapter(getChildFragmentManager());
        //establecemos el adaptador para el viewPager
        viewPager.setAdapter(tabAdapter);
        //establecemos el viewpager para el titlePageIndicator (enlazamos)
        titlePageIndicator.setViewPager(viewPager);
        return view;
    }

}
