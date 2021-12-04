package com.example.quartlemobile2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText loginInput1, loginInput2;
    private Button logInBtn1, loginBtn2;

    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseDatabase.getInstance();

        //References
        loginInput1 = findViewById(R.id.loginInput1);
        loginInput2 = findViewById(R.id.loginInput2);
        logInBtn1 = findViewById(R.id.logInBtn1);
        loginBtn2 = findViewById(R.id.loginBtn2);

        logInBtn1.setOnClickListener(
                (view)-> {

                    Intent dashboardIntent = new Intent(this, Dashboard.class);
                    startActivity(dashboardIntent);

                }
        );

        loginBtn2.setOnClickListener(
                (view)-> {

                    Intent registerIntent = new Intent(this, CreateAccount.class);
                    startActivity(registerIntent);

                }
        );
    }
}