package com.d2202.dip.tabhost;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private  TabHost tabHost;
    private int tabNumber ;
    private TextView txtTimeResult;
    private long start, stop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost = findViewById(R.id.tabHost);
        txtTimeResult = findViewById(R.id.txtTimeResult);
        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("One");

        tabSpec.setIndicator("Tab One");
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("StopWatch");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Two");
        tabSpec.setIndicator("Tab Two");
        tabSpec.setContent(R.id.tab2);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Three");
        tabSpec.setIndicator("Tab Three");
        tabSpec.setContent(R.id.tab3);
        tabHost.addTab(tabSpec);

        tabNumber = 4;
        start = stop = 0;
    }

    public void addNewTab(View view) {

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("addedTab");
        tabSpec.setIndicator("Tab " + tabNumber);
        tabSpec.setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String tag) {
                TextView textView = new TextView(MainActivity.this);
                textView.setText("New Tab " + tabNumber);
                tabNumber++;
                return textView;
            }
        });

        tabHost.addTab(tabSpec);

    }

    public void startTime(View view) {
        start = System.currentTimeMillis();
    }

    public void stopTime(View view) {
        if(start != 0){
            stop = System.currentTimeMillis();
            txtTimeResult.setText((stop - start) + "");
            start = 0;
        }
    }
}
