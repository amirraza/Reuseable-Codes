package com.devstudio.animationpractice;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

/**
 * Created by AmirRaza on 5/18/2016.
 */
public class HomeActivity extends AppCompatActivity {
    private ImageView pic1,pic2,pic3,pic4,pic5,pic6,pic7,pic8,pic9;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        pic1 = (ImageView) findViewById(R.id.pic1);
        pic2 = (ImageView) findViewById(R.id.pic2);
        pic3 = (ImageView) findViewById(R.id.pic3);
        pic4 = (ImageView) findViewById(R.id.pic4);
        pic5 = (ImageView) findViewById(R.id.pic5);
        pic6 = (ImageView) findViewById(R.id.pic6);
        pic7 = (ImageView) findViewById(R.id.pic7);
        pic8 = (ImageView) findViewById(R.id.pic8);
        pic9 = (ImageView) findViewById(R.id.pic9);
        pic1.setVisibility(View.GONE);
        pic2.setVisibility(View.GONE);
        pic3.setVisibility(View.GONE);
        pic4.setVisibility(View.GONE);
        pic5.setVisibility(View.GONE);
        pic6.setVisibility(View.GONE);
        pic7.setVisibility(View.GONE);
        pic8.setVisibility(View.GONE);
        pic9.setVisibility(View.GONE);
        ((Button)findViewById(R.id.start)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation();
            }
        });
    }

    private void startAnimation(){
        pic1.startAnimation(AnimationUtils.loadAnimation(this,R.anim.slide_in_from_bottom1));
        pic2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.slide_in_from_bottom1));
        pic3.startAnimation(AnimationUtils.loadAnimation(this,R.anim.slide_in_from_bottom2));
        pic4.startAnimation(AnimationUtils.loadAnimation(this,R.anim.slide_in_from_bottom2));
        pic5.startAnimation(AnimationUtils.loadAnimation(this,R.anim.slide_in_from_bottom3));
        pic6.startAnimation(AnimationUtils.loadAnimation(this,R.anim.slide_in_from_bottom3));

        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.forssah_zoom_in_with_one_bounce);
//        animation1.setDuration(900);
        animation1.setStartOffset(700);
        pic7.startAnimation(animation1);

        Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.forssah_zoom_in_with_one_bounce);
//        animation2.setDuration(900);
        animation2.setStartOffset(800);
        pic8.startAnimation(animation2);

        Animation animation3 = AnimationUtils.loadAnimation(this,R.anim.forssah_zoom_in_with_one_bounce);
//        animation3.setDuration(900);
        animation3.setStartOffset(900);
        pic9.startAnimation(animation3);

        pic1.setVisibility(View.VISIBLE);
        pic2.setVisibility(View.VISIBLE);
        pic3.setVisibility(View.VISIBLE);
        pic4.setVisibility(View.VISIBLE);
        pic5.setVisibility(View.VISIBLE);
        pic6.setVisibility(View.VISIBLE);
        pic7.setVisibility(View.VISIBLE);
        pic8.setVisibility(View.VISIBLE);
        pic9.setVisibility(View.VISIBLE);

        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(pic1,"rotationY",(360));
        objectAnimator1.setInterpolator(new DecelerateInterpolator());
        objectAnimator1.setDuration(1500);
        objectAnimator1.start();

        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(pic2,"rotationY",(360));
        objectAnimator2.setInterpolator(new DecelerateInterpolator());
        objectAnimator2.setDuration(1500);
        objectAnimator2.start();

        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(pic3,"rotationY",(360));
        objectAnimator3.setInterpolator(new DecelerateInterpolator());
        objectAnimator3.setDuration(1500);
        objectAnimator3.start();

        ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(pic4,"rotationY",(360));
        objectAnimator4.setInterpolator(new DecelerateInterpolator());
        objectAnimator4.setDuration(1500);
        objectAnimator4.start();

        ObjectAnimator objectAnimator5 = ObjectAnimator.ofFloat(pic5,"rotationY",(360));
        objectAnimator5.setInterpolator(new DecelerateInterpolator());
        objectAnimator5.setDuration(1500);
        objectAnimator5.start();

        ObjectAnimator objectAnimator6 = ObjectAnimator.ofFloat(pic6,"rotationY",(360));
        objectAnimator6.setInterpolator(new DecelerateInterpolator());
        objectAnimator6.setDuration(1500);
        objectAnimator6.start();


        ProgressBar progressBar = (ProgressBar) findViewById(R.id.circularProgress);
        ObjectAnimator animation = ObjectAnimator.ofInt(progressBar, "progress", 0, 100); // see this max value coming back here, we animale towards that value
        animation.setDuration (600); //in milliseconds
        animation.setInterpolator (new AccelerateDecelerateInterpolator());
        animation.start ();
    }
}
