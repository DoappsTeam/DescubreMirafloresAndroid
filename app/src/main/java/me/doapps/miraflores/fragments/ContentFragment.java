package me.doapps.miraflores.fragments;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import me.doapps.miraflores.R;
import yalantis.com.sidemenu.interfaces.ScreenShotable;

/**
 * Created by william on 17/05/2015.
 */
public class ContentFragment extends Fragment implements ScreenShotable {
    public static final String CLOSE = "Close";
    public static final String MUSEUM = "Museum";
    public static final String FOOD = "Food";
    public static final String TOURIST = "Tourist";
    public static final String PARK = "Park";
    public static final String CULTURE = "Culture";

    private View containerView;
    protected ImageView mImageView;
    protected int res;

    public static ContentFragment newInstance(int resId) {
        ContentFragment contentFragment = new ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Integer.class.getName(), resId);
        contentFragment.setArguments(bundle);
        return contentFragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.containerView = view.findViewById(R.id.container);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        res = getArguments().getInt(Integer.class.getName());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_fragment, container, false);
        mImageView = (ImageView) rootView.findViewById(R.id.image_content);
        mImageView.setClickable(true);
        mImageView.setFocusable(true);
        //mImageView.setImageResource(res);
        Log.e("ESTO SE ", "EJECUTA");
        return rootView;
    }

    @Override
    public void takeScreenShot() {
        /*
        Thread thread = new Thread() {
            @Override
            public void run() {

                Bitmap bitmap = Bitmap.createBitmap(containerView.getWidth(),
                        containerView.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                containerView.draw(canvas);
                ContentFragment.this.bitmap = bitmap;

            }
        };

        thread.start();*/
    }

    @Override
    public Bitmap getBitmap() {
        //return bitmap;
        return null;
    }
}
