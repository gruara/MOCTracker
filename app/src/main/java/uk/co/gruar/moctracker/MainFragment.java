package uk.co.gruar.moctracker;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Useradmin on 06/03/2017.
 */

public class MainFragment extends Fragment {
    private AlertDialog mDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedinstancestate) {
        View rootView = inflater.inflate(R.layout.fragment_main,container,false);


        return rootView;
    }

}
