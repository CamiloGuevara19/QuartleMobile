package com.example.quartlemobile2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText loginInput1, loginInput2;
    private Button logInBtn1, loginBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //References

        loginInput1 = findViewById(R.id.loginInput1);
        loginInput2 = findViewById(R.id.loginInput2);
        logInBtn1 = findViewById(R.id.logInBtn1);
        loginBtn2 = findViewById(R.id.loginBtn2);
    }
}