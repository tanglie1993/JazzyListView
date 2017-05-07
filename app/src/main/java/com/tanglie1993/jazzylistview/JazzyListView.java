package com.tanglie1993.jazzylistview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.ListView;

import com.tanglie1993.jazzylistview.animator.FanItemAnimator;
import com.tanglie1993.jazzylistview.animator.HelixItemAnimator;
import com.tanglie1993.jazzylistview.animator.ListItemAnimator;
import com.tanglie1993.jazzylistview.animator.PaperCutItemAnimator;
import com.tanglie1993.jazzylistview.animator.ReverseFlyItemAnimator;
import com.tanglie1993.jazzylistview.animator.TwirlItemAnimator;

/**
 * Created by Administrator on 2017/5/6 0006.
 */

public class JazzyListView extends ListView {

    private ListItemAnimator listItemAnimator = new TwirlItemAnimator();

    private int firstVisibleItem;
    private int lastVisibleItem;

    private boolean hasBegunAnimation = false; // 在首次有item滚出或滚入屏幕时才开始展示动画。避免载入页面时同时展示太多动画。
    private int initialFirstVisibleItem = -1;
    private int initialLastVisibleItem = -1;

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
                if(initialFirstVisibleItem == -1){
                    initialFirstVisibleItem = firstVisibleItem;
                }else if(firstVisibleItem != initialFirstVisibleItem){
                    hasBegunAnimation = true;
                }
                if(initialLastVisibleItem == -1){
                    initialLastVisibleItem = lastVisibleItem;
                }else if(lastVisibleItem != initialLastVisibleItem){
                    hasBegunAnimation = true;
                }
                if(JazzyListView.this.firstVisibleItem > firstVisibleItem && hasBegunAnimation){
                    for(int i = firstVisibleItem; i < JazzyListView.this.firstVisibleItem; i++){
                        listItemAnimator.animateItem(getChildAt(i - firstVisibleItem), ListItemAnimator.ABOVE);
                    }
                }
                if(JazzyListView.this.lastVisibleItem < lastVisibleItem && hasBegunAnimation){
                    for(int i = JazzyListView.this.lastVisibleItem; i < lastVisibleItem; i++){
                        listItemAnimator.animateItem(getChildAt(visibleItemCount - 1 - (i - JazzyListView.this.lastVisibleItem)), ListItemAnimator.BELOW);
                    }
                }

                JazzyListView.this.firstVisibleItem = firstVisibleItem;
                JazzyListView.this.lastVisibleItem = lastVisibleItem;
            }
        });
    }

    public void setListItemAnimator(ListItemAnimator listItemAnimator) {
        this.listItemAnimator = listItemAnimator;
    }
}
