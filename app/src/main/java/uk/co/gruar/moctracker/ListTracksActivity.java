package uk.co.gruar.moctracker;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Andrew on 17/03/2017.
 */

public class ListTracksActivity extends ListActivity {
    private MOCTrackerDAO datasource;
    private static final String TAG = "AWG ListTracksActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.listtracks);

        datasource = new MOCTrackerDAO(this);
        datasource.open();

        List<Track> values = datasource.getTracks();

        ArrayAdapter<Track> adapter = new ArrayAdapter<Track>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);


    }
    @Override
    protected void onDestroy () {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
