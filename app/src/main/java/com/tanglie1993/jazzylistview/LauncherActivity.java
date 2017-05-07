package com.tanglie1993.jazzylistview;

import android.animation.Animator;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.tanglie1993.jazzylistview.R;
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

public class LauncherActivity extends AppCompatActivity {

    public static String[] titles = {"Card", "Curl", "Fan", "Flip", "Fly", "Grow", "Helix","PaperCut", "ReverseFly", "Twirl", "Wave"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return titles.length;
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
            public View getView(final int position, View convertView, ViewGroup parent) {
                View view = getLayoutInflater().inflate(R.layout.list_item_layout, parent, false);
                ((TextView) view.findViewById(R.id.title)).setText(titles[position]);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(LauncherActivity.this, MainActivity.class);
                        intent.putExtra("type", position);
                        startActivity(intent);
                    }
                });
                return view;
            }
        });
    }


}
