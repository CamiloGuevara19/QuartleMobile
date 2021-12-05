package com.example.quartlemobile2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.awt.font.TextAttribute;

public class Dashboard extends AppCompatActivity {

    private FirebaseDatabase db;
    private String id;
    private TextView prueba;

    private ImageView scanBtn, homeBtn, rewardsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        prueba = findViewById(R.id.prueba);
        db = FirebaseDatabase.getInstance();

        scanBtn = findViewById(R.id.scBtn);
        homeBtn = findViewById(R.id.dashBtn);
        rewardsBtn = findViewById(R.id.reBtn);

        SharedPreferences sp = getSharedPreferences("sp",MODE_PRIVATE);
        id = sp.getString("uid","UserNotFound");

        loadDataBase();

        scanBtn.setOnClickListener(
                (v) -> {
                    Intent scannerIntent = new Intent(this, Scanner.class);
                    startActivity(scannerIntent);
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

    private void loadDataBase() {
        Log.e("entro","al load");
        Log.e("id",id);
        DatabaseReference ref = db.getReference().child(id).child("eventsAttended");
        ref.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange( DataSnapshot data) {
                        prueba.setText("");
                        for(DataSnapshot child: data.getChildren()) {
                            Event event = child.getValue(Event.class);
                            prueba.append(event.getName() + "\n");
                            prueba.append(event.getDate() + "\n");
                            prueba.append(event.getPoints() + "\n\n");


                            Log.e("objeto", event.toString());
                        }
                    }

                    @Override
                    public void onCancelled( DatabaseError error) {

                    }
                }
        );

    }
}