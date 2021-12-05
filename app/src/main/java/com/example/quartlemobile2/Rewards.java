package com.example.quartlemobile2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Rewards extends AppCompatActivity {

    private Button redeemBtn, redeemBtn1, redeemBtn2, redeemBtn3; //0 es premio 2, 1 es premio 1, 2 es premio 3 y 4 es premio 4

    private FirebaseDatabase db;
    private FirebaseAuth auth;

    private ImageView scanBtn, homeBtn, rewardsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();

        scanBtn = findViewById(R.id.scBtn2);
        homeBtn = findViewById(R.id.dashBtn2);
        rewardsBtn = findViewById(R.id.reBtn2);

        redeemBtn = findViewById(R.id.redeemBtn);
        redeemBtn1 = findViewById(R.id.redeemBtn1);
        redeemBtn2 = findViewById(R.id.redeemBtn2);
        redeemBtn3 = findViewById(R.id.redeemBtn3);

        homeBtn.setOnClickListener(
                (v) -> {
                    Intent dashboardIntent = new Intent(this, Dashboard.class);
                    startActivity(dashboardIntent);
                    finish();
                }
        );

        scanBtn.setOnClickListener(
                (v) -> {
                    Intent scannerIntent = new Intent(this, Scanner.class);
                    startActivity(scannerIntent);
                    finish();
                }
        );

        redeemBtn.setOnClickListener( //rappi
                (v) -> {
                    String id = auth.getCurrentUser().getUid();

                }
        );

        redeemBtn1.setOnClickListener( //cine colombia
                (v) -> {
                    String id = auth.getCurrentUser().getUid();

                }
        );

        redeemBtn2.setOnClickListener( //netflix
                (v) -> {
                    String id = auth.getCurrentUser().getUid();

                }
        );

        redeemBtn3.setOnClickListener( //spotify
                (v) -> {
                    String id = auth.getCurrentUser().getUid();

                }
        );
    }
}