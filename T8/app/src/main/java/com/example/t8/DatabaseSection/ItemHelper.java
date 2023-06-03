package com.example.t8.DatabaseSection;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ItemHelper {
    private static final String DATABASE_TABLE = DatabaseContract.TABLE_NAME;
    private DatabaseHelper databaseHelper;
    private static SQLiteDatabase database;
    private static volatile ItemHelper INSTANCE;

    private ItemHelper(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public static ItemHelper getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (SQLiteOpenHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ItemHelper(context);
                }
            }
        }
        return INSTANCE;
    }

    public void open() throws SQLException {
        database = databaseHelper.getWritableDatabase();
    }

    public void close() {
        databaseHelper.close();
        if (database.isOpen()) {
            database.close();
        }
    }

    public Cursor queryShowAll() {
        return database.query(
                DATABASE_TABLE,
                null,
                null,
                null,
                null,
                null,
                DatabaseContract.ItemColumns._ID + " ASC"
        );
    }

    public Cursor queryShowById(String id) {
        return database.query(
                DATABASE_TABLE,
                null,
                DatabaseContract.ItemColumns._ID + " = ?",
                new String[]{id},
                null,
                null,
                null,
                null
        );
    }

    public Cursor queryShowByName(String name) {
        return database.query(
                DATABASE_TABLE,
                null,
                DatabaseContract.ItemColumns.NAME + " LIKE ?",
                new String[]{"%" + name + "%"},
                null,
                null,
                null,
                null
        );
    }

    public long insertData(ContentValues values) {
        return database.insert(DATABASE_TABLE, null, values);
    }

    public int updateData(String id, ContentValues values) {
        return database.update(
                DATABASE_TABLE, values, DatabaseContract.ItemColumns._ID + " = ?", new String[]{id});
    }

    public int deleteData(String id) {
        return database.delete(
                DATABASE_TABLE, DatabaseContract.ItemColumns._ID + " = " + id, null);
    }

}
