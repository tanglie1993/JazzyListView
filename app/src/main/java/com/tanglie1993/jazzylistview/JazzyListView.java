package com.tanglie1993.jazzylistview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by Administrator on 2017/5/6 0006.
 */

public class JazzyListView extends ListView {

    private ListAdapter adapter;

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

            }
        });
    }

    @Override
    public void setAdapter(ListAdapter adapter){
        super.setAdapter(adapter);
        this.adapter = adapter;
    }
}
