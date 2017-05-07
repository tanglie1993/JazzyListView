package com.tanglie1993.jazzylistview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/**
 * Created by Administrator on 2017/5/6 0006.
 */

public class CurlItemAnimator implements ListItemAnimator {
    @Override
    public void animateItem(final View view, final int direction) {
        if(view == null){
            return;
        }
        CurlAnimation animation = new CurlAnimation(direction);
        animation.setDuration(ANIMATION_DURATION);
        animation.setInterpolator(new DecelerateInterpolator());
        view.setAnimation(animation);
        animation.start();
    }
}
