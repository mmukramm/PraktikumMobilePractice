package com.example.t2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.t2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ActivityMainBinding binding;
    private Boolean operation = false;
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
        Log.d("halo3", "onClick: " + button.getText());
        String opTV = binding.operationTV.getText().toString();
        if (opTV.equals("0")){
            opTV = "";
            binding.operationTV.setText("");
        }

        if (button.getText().toString().equals("AC")) {
            binding.operationTV.setText("0");
            return;
        }

        if (button.getText().toString().equals("Del")){
            if (opTV.length() == 0 || opTV.length() == 1){
                binding.operationTV.setText("0");
                return;
            }
            binding.operationTV.setText(opTV.substring(0, opTV.length() - 1));
            operation = (isNumber(opTV.substring(opTV.length() - 2, opTV.length() - 1))) ? true : false;
            return;
        }

        if (isNumber(button.getText().toString())){
            binding.operationTV.setText(opTV + button.getText().toString());
            operation = true;
        }

        if (!isNumber(button.getText().toString())){
            if (opTV.length() == 0) {
                binding.operationTV.setText("0");
                return;
            }
            if (!operation) return;
            binding.operationTV.setText(opTV + button.getText().toString());
            operation = false;
        }
    }

    public boolean isNumber(String str){
        if (str == null) return false;
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public void setClick(){
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