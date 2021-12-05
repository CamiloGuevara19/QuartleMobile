package com.example.quartlemobile2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class CreateAccount extends AppCompatActivity implements View.OnClickListener {

    private EditText registerInput1, registerInput2, registerInput3, registerInput4;
    private Button registerBtn;

    private FirebaseDatabase db;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        db = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();

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
                    auth.createUserWithEmailAndPassword(registerInput3.getText().toString(), registerInput4.getText().toString())
                    .addOnCompleteListener(
                            task -> {
                                if(task.isSuccessful()){
                                    String id = auth.getCurrentUser().getUid();
                                    User user = new User(
                                        "" + registerInput3.getText().toString(),
                                        "",
                                        "" + 0,
                                        registerInput1.getText().toString() + " " + registerInput2.getText().toString()
                                    );
                                    db.getReference().child(id).setValue(user).addOnCompleteListener(
                                           taskdb -> {
                                               if (taskdb.isSuccessful()){
                                                   SharedPreferences sp = getSharedPreferences("sp",MODE_PRIVATE);
                                                   sp.edit().putString("uid",id).apply();
                                                   Intent newDashBoardIntent = new Intent(this, Dashboard.class);
                                                   startActivity(newDashBoardIntent);
                                                   finish();
                                               }
                                           }
                                    );

                                }else{
                                    Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                    );
                    break;
        }
    }
}