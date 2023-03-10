package com.example.t1_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.pilihbangun);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.bangun_ruang, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String selected = (String) adapterView.getItemAtPosition(i);

        FragmentManager fm = getSupportFragmentManager();
        if (selected.equals("Balok")){
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.container, new BalokFragment());
            ft.commit();
        } else if (selected.equals("Kerucut")) {
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.container, new KerucutFragment());
            ft.commit();
        } else if (selected.equals("Bola")) {
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.container, new BolaFragment());
            ft.commit();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}
}
