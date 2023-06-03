package com.example.t8.DatabaseSection;

import android.provider.BaseColumns;

public class DatabaseContract {
    public static final String DATABASE_NAME = "item.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "item";

    public static final class ItemColumns implements BaseColumns {
        public static final String NAME = "name";
        public static final String DESCRIPTION = "description";
        public static final String CREATED_DATE = "created_date";
        public static final String CREATED_TIME = "created_time";
    }
}
