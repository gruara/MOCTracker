package uk.co.gruar.moctracker;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static android.widget.AdapterView.*;

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

//      see comment in xml regarding id definition
        final ListView listView = (ListView) findViewById(android.R.id.list);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
// TODO: 19/03/2017 Refresh screen after delete 
                Log.d(TAG, "Position = " + position);
                final Track track = (Track) parent.getItemAtPosition(position);
                Log.d(TAG, "Track = " + track.getName());
                datasource.deleteTrack(track.getId());
            }

        });

    }
    @Override
    protected void onResume() {
        Log.d(TAG, "onResume");
        datasource.open();
        super.onResume();

    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        datasource.close();
        super.onPause();
    }


    @Override
    protected void onDestroy () {
        Log.d(TAG, "onDestroy");
        datasource.close();
        super.onDestroy();
    }
}
