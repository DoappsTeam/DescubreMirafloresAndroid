package me.doapps.miraflores.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import me.doapps.miraflores.fragments.PositionFragment;
import me.doapps.miraflores.fragments.TimeFragment;

/**
 * Created by william on 17/05/2015.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

        protected static final String[] containt = new String[] { "TIEMPO", "POSICIÓN"};
        private int count = containt.length;

        public TabsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return TimeFragment.newInstance();
                case 1:
                    return PositionFragment.newInstance();
                default:
                    return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return containt[position % containt.length];
        }

        //Método sobreescrito que retorna la cantidad de fragmentos|pestañas
        @Override
        public int getCount() {
            return count;
        }
    }