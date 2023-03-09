package com.example.t1_02;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BalokFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BalokFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BalokFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BalokFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BalokFragment newInstance(String param1, String param2) {
        BalokFragment fragment = new BalokFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private Button myButton;
    private EditText panjanget, lebaret, tinggiet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_balok, container, false);
        myButton = view.findViewById(R.id.submitbutton);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                panjanget = view.findViewById(R.id.panjanget);
                lebaret = view.findViewById(R.id.lebaret);
                tinggiet = view.findViewById(R.id.tinggiet);
            }
        });
        return view;
    }
}