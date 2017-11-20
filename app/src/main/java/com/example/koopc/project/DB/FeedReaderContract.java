package com.example.koopc.project.DB;

import android.provider.BaseColumns;

/**
 * Created by vkdlv on 2017-11-20.
 */

public class FeedReaderContract {
    public FeedReaderContract(){};


    public static final String SQL_CREATE_CLASS =
            "CREATE TABLE IF NOT EXISTS " + FeedEntry.USER_TABLE_NAME2 + " ( " +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.USER_COLUMN_NAME_GRID + " INTEGER, " +
                    FeedEntry.USER_COLUMN_NAME_CLASSNAME + " text, " +
                    FeedEntry.USER_COLUMN_NAME_LOCATION + " text, " +
                    FeedEntry.USER_COLUMN_NAME_PROFESSOR + " text, " +
                    FeedEntry.USER_COLUMN_NAME_COLOR + " text, " +
                    FeedEntry.USER_COLUMN_NAME_PERMISSION + " text " +
                    " ) ";


    public static final String SQL_DELETE_CLASS =
            "DROP TABLE IF EXISTS " + FeedEntry.USER_TABLE_NAME2;

    public static abstract class FeedEntry implements BaseColumns {
        public static final String USER_TABLE_NAME2 = "class";
        public static final String USER_COLUMN_NAME_CLASSNAME = "classname";
        public static final String USER_COLUMN_NAME_LOCATION = "location";
        public static final String USER_COLUMN_NAME_PROFESSOR = "professor";
        public static final String USER_COLUMN_NAME_COLOR = "color";
        public static final String USER_COLUMN_NAME_GRID = "grid";
        public static final String USER_COLUMN_NAME_PERMISSION = "permission";

    }
}
