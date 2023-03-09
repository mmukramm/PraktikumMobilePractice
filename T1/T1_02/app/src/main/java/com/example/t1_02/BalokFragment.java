package com.example.t1_02;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BalokFragment extends Fragment {
    private Button myButton;
    private EditText panjanget, lebaret, tinggiet;
    private TextView hasiltxt;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_balok, container, false);
        myButton = view.findViewById(R.id.submitbutton);
        panjanget = (EditText) view.findViewById(R.id.panjanget);
        lebaret = (EditText) view.findViewById(R.id.lebaret);
        tinggiet = (EditText) view.findViewById(R.id.tinggiet);
        hasiltxt = (TextView) view.findViewById(R.id.hasil);

        myButton.setOnClickListener(view1 -> {
            double panjang = Double.parseDouble(panjanget.getText().toString());
            double lebar = Double.parseDouble(lebaret.getText().toString());
            double tinggi = Double.parseDouble(tinggiet.getText().toString());
            double hasil = panjang*lebar*tinggi;
            hasiltxt.setText(String.format("%.2f", hasil));
        });
        return view;
    }
}