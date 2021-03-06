package com.tanglie1993.jazzylistview.animator;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/**
 * Created by Administrator on 2017/5/6 0006.
 */

public interface ListItemAnimator {

    int ANIMATION_DURATION = 400;

    int ABOVE = 1;
    int BELOW = 2;

    void animateItem(View view, int direction);
}
