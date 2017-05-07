package com.tanglie1993.jazzylistview.animator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

/**
 * Created by Administrator on 2017/5/6 0006.
 */

public class CardItemAnimator implements ListItemAnimator {

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
                int flag = direction == BELOW ? 1 : -1;
                view.setRotationX((1 - animatedValue) * flag * 90);
                view.setTranslationY((float) (view.getMeasuredHeight() * 0.3 * flag * (1 - animatedValue)));
                view.setScaleX((float) (0.5 + 0.5 * animatedValue));
                view.setScaleY((float) (0.5 + 0.5 * animatedValue));
            }
        });
        animation.start();
    }
}
