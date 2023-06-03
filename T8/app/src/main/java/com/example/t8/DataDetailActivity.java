package com.example.t8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.t8.DatabaseSection.DatabaseContract;
import com.example.t8.DatabaseSection.ItemHelper;
import com.example.t8.Models.ItemModel;
import com.google.android.material.textfield.TextInputEditText;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DataDetailActivity extends AppCompatActivity {
    public static final int RESULT_ADD = 100;
    public static final int RESULT_UPDATE = 200;
    public static final int RESULT_DELETE = 300;
    public static final String EXTRA_ITEM = "extra_item";
    private TextInputEditText title_et, description_et;
    private Button add_update_btn, delete_btn;
    private boolean isEdit = false;
    private ItemHelper itemHelper;
    private ItemModel item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_detail);
        setView();

        itemHelper = ItemHelper.getInstance(getApplicationContext());
        itemHelper.open();
        item = getIntent().getParcelableExtra(EXTRA_ITEM);

        if (item != null) {
            isEdit = true;
        } else {
            item = new ItemModel();
        }

        if (isEdit) {
            add_update_btn.setText("Update");
            delete_btn.setVisibility(Button.VISIBLE);
            if (item != null) {
                title_et.setText(item.getName());
                description_et.setText(item.getDescription());
            }
        } else {
            add_update_btn.setText("Add");
        }

        add_update_btn.setOnClickListener(v -> addUpdate());
        delete_btn.setOnClickListener(v -> delete());
    }

    private void addUpdate() {
        String title = title_et.getText().toString().trim();
        String description = description_et.getText().toString().trim();

        if (title.isEmpty()) {
            title_et.setError("Title cannot be empty");
            return;
        }

        if (description.isEmpty()) {
            description_et.setError("Description cannot be empty");
            return;
        }

        item.setName(title);
        item.setDescription(description);

        String created_date = getDateOrTime("yyyy/MM/dd");
        String created_time = getDateOrTime("HH:mm:ss");

        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseContract.ItemColumns.DESCRIPTION, description);
        contentValues.put(DatabaseContract.ItemColumns.NAME, title);
        contentValues.put(DatabaseContract.ItemColumns.CREATED_DATE, created_date);
        contentValues.put(DatabaseContract.ItemColumns.CREATED_TIME, created_time);

        Intent intent = new Intent();

        Log.d("DataDetailActivity", "addUpdate: " + created_date + " " + created_time);

        if (isEdit) {
            long result = itemHelper.updateData(String.valueOf(item.getId()), contentValues);
            if (result > 0) {
                item.setId((int) result);
                setResult(RESULT_UPDATE, intent);
                finish();
            } else {
                Toast.makeText(this, "Failed to update data", Toast.LENGTH_SHORT).show();
            }
        } else {
            long result = itemHelper.insertData(contentValues);
            if (result > 0) {
                item.setId((int) result);
                setResult(RESULT_ADD, intent);
                finish();
            } else {
                Toast.makeText(this, "Failed to add data", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private String getDateOrTime(String format) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    private void delete() {
        Intent intent = new Intent();

        long result = itemHelper.deleteData(String.valueOf(item.getId()));

        if (result > 0) {
            setResult(RESULT_DELETE, intent);
            finish();
        } else {
            Toast.makeText(this, "Failed to delete data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setView() {
        title_et = findViewById(R.id.title_et);
        description_et = findViewById(R.id.description_et);
        add_update_btn = findViewById(R.id.add_update_btn);
        delete_btn = findViewById(R.id.delete_btn);
    }
}