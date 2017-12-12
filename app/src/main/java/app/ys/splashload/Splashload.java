package app.ys.splashload;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;



public class Splashload extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashload);

        final TextView tv1 = (TextView) findViewById(R.id.t1);
        final TextView tv2 = (TextView) findViewById(R.id.t2);
        final Animation a1 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fadein);
        final Animation a2 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fadeout);

        a1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                tv1.setVisibility(View.VISIBLE);
                tv1.startAnimation(a1);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        tv2.startAnimation(a1);

        a1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                tv1.startAnimation(a2);
                tv2.startAnimation(a2);


                finish();
                Intent intent = new Intent();
                intent.setClass(Splashload.this, MainActivity.class);
                Splashload.this.startActivity(intent);
                Splashload.this.finish();
                // transition from splash to main menu
                overridePendingTransition(R.anim.activityfadein,
                        R.anim.splashfadeout);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }
}
