package com.tanglie1993.jazzylistview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.ScaleAnimation;

/**
 * Created by Administrator on 2017/5/6 0006.
 */

public class CardItemAnimator implements ListItemAnimator {
    @Override
    public void animateItem(final View view) {
        if(view == null){
            return;
        }
        ValueAnimator animation = ObjectAnimator.ofFloat(0, 1);
        animation.setDuration(ANIMATION_DURATION);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedValue = (Float) animation.getAnimatedValue();
                view.setRotationX((1 - animatedValue) * 90);
                view.setTranslationY((float) (view.getMeasuredHeight() * 0.3 * (1 - animatedValue)));
                view.setScaleX((float) (0.5 + 0.5 * animatedValue));
            }
        });
        animation.start();
    }
}
