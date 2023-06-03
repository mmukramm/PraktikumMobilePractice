package com.example.t8;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.t8.DatabaseSection.ItemHelper;
import com.example.t8.DatabaseSection.MappingItemHelper;
import com.example.t8.Models.ItemModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private EditText searchBar_sv;
    private ImageView clearIcon_iv;
    private TextView noItem_tv;
    private RelativeLayout searchBarContainer;
    private FloatingActionButton add_fab;
    private RecyclerView item_rv;
    private ArrayList<ItemModel> items;

    private ActivityResultLauncher<Intent> resultLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if (result.getData() != null) {
                            switch (result.getResultCode()) {
                                case DataDetailActivity.RESULT_ADD:
                                    LoadAllItems(this);
                                    Toast.makeText(this, "Item added successfully",
                                            Toast.LENGTH_SHORT).show();
                                    break;
                                case DataDetailActivity.RESULT_UPDATE:
                                    LoadAllItems(this);
                                    Toast.makeText(this, "Item updated successfully",
                                            Toast.LENGTH_SHORT).show();
                                    break;
                                case DataDetailActivity.RESULT_DELETE:
                                    LoadAllItems(this);
                                    Toast.makeText(this, "Item deleted successfully",
                                            Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        }
                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();

        LoadAllItems(this);

        add_fab.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DataDetailActivity.class);
            resultLauncher.launch(intent);
        });

        clearIcon_iv.setOnClickListener(v -> searchBar_sv.setText(""));

        searchBar_sv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().isEmpty()) {
                    clearIcon_iv.setVisibility(ImageView.GONE);
                    LoadAllItems(MainActivity.this);
                }else {
                    clearIcon_iv.setVisibility(ImageView.VISIBLE);
                    LoadSearchedItems(MainActivity.this, s.toString());
                }
            }
        });
    }

    private void LoadAllItems(Context context) {
        new LoadAsyncItem(context, itemsDump -> {
            if (itemsDump.size() > 0) {
                items = itemsDump;
                searchBarContainer.setVisibility(RelativeLayout.VISIBLE);
                noItem_tv.setVisibility(TextView.GONE);
            }else {
                items = new ArrayList<>();
                searchBarContainer.setVisibility(RelativeLayout.GONE);
                noItem_tv.setVisibility(TextView.VISIBLE);
            }
            showAllItems(items);
        }).execute();
    }

    private void LoadSearchedItems(Context context, String s) {
        new LoadAsyncItem(context, itemsDump -> {
            if (itemsDump.size() > 0) {
                items = itemsDump;
                showAllItems(items);
            }else {
                items = new ArrayList<>();
                showAllItems(items);
            }
        }, s).searchExecute();
    }

    private void setView() {
        searchBar_sv = findViewById(R.id.searchBar_sv);
        clearIcon_iv = findViewById(R.id.clearIcon_iv);
        noItem_tv = findViewById(R.id.noItem_tv);
        item_rv = findViewById(R.id.item_rv);
        add_fab = findViewById(R.id.add_fab);
        searchBarContainer = findViewById(R.id.searchBarContainer);
    }

    private void showAllItems(ArrayList<ItemModel> itemModels) {
        item_rv.setHasFixedSize(true);
        item_rv.setLayoutManager(new LinearLayoutManager(this));
        ItemAdapter itemAdapter = new ItemAdapter(itemModels, resultLauncher);
        item_rv.setAdapter(itemAdapter);
    }

    private static class LoadAsyncItem {
        private final WeakReference<Context> contextWeakReference;
        private final WeakReference<LoadCallback> weakCallback;
        private String searchQuery;
        public LoadAsyncItem(Context weakReference, LoadCallback weakCall) {
            contextWeakReference = new WeakReference<>(weakReference);
            weakCallback = new WeakReference<>(weakCall);
        }

        public LoadAsyncItem(Context weakReference, LoadCallback weakCall, String searchQuery) {
            contextWeakReference = new WeakReference<>(weakReference);
            weakCallback = new WeakReference<>(weakCall);
            this.searchQuery = searchQuery;
        }

        void execute() {
            Executor executor = Executors.newSingleThreadExecutor();
            Handler handler = new Handler(Looper.getMainLooper());
            executor.execute(() -> {
                Context context = contextWeakReference.get();
                ItemHelper itemHelper = ItemHelper.getInstance(context);
                itemHelper.open();
                Cursor itemCursor = itemHelper.queryShowAll();
                ArrayList<ItemModel> itemModels = MappingItemHelper.getAllItemArrayList(itemCursor);
                itemHelper.close();
                handler.post(() -> weakCallback.get().postExecute(itemModels));
            });
        }

        void searchExecute(){
            Executor executor = Executors.newSingleThreadExecutor();
            Handler handler = new Handler(Looper.getMainLooper());
            executor.execute(() -> {
                Context context = contextWeakReference.get();
                ItemHelper itemHelper = ItemHelper.getInstance(context);
                itemHelper.open();
                Cursor itemCursor = itemHelper.queryShowByName(searchQuery);
                ArrayList<ItemModel> itemModels = MappingItemHelper.getAllItemArrayList(itemCursor);
                itemHelper.close();
                handler.post(() -> weakCallback.get().postExecute(itemModels));
            });
        }
    }

    interface LoadCallback{
        void postExecute(ArrayList<ItemModel> items);
    }
}