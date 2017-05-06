package com.tanglie1993.jazzylistview;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.ScaleAnimation;

/**
 * Created by Administrator on 2017/5/6 0006.
 */

public class CardItemAnimator implements ListItemAnimator {
    @Override
    public void animateItem(View view) {
        if(view == null){
            return;
        }
        CardAnimation animation = new CardAnimation();
        animation.setDuration(1000);
        animation.setFillAfter(false);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        view.startAnimation(animation);
    }
}
