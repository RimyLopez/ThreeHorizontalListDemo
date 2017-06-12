package com.rimy.threehorizontallistdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Arrays;

import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView typeListView;
    private ListView lineListView;
    private ListView stationListView;
    private String types[] = {"不限", "地铁", "商圈"};
    private String lines[] = {"不限", "1号线", "2号线", "3号线", "4号线", "5号线", "6号线", "7号线", "8号线"
            , "9号线", "10号线", "11号线", "12号线", "13号线", "14号线"};
    private String station1[] = {"不限", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    private String station2[] = {"不限", "11", "22", "33", "44", "55", "66", "77", "88", "99", "1010"
            , "1111", "1212"};
    private TextAdapter typeAdapter;
    private TextAdapter lineOrCircleAdapter;
    private TextAdapter stationAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        typeListView = (ListView) findViewById(R.id.type);
        lineListView = (ListView) findViewById(R.id.line);
        stationListView = (ListView) findViewById(R.id.station);

        typeAdapter = new TextAdapter(this, Arrays.asList(types));
        typeListView.setAdapter(typeAdapter);
        typeListView.setOnItemClickListener(this);

        lineOrCircleAdapter = new TextAdapter(this, Arrays.asList(lines));
        lineListView.setAdapter(lineOrCircleAdapter);
        lineListView.setOnItemClickListener(this);

        stationAdapter = new TextAdapter(this, Arrays.asList(station1));
        stationListView.setAdapter(stationAdapter);
        stationListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ListView listView = (ListView)parent;
        if(listView==typeListView){
            if (typeAdapter != null){
                typeAdapter.setSelectedPos(position);
            }
            switch (position){
                case 1:
                    lineListView.setVisibility(VISIBLE);
                    break;
            }
        }
        else if(listView==lineListView){
            if (lineOrCircleAdapter != null){
                lineOrCircleAdapter.setSelectedPos(position);
            }
            switch (position){
                case 1:
                    stationListView.setVisibility(VISIBLE);
                    stationAdapter.refreshData(Arrays.asList(station1));
                    break;
                case 2:
                    stationListView.setVisibility(VISIBLE);
                    stationAdapter.refreshData(Arrays.asList(station2));
                    break;
            }
        }
        else if(listView==stationListView){
            if (stationAdapter != null){
                stationAdapter.setSelectedPos(position);
            }
        }
    }
}
