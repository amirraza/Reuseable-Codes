package com.devstudio.animationpractice;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView dummyTxt = (TextView) findViewById(R.id.dummyTxt);
        dummyTxt.animate().setDuration(2000).scaleX(1.2f).scaleY(1.2f).withLayer();

        TextView dummyTxt2 = (TextView) findViewById(R.id.dummyTxt2);
        dummyTxt2.startAnimation(AnimationUtils.loadAnimation(this, R.anim.huperspace_jump));

        TextView dummyTxt3 = (TextView) findViewById(R.id.dummyTxt3);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 3f, 1f, 3f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(1500);
        scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleAnimation.setRepeatCount(Animation.INFINITE);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        dummyTxt3.startAnimation(scaleAnimation);

        TextView dummyTxt4 = (TextView) findViewById(R.id.dummyTxt4);
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.obj_animator);
        set.setTarget(dummyTxt4);
        set.start();

        TextView dummyTxt5 = (TextView) findViewById(R.id.dummyTxt5);
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.bounce);
        animation1.setRepeatMode(Animation.REVERSE);
        animation1.setRepeatCount(Animation.INFINITE);
        dummyTxt5.startAnimation(animation1);

        TextView dummyTxt6 = (TextView) findViewById(R.id.dummyTxt6);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.zoom_in_with_bounce);
        animation2.setRepeatMode(Animation.REVERSE);
        animation2.setRepeatCount(Animation.INFINITE);
        dummyTxt6.startAnimation(animation2);

        TextView dummyTxt7 = (TextView) findViewById(R.id.dummyTxt7);
        Animation animation3 = AnimationUtils.loadAnimation(this, R.anim.zoom_in_with_one_bounce);
        animation3.setRepeatMode(Animation.REVERSE);
        animation3.setRepeatCount(Animation.INFINITE);
        dummyTxt7.startAnimation(animation3);

        TextView dummyTxt8 = (TextView) findViewById(R.id.rotate1);
        dummyTxt8.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate));

        TextView dummyTxt9 = (TextView) findViewById(R.id.rotate2);
        RotateAnimation rotateAnimation = new RotateAnimation(0f, 360f, 0f, 0f);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setDuration(1500);
        rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        rotateAnimation.setRepeatMode(Animation.REVERSE);
        dummyTxt9.startAnimation(rotateAnimation);

        TextView dummyTxt10 = (TextView) findViewById(R.id.rotate3);
        RotateAnimation rotateAnimation1 = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
        );
        rotateAnimation1.setFillAfter(true);
        rotateAnimation1.setDuration(500);
        rotateAnimation1.setInterpolator(new LinearInterpolator());
        rotateAnimation1.setRepeatCount(Animation.INFINITE);
        rotateAnimation1.setRepeatMode(Animation.RESTART);
        dummyTxt10.startAnimation(rotateAnimation1);


        float cur = 0f;
        TextView dummyTxt11 = (TextView) findViewById(R.id.rotate4);
        final RotateAnimation rotateAnimation2 = new RotateAnimation(
                cur, cur+(360*5),
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
        );
        cur=(cur+(360*15));
        rotateAnimation2.setFillAfter(true);
        rotateAnimation2.setDuration(1000);
        final float finalCur1 = cur;
        rotateAnimation2.setInterpolator(new Interpolator() {
            @Override
            public float getInterpolation(float input) {
                return (float)Math.floor(input* finalCur1)/ 2000;
            }
        });
        rotateAnimation2.setRepeatCount(Animation.INFINITE);
        rotateAnimation2.setRepeatMode(Animation.RESTART);
        dummyTxt11.startAnimation(rotateAnimation2);



        TextView dummyTxt12 = (TextView) findViewById(R.id.rotate5);
        RotateAnimation rotateAnimation3 = new RotateAnimation(
                0, (360*25),
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
        );
        rotateAnimation3.setFillAfter(true);
        rotateAnimation3.setDuration(5000);
        rotateAnimation3.setInterpolator(new AccelerateDecelerateInterpolator());
        rotateAnimation3.setRepeatCount(Animation.INFINITE);
        rotateAnimation3.setRepeatMode(Animation.RESTART);
        dummyTxt12.startAnimation(rotateAnimation3);


        ImageView img = (ImageView) findViewById(R.id.img);
//        AnimatorSet set1 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.obj_animator);
//        set1.setTarget(img);
//        set1.setInterpolator(new AccelerateDecelerateInterpolator());
//        set1.start();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(img,"rotationY",(360*30));
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator.setDuration(5000);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.setRepeatMode(ValueAnimator.RESTART);
        objectAnimator.start();


        LinearLayout animateLay = (LinearLayout) findViewById(R.id.animateLay);
        HeightWithAnimation animation = new HeightWithAnimation(animateLay, 650, 50);
        animation.setDuration(1000);
        animation.setStartOffset(3000);
        animateLay.startAnimation(animation);
        String[] list = {"List 1", "List 1", "List 1", "List 1", "List 1", "List 1", "List 1"};
        ListView listView = (ListView) findViewById(R.id.myList);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));
        listView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;

                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }

                // Handle ListView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });


        ((TextView)findViewById(R.id.go)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeScaleUpAnimation(view,0,0,view.getWidth(),view.getHeight());
                startActivity(intent,options.toBundle());

//                Intent intent = new Intent(RootActivity.this,HomeActivity.class);
//                ActivityOptionsCompat options = ActivityOptionsCompat.
//                        makeSceneTransitionAnimation(RootActivity.this,view,"trans");
//                startActivity(intent,options.toBundle());
//                finish();
//
//                Intent intent = new Intent(RootActivity.this,HomeActivity.class);
//                ActivityOptionsCompat options = ActivityOptionsCompat.makeCustomAnimation(RootActivity.this,R.anim.fade_in,
//                        R.anim.fade_out);
//                startActivity(intent,options.toBundle());
//                finish();
            }
        });

    }
}
