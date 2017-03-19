package uk.co.gruar.moctracker;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static android.R.attr.id;

/**
 * Created by Andrew on 15/03/2017.
 */

// TODO: 18/03/2017 Get all Tracks
// TODO: 18/03/2017 Update Track 
// TODO: 18/03/2017 Store Readings 
// TODO: 18/03/2017 Get all Readings 

public class MOCTrackerDAO {

    private static final String TAG = "AWG MOCTrackerDAO";
    private SQLiteDatabase database;
    private DatabaseSQLite dbHelper;

    private String[] allColumns = { DatabaseSQLite.COLUMN_ID, DatabaseSQLite.COLUMN_TRACK_NAME, DatabaseSQLite.COLUMN_TRACK_DESC };


    public MOCTrackerDAO(Context context) {
        dbHelper = new DatabaseSQLite(context);
        Log.d(TAG, "MOCTrackerDAO");
    }
    public void open() throws SQLException {
        Log.d(TAG, "Open");
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        Log.d(TAG, "Close");
        dbHelper.close();
    }

    public long createTrack(String name, String description) {
        Log.d(TAG, "Create Track");
        ContentValues values = new ContentValues();
        values.put(DatabaseSQLite.COLUMN_TRACK_NAME, name);
        values.put(DatabaseSQLite.COLUMN_TRACK_DESC, description);

        long insertId = database.insert(DatabaseSQLite.TABLE_TRACK_NAME, null, values);
        Log.d(TAG, "ID = " + insertId);

        return insertId;

    }

    public List<Track> getTracks () {
        Log.d(TAG, "getTracks");
        List<Track> tracks = new ArrayList<Track>();

        Cursor cursor = database.query(DatabaseSQLite.TABLE_TRACK_NAME,
                allColumns, null, null, null, null, DatabaseSQLite.COLUMN_TRACK_NAME + " DESC", null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Track track = cursorToTrack(cursor);
            tracks.add(track);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return tracks;
    }

    private Track cursorToTrack(Cursor cursor) {
        Log.d(TAG, "cursorToTrack");
        Track track = new Track();
        track.setId(cursor.getLong(0));
        track.setName(cursor.getString(1));
        track.setDescription(cursor.getString(2));
        return track;
    }

    public void deleteTrack(long id) {
        Log.d(TAG, "deleteTrack");
        Integer deleted = database.delete(DatabaseSQLite.TABLE_TRACK_NAME, DatabaseSQLite.COLUMN_ID + " = " + id,null);
        Log.d(TAG, deleted + " track(s) deleted");

    }


}
