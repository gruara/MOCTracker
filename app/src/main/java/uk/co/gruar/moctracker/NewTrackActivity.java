package uk.co.gruar.moctracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;


/**
 * Created by Andrew on 11/03/2017.
 */

public class NewTrackActivity extends Activity {

    private static final String TAG = "AWG NewTrackActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.newtrack);

        findViewById(R.id.play).setOnClickListener(controller);
        findViewById(R.id.pause).setOnClickListener(controller);

    }
    private class Controller implements OnClickListener {
        public void onClick(View view) {
            Log.d(TAG, "onClick");
            switch(view.getId()) {
                case R.id.play:
//                    controlService(true);
                    showPauseButton();
                    break;
                case R.id.pause:
//                    controlService(false);
                    showPlayButton();
                    break;
            }
        }
    }
    private void showPauseButton() {
        ((Button)findViewById(R.id.play)).setVisibility(View.GONE);
        ((Button)findViewById(R.id.pause)).setVisibility(View.VISIBLE);
    }

    private void showPlayButton() {
        ((Button)findViewById(R.id.play)).setVisibility(View.VISIBLE);
        ((Button)findViewById(R.id.pause)).setVisibility(View.GONE);
    }

    private Controller controller = new Controller();

}

