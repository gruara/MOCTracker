package uk.co.gruar.moctracker;

/**
 * Created by Andrew on 12/03/2017.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;



public class DatabaseSQLite extends SQLiteOpenHelper {
    private static final String TAG = "AWG DatabaseSQLite";

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MOCTracker.sqlitedb";

    public static final String TABLE_TRACK_NAME = "Track";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TRACK_NAME = "name";
    public static final String COLUMN_TRACK_DESC = "description";

    private static final String DATABASE_CREATE =
            "create table " + TABLE_TRACK_NAME + "( "
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_TRACK_NAME + " text not null"
            + COLUMN_TRACK_DESC + " text not null"
            + ")"  + ";";


    public DatabaseSQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d(TAG, "DatabaseSQLite");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate");
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade");

    }
}
