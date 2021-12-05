package com.example.quartlemobile2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText loginInput1, loginInput2;
    private Button logInBtn1, loginBtn2;

    private FirebaseDatabase db;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();

        //References
        loginInput1 = findViewById(R.id.loginInput1);
        loginInput2 = findViewById(R.id.loginInput2);
        logInBtn1 = findViewById(R.id.logInBtn1);
        loginBtn2 = findViewById(R.id.loginBtn2);

        logInBtn1.setOnClickListener(this);

        loginBtn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.logInBtn1:
                auth.signInWithEmailAndPassword(loginInput1.getText().toString(), loginInput2.getText().toString()).addOnCompleteListener(
                        task -> {
                            if(task.isSuccessful()){
                                Intent dashboardIntent = new Intent(this, Dashboard.class);
                                startActivity(dashboardIntent); 
                                finish();
                            }else{
                                Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                );
                break;

            case R.id.loginBtn2:
                Intent registerIntent = new Intent(this, CreateAccount.class);
                startActivity(registerIntent);
                break;
        }
    }
}