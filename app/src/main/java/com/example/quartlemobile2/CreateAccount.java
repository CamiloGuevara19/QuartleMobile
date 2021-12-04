package com.example.quartlemobile2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

public class CreateAccount extends AppCompatActivity implements View.OnClickListener {

    private EditText registerInput1, registerInput2, registerInput3, registerInput4;
    private Button registerBtn;

    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        db = FirebaseDatabase.getInstance();

        //References
        registerInput1 = findViewById(R.id.registerInput1);
        registerInput2 = findViewById(R.id.registerInput2);
        registerInput3 = findViewById(R.id.registerInput3);
        registerInput4 = findViewById(R.id.registerInput4);
        registerBtn = findViewById(R.id.registerBtn);

        registerBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.registerBtn:
                    break;
        }
    }
}