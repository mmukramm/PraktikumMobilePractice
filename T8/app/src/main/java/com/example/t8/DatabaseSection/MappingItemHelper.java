package com.example.t8.DatabaseSection;

import android.database.Cursor;

import com.example.t8.Models.ItemModel;

import java.util.ArrayList;

public class MappingItemHelper {
    public static ArrayList<ItemModel> getAllItemArrayList (Cursor cursor){
        ArrayList<ItemModel> itemModels = new ArrayList<>();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.ItemColumns._ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.ItemColumns.NAME));
            String description = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.ItemColumns.DESCRIPTION));
            String created_date = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.ItemColumns.CREATED_DATE));
            String created_time = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.ItemColumns.CREATED_TIME));
            itemModels.add(new ItemModel(id, name, description, created_date, created_time));
        }
        return itemModels;
    }
}
