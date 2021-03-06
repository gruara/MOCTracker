package uk.co.gruar.moctracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Andrew on 11/03/2017.
 */

public class NewTrackActivity extends Activity {
    private MOCTrackerDAO datasource;
    private static final String TAG = "AWG NewTrackActivity";
    public long currentTrack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.newtrack);

        datasource = new MOCTrackerDAO(this);
        datasource.open();

        Calendar c = Calendar.getInstance();
        System.out.println("Current time => "+c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = df.format(c.getTime());

        Log.d(TAG, "Track Name = " + formattedDate);

        currentTrack = datasource.createTrack(formattedDate, "Cycling");
        Log.d(TAG, "Current Track = " + currentTrack);


        findViewById(R.id.play).setOnClickListener(controller);
        findViewById(R.id.pause).setOnClickListener(controller);

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
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }



    private class Controller implements OnClickListener {
        public void onClick(View view) {
            Log.d(TAG, "onClick");
            switch(view.getId()) {
                case R.id.play:
//                    controlService(true);
                    startTrack();
                    break;
                case R.id.pause:
//                    controlService(false);
                    endTrack();
                    break;
            }
        }
    }
    private void startTrack() {
        ((Button)findViewById(R.id.play)).setVisibility(View.GONE);
        ((Button)findViewById(R.id.pause)).setVisibility(View.VISIBLE);
        Context context = this;
        Intent i= new Intent(context, MOCTrackerService.class);
        context.startService(i);
    }

    private void endTrack() {
        ((Button)findViewById(R.id.play)).setVisibility(View.VISIBLE);
        ((Button)findViewById(R.id.pause)).setVisibility(View.GONE);
        Context context = this;
        Intent i= new Intent(context, MOCTrackerService.class);
        context.stopService(i);

    }

    private Controller controller = new Controller();

}

