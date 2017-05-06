package com.tanglie1993.jazzylistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by Administrator on 2017/5/6 0006.
 */

public class JazzyListView extends ListView {

    private ListAdapter adapter;

    private int firstVisibleItem;
    private int lastVisibleItem;

    public JazzyListView(Context context) {
        super(context);
        init();
    }

    public JazzyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public JazzyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public JazzyListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        setOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                int lastVisibleItem = firstVisibleItem + visibleItemCount - 1;
                if(JazzyListView.this.firstVisibleItem > firstVisibleItem){
                    animateItem(0);
                }
                if(JazzyListView.this.lastVisibleItem < lastVisibleItem){
                    animateItem(visibleItemCount - 1);
                }

                JazzyListView.this.firstVisibleItem = firstVisibleItem;
                JazzyListView.this.lastVisibleItem = lastVisibleItem;
            }
        });
    }

    private void animateItem(int position) {
        View view = getChildAt(position);
        if(view == null){
            return;
        }
        System.out.println("animateItem: " + position);
        TranslateAnimation animation = new TranslateAnimation(0, 200, 0, 0);
        animation.setDuration(1000);
        animation.setFillAfter(false);
        animation.setInterpolator(new AccelerateInterpolator());
        view.startAnimation(animation);
    }

    @Override
    public void setAdapter(ListAdapter adapter){
        super.setAdapter(adapter);
        this.adapter = adapter;
    }
}
