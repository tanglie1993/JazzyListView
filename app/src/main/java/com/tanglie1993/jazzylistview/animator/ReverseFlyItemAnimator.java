package com.tanglie1993.jazzylistview.animator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

/**
 * Created by Administrator on 2017/5/6 0006.
 */

public class ReverseFlyItemAnimator implements ListItemAnimator {
    @Override
    public void animateItem(final View view, final int direction) {
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
                view.setScaleX((float) (0.7 + 0.3 * animatedValue));
                if(direction == BELOW){
                    view.setRotationX(180 * (animatedValue - 1));
                }else{
                    view.setRotationX(180 * (1 - animatedValue));
                }
                view.setAlpha(animatedValue);
            }
        });
        animation.start();
    }
}
