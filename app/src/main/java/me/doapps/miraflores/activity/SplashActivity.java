package me.doapps.miraflores.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import me.doapps.miraflores.R;

/**
 * Created by jonathan on 17/05/2015.
 */
public class SplashActivity extends ActionBarActivity {
    private ImageView imageLogo;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        imageLogo = (ImageView) findViewById(R.id.imageLogo);

        startAnimations();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MenuActivity.class));
                finish();
                SplashActivity.this.overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        }, 1700);
    }



    private void startAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        relativeLayout.clearAnimation();
        relativeLayout.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();

        imageLogo.clearAnimation();
        imageLogo.startAnimation(anim);
    }
}
