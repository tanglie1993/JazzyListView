package com.tanglie1993.jazzylistview;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by Administrator on 2017/5/6 0006.
 */

class CardAnimation extends Animation {

    private int height = 0;
    private int width = 0;

    private static final float INITIAL_X_PADDING = 0.3f;
    private static final float INITIAL_Y_RELATIVE_POSITION = 0.8f;

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        this.height = height;
        this.width = width;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        Matrix matrix = new Matrix();
        float v1 = 1 - 2 * INITIAL_X_PADDING * (1 - interpolatedTime);
        float v3 = INITIAL_X_PADDING * width * (1 - interpolatedTime);
        float v5 = interpolatedTime;
        float v6 = INITIAL_Y_RELATIVE_POSITION * height * (1 - interpolatedTime);
        float v9 = 1;
        float[] values = {v1, 0, v3, 0, v5, v6, 0, 0, v9};
        matrix.setValues(values);
        t.getMatrix().preConcat(matrix);
    }
}
