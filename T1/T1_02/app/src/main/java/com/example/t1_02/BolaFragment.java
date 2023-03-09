package com.example.t1_02;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BolaFragment extends Fragment {
    private Button myButton;
    private EditText jarijariet;
    private TextView hasiltxt;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bola, container, false);
        myButton = view.findViewById(R.id.submitbutton);
        jarijariet = (EditText) view.findViewById(R.id.jarijariet);
        hasiltxt = (TextView) view.findViewById(R.id.hasil);
        myButton.setOnClickListener(view1 -> {
            if (TextUtils.isEmpty(jarijariet.getText().toString())){
                jarijariet.setError("Required");
            }else {
                double jarijari = Double.parseDouble(jarijariet.getText().toString());
                double hasil = (4.0/3.0)*(3.14)*(Math.pow(jarijari, 3));
                hasiltxt.setText(String.format("%.2f", hasil));
            }
        });
        return view;
    }
}