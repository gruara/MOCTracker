package uk.co.gruar.moctracker;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Andrew on 15/03/2017.
 */

public class MOCTrackerDAO {

    private static final String TAG = "AWG MOCTrackerDAO";
    private SQLiteDatabase database;
    private DatabaseSQLite dbHelper;

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
}
