package com.carridegames.pitastracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Tyler on 11/1/2014.
 */
public final class Database {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public Database() {}

    /* Inner class that defines the table contents */
    public static abstract class DataEntry implements BaseColumns {
        public static final String TABLE_NAME = "Events";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_TYPE = "type";
        public static final String COLUMN_NAME_VALUE = "value";

        private static final String TEXT_TYPE = " TEXT";
        private static final String INT_TYPE = " INTEGER";
        private static final String COMMA_SEP = ",";
        private static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + DataEntry.TABLE_NAME + " (" +
                        DataEntry._ID + " INTEGER PRIMARY KEY," +
                        DataEntry.COLUMN_NAME_ID + INT_TYPE + COMMA_SEP +
                        DataEntry.COLUMN_NAME_DATE + TEXT_TYPE + COMMA_SEP +
                        DataEntry.COLUMN_NAME_TYPE + TEXT_TYPE + COMMA_SEP +
                        DataEntry.COLUMN_NAME_VALUE + TEXT_TYPE +
                " )";

        private static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + DataEntry.TABLE_NAME;

        public class DatabaseHelper extends SQLiteOpenHelper {
            // If you change the database schema, you must increment the database version.
            public static final int DATABASE_VERSION = 1;
            public static final String DATABASE_NAME = "Database.db";

            public DatabaseHelper(Context context) {
                super(context, DATABASE_NAME, null, DATABASE_VERSION);
            }
            public void onCreate(SQLiteDatabase db) {
                db.execSQL(SQL_CREATE_ENTRIES);
            }
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                // This database is only a cache for online data, so its upgrade policy is
                // to simply to discard the data and start over
                db.execSQL(SQL_DELETE_ENTRIES);
                onCreate(db);
            }
            public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                onUpgrade(db, oldVersion, newVersion);
            }
        }

    }
}