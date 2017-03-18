package uk.co.gruar.moctracker;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Useradmin on 06/03/2017.
 */

public class MainFragment extends Fragment {
    private AlertDialog mDialog;
    private static final String TAG = "AWG MainFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedinstancestate) {

        Log.d(TAG, "onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_main,container,false);

        View newTrack_button = rootView.findViewById(R.id.newTrack_button);

        newTrack_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "newTrack_button onClick");
                Intent intent = new Intent(getActivity(), NewTrackActivity.class);
                getActivity().startActivity(intent);
            }

        });

        View listTracks_button = rootView.findViewById(R.id.listTracks_button);

        listTracks_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "listTracks_button onClick");
                Intent intent = new Intent(getActivity(), ListTracksActivity.class);
                getActivity().startActivity(intent);
            }

        });

        return rootView;
    }


}
