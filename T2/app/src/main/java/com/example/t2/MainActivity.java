package com.example.t2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.t2.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;
    private Boolean operation = true; // Untuk melihat apakah operator terakhir adalah angka atau bukan
    private Boolean operated = false; // Untuk melihat apakah hasil sudah dioperasikan atau belum

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
        String opTV = binding.operationTV.getText().toString();

        if (button.getText().toString().equals("AC")) {
            binding.operationTV.setText("0");
            return;
        }

        if (button.getText().toString().equals("Del")) {
            if (opTV.length() == 0 || opTV.length() == 1 || operated) {
                binding.operationTV.setText("0");
                return;
            }

            binding.operationTV.setText(opTV.substring(0, opTV.length() - 1));
            operation = (isNumber(opTV.substring(opTV.length() - 2, opTV.length() - 1))) ? true : false;
            return;
        }

        if (isNumber(button.getText().toString())) {
            if (opTV.equals("0")) {
                opTV = "";
                binding.operationTV.setText("");
            }
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
                        if (Double.parseDouble(arr.get(i + 1)) == 0) {
                            Toast.makeText(this, "Cannot divided by 0", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        dumpResult = Double.parseDouble(arr.get(i - 1)) / Double.parseDouble(arr.get(i + 1));
                        arr.set(i - 1, String.valueOf(dumpResult));
                        arr.remove(i);
                        arr.remove(i);
                        i--;
                    }
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
                String setRes = String.valueOf(result);
                if (setRes.endsWith(".0")) setRes = setRes.substring(0, setRes.length() - 2);
                binding.operationTV.setText(setRes);
                operated = true;
                return;
            } else {
                binding.operationTV.setText(opTV + button.getText().toString());
                operation = false;
                operated = false;
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