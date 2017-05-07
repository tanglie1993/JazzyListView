package com.tanglie1993.jazzylistview.animator;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.ScaleAnimation;

/**
 * Created by Administrator on 2017/5/6 0006.
 */

public class GrowItemAnimator implements ListItemAnimator {
    @Override
    public void animateItem(View view, int direction) {
        if(view == null){
            return;
        }
        ScaleAnimation animation = new ScaleAnimation(0, 1, 0, 1,
                view.getMeasuredWidth() / 2, view.getMeasuredHeight() / 2);
        animation.setDuration(ANIMATION_DURATION);
        animation.setFillAfter(false);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        view.startAnimation(animation);
    }


}
