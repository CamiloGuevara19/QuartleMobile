package com.example.quartlemobile2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CreateAccount extends AppCompatActivity {

    private EditText registerInput1, registerInput2, registerInput3, registerInput4;
    private Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        //References
        registerInput1 = findViewById(R.id.registerInput1);
        registerInput2 = findViewById(R.id.registerInput2);
        registerInput3 = findViewById(R.id.registerInput3);
        registerInput4 = findViewById(R.id.registerInput4);
        registerBtn = findViewById(R.id.registerBtn);
    }
}