package com.tanglie1993.jazzylistview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;

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

    private class CurlAnimation extends Animation {

        private int direction;

        private CurlAnimation(int direction){
            super();
            this.direction = direction;
        }

        @Override
        public void initialize(int width, int height, int parentWidth, int parentHeight) {
            super.initialize(width, height, parentWidth, parentHeight);
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            double theta;
            if(interpolatedTime < 0.67){
                theta = 3.14 * 0.125 * (1 - interpolatedTime * (1.1f / 0.67f));
            }else{
                theta = 3.14 * 0.125 * ((interpolatedTime - 0.67) * 0.33 - 0.1);
            }
            if(direction == ListItemAnimator.ABOVE){
                theta = -theta;
            }

            Matrix matrix = new Matrix();
            float v1 = (float) Math.cos(theta) * interpolatedTime;
            float v2 = (float) -Math.sin(theta) * interpolatedTime;
            float v4 = (float) Math.sin(theta);
            float v5 = (float) Math.cos(theta);
            float v9 = 1;
            float[] values = {v1, v2, 0, v4, v5, 0, 0, 0, v9};
            matrix.setValues(values);
            t.getMatrix().preConcat(matrix);
            t.setAlpha(interpolatedTime);
        }
    }
}
