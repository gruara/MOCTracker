package uk.co.gruar.moctracker;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by Andrew on 19/03/2017.
 */

public class MOCTrackerService extends Service {
    private static final String TAG = "AWG MOCTrackerService";

    private Handler handler = new Handler();
    protected Boolean STOP_TIMER = false;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        startTimer();
       return Service.START_NOT_STICKY;


    }
    @Override
    public void onDestroy () {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        STOP_TIMER = true;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        return null;
    }

    private void startTimer() {
        Log.d(TAG, "startTimer");

            handler.postDelayed(runnable, 1000);

    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
      /* do what you need to do */
            Log.d(TAG, "Runnable");
      /* and here comes the "trick" */
            if (!STOP_TIMER) {
                handler.postDelayed(this, 1000);
            };
        }
    };
}
