package com.tanglie1993.jazzylistview;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by Administrator on 2017/5/6 0006.
 */

class CardAnimation extends Animation {

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        Matrix matrix = new Matrix();
        float[] values = {interpolatedTime, 0, 0, 0, interpolatedTime, 0, 0, 0, 1};
        matrix.setValues(values);
        t.getMatrix().preConcat(matrix);
    }
}
