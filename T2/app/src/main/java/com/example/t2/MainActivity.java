package com.example.t2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.example.t2.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;
    private Boolean operation = false;
    private Boolean operated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setClick();
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        Log.d("halo3", "onClick: " + button.getText().toString());
        String opTV = binding.operationTV.getText().toString();
        if (opTV.equals("0")) {
            opTV = "";
            binding.operationTV.setText("");
        }

        if (button.getText().toString().equals("AC")) {
            binding.operationTV.setText("0");
            operation = false;
            return;
        }

        if (button.getText().toString().equals("Del")) {
            if (opTV.length() == 0 || opTV.length() == 1) {
                binding.operationTV.setText("0");
                return;
            }
            binding.operationTV.setText(opTV.substring(0, opTV.length() - 1));
            operation = (isNumber(opTV.substring(opTV.length() - 2, opTV.length() - 1))) ? true : false;
            return;
        }

        if (isNumber(button.getText().toString())) {
            if (operated) {
                binding.operationTV.setText(button.getText().toString());
                operated = false;
                return;
            }
            binding.operationTV.setText(opTV + button.getText().toString());
            operation = true;
        }

        if (!isNumber(button.getText().toString())) {
            if (opTV.length() == 0) {
                binding.operationTV.setText("0");
                return;
            }
            if (!operation) return;
            if (button.getText().toString().equals("=")) {
                opTV = opTV.replace("x", "*");
                String dump = "";
                ArrayList<String> arr = new ArrayList<>();
                for (int i = 0; i < opTV.length(); i++) {
                    if (isNumber(String.valueOf(opTV.charAt(i)))) {
                        dump += opTV.charAt(i);
                    }
                    if (!isNumber(String.valueOf(opTV.charAt(i)))) {
                        arr.add(dump);
                        dump = "";
                        arr.add(String.valueOf(opTV.charAt(i)));
                    }
                    if (i == opTV.length() - 1) {
                        arr.add(dump);
                    }
                }
//                for (int i = 0; i < arr.size(); i++) {
//                    System.out.println("ArrList:    " + arr.get(i));
//                }

                double dumpResult = 0;
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i).equals("*")) {
                        dumpResult = Double.parseDouble(arr.get(i - 1)) * Double.parseDouble(arr.get(i + 1));
                        arr.set(i - 1, String.valueOf(dumpResult));
                        arr.remove(i);
                        arr.remove(i);
                        i--;
                    }
                    if (arr.get(i).equals("/")) {
                        dumpResult = Double.parseDouble(arr.get(i - 1)) / Double.parseDouble(arr.get(i + 1));
                        arr.set(i - 1, String.valueOf(dumpResult));
                        arr.remove(i);
                        arr.remove(i);
                        i--;
                    }
                }
                for (int i = 0; i < arr.size(); i++) {
                    System.out.println("ArrList:    " + arr.get(i));
                }
                double result = Double.parseDouble(arr.get(0));

                for (int i = 0; i < arr.size(); i++) {
                    if(arr.get(i).equals("+")){
                        result += Double.parseDouble(arr.get(i + 1));
                        arr.remove(i);
                        arr.remove(i);
                        i--;
                    }
                    if(arr.get(i).equals("-")){
                        result -= Double.parseDouble(arr.get(i + 1));
                        arr.remove(i);
                        arr.remove(i);
                        i--;
                    }
                }
                System.out.println("Result: " + result);

//                if (String.valueOf(result).endsWith(".0")) String.valueOf(result).replace(".0", "");
                binding.operationTV.setText(String.valueOf(result));
                operation = false;
                operated = true;
                return;
            } else {
                binding.operationTV.setText(opTV + button.getText().toString());
                operation = false;
            }

        }
    }

    public boolean isNumber(String str) {
        if (str == null) return false;
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public void setClick() {
        binding.button0.setOnClickListener(this);
        binding.button1.setOnClickListener(this);
        binding.button2.setOnClickListener(this);
        binding.button3.setOnClickListener(this);
        binding.button4.setOnClickListener(this);
        binding.button5.setOnClickListener(this);
        binding.button6.setOnClickListener(this);
        binding.button7.setOnClickListener(this);
        binding.button8.setOnClickListener(this);
        binding.button9.setOnClickListener(this);
        binding.buttonAC.setOnClickListener(this);
        binding.buttonPlus.setOnClickListener(this);
        binding.buttonMinus.setOnClickListener(this);
        binding.buttonMultiply.setOnClickListener(this);
        binding.buttonDivide.setOnClickListener(this);
        binding.buttonEqual.setOnClickListener(this);
        binding.buttonAC.setOnClickListener(this);
        binding.buttonDel.setOnClickListener(this);
    }
}