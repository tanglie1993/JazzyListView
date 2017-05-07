package com.tanglie1993.jazzylistview.animator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

/**
 * Created by Administrator on 2017/5/6 0006.
 */

public class FlipItemAnimator implements ListItemAnimator {
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
                if(direction == BELOW){
                    view.setPivotY(0);
                    view.setRotationX(90 * (animatedValue - 1));
                }else{
                    view.setPivotY(view.getMeasuredHeight());
                    view.setRotationX(90 * (1 - animatedValue));
                }
            }
        });
        animation.start();
    }
}
