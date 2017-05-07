package com.tanglie1993.jazzylistview.animator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

/**
 * Created by Administrator on 2017/5/6 0006.
 */

public class PaperCutItemAnimator implements ListItemAnimator {
    @Override
    public void animateItem(final View view, final int direction) {
        if(view == null){
            return;
        }
        PaperCutAnimation animation = new PaperCutAnimation(direction);
        animation.setDuration(ANIMATION_DURATION);
        animation.setInterpolator(new DecelerateInterpolator());
        view.setAnimation(animation);
        animation.start();
    }

    private class PaperCutAnimation extends Animation {

        private int direction;

        private PaperCutAnimation(int direction){
            super();
            this.direction = direction;
        }

        @Override
        public void initialize(int width, int height, int parentWidth, int parentHeight) {
            super.initialize(width, height, parentWidth, parentHeight);
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            if(direction == BELOW){
                t.getMatrix().postSkew(0, (float) (0.3 - 0.3 * interpolatedTime));
            }else{
                t.getMatrix().postSkew(0, (float) (0.3 * interpolatedTime - 0.3));
            }

        }
    }
}
