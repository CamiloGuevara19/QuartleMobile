package com.example.quartlemobile2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Scanner extends AppCompatActivity implements View.OnClickListener {

    private Button scannerBtn;
    private EditText scannerResult;

    private FirebaseDatabase db;
    private FirebaseAuth auth;

    private String id;

    private ImageView scanBtn, homeBtn, rewardsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();

        scanBtn = findViewById(R.id.scBtn);
        homeBtn = findViewById(R.id.dashBtn);
        rewardsBtn = findViewById(R.id.reBtn);

        scannerBtn = findViewById(R.id.scannerBtn);
        scannerResult = findViewById(R.id.scannerResult);

        scannerBtn.setOnClickListener(this);

        SharedPreferences sp = getSharedPreferences("sp",MODE_PRIVATE);
        id = sp.getString("uid","UserNotFound");

        homeBtn.setOnClickListener(
                (v) -> {
                    Intent dashboardIntent = new Intent(this, Dashboard.class);
                    startActivity(dashboardIntent);
                    finish();
                }
        );

        rewardsBtn.setOnClickListener(
                (v) -> {
                    Intent rewardsIntent = new Intent(this, Rewards.class);
                    startActivity(rewardsIntent);
                    finish();
                }
        );
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.scannerBtn:
                IntentIntegrator integrador = new IntentIntegrator(Scanner.this);
                integrador.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrador.setPrompt("Lector - CDP");
                integrador.setCameraId(0);
                integrador.setBeepEnabled(true);
                integrador.setBarcodeImageEnabled(true);
                integrador.initiateScan();
                break;
        }
    }

    protected void onActivityResult(int requestCode,int resultCode, Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if(result != null){
            if(result.getContents() == null){
                Toast.makeText(this, "Lectura cancelada", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, result.getContents(), Toast.LENGTH_SHORT).show();


                //makeEvent();

            }
        } else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void makeEvent(Event event){
            DatabaseReference ref = db.getReference().child(id).child("eventsAttended").child(event.getName());
            ref.setValue(event);
    }
}