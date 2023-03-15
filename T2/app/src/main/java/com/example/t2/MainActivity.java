package com.example.t2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.t2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setClick();
        Log.d("halo1", "onCreate: " + binding.button0);
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
        switch (button.getText().toString()){
            case "0":
                binding.operationTV.setText(opTV + "0");
                break;
            case "1":
                binding.operationTV.setText(opTV + "1");
                break;
            case "2":
                binding.operationTV.setText(opTV + "2");
                break;
            case "3":
                binding.operationTV.setText(opTV + "3");
                break;
            case "4":
                binding.operationTV.setText(opTV + "4");
                break;
            case "5":
                binding.operationTV.setText(opTV + "5");
                break;
            case "6":
                binding.operationTV.setText(opTV + "6");
                break;
            case "7":
                binding.operationTV.setText(opTV + "7");
                break;
            case "8":
                binding.operationTV.setText(opTV + "8");
                break;
            case "9":
                binding.operationTV.setText(opTV + "9");
                break;
            case "+":
                binding.operationTV.setText(opTV + "+");
                break;
            case "-":
                binding.operationTV.setText(opTV + "-");
                break;
            case "x":
                binding.operationTV.setText(opTV + "x");
                break;
            case "/":
                binding.operationTV.setText(opTV + "/");
                break;
            case "=":
                binding.operationTV.setText(opTV + "=");
                break;
            case "AC":
                binding.operationTV.setText("");
                break;
            case "Del":
                binding.operationTV.setText(binding.operationTV.getText().toString().substring(0, binding.operationTV.getText().toString().length() - 1));
                break;
        }
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