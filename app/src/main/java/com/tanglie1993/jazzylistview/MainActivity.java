package com.tanglie1993.jazzylistview;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.tanglie1993.jazzylistview.animator.CardItemAnimator;
import com.tanglie1993.jazzylistview.animator.CurlItemAnimator;
import com.tanglie1993.jazzylistview.animator.FanItemAnimator;
import com.tanglie1993.jazzylistview.animator.FlipItemAnimator;
import com.tanglie1993.jazzylistview.animator.FlyItemAnimator;
import com.tanglie1993.jazzylistview.animator.GrowItemAnimator;
import com.tanglie1993.jazzylistview.animator.HelixItemAnimator;
import com.tanglie1993.jazzylistview.animator.ListItemAnimator;
import com.tanglie1993.jazzylistview.animator.PaperCutItemAnimator;
import com.tanglie1993.jazzylistview.animator.ReverseFlyItemAnimator;
import com.tanglie1993.jazzylistview.animator.TwirlItemAnimator;
import com.tanglie1993.jazzylistview.animator.WaveItemAnimator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JazzyListView listView = (JazzyListView) findViewById(R.id.jazzyListView);
        listView.setListItemAnimator(getAnimator(getIntent().getExtras().getInt("type")));
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 30;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = getLayoutInflater().inflate(R.layout.list_item_layout, parent, false);
                ((TextView) view.findViewById(R.id.title)).setText(String.format("%d %d %d %d %d %d",
                        position, position, position, position, position, position));
                return view;
            }
        });
    }

    private ListItemAnimator getAnimator(int position) {
        switch(position){
            case 0:
                return new CardItemAnimator();
            case 1:
                return new CurlItemAnimator();
            case 2:
                return new FanItemAnimator();
            case 3:
                return new FlipItemAnimator();
            case 4:
                return new FlyItemAnimator();
            case 5:
                return new GrowItemAnimator();
            case 6:
                return new HelixItemAnimator();
            case 7:
                return new PaperCutItemAnimator();
            case 8:
                return new ReverseFlyItemAnimator();
            case 9:
                return new TwirlItemAnimator();
            case 10:
                return new WaveItemAnimator();
            default:
                return new CardItemAnimator();
        }
    }
}
