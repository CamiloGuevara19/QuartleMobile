package com.example.quartlemobile2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
<<<<<<< Updated upstream
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
=======
import android.widget.ArrayAdapter;
import android.widget.ListView;
>>>>>>> Stashed changes


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    private FirebaseDatabase db;
    private String id;
    private ListView lista;
    private EventAdapter adapter;

    private ImageView scanBtn, homeBtn, rewardsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        lista = findViewById(R.id.eventosLista);

       adapter = new EventAdapter();
        db = FirebaseDatabase.getInstance();
        lista.setAdapter(adapter);

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
                            adapter.clear();
                            
                        for(DataSnapshot child: data.getChildren()) {
                            Event event = child.getValue(Event.class);
                            adapter.addEvent(event);

                            Log.e("objeto", event.toString());
                        }

                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled( DatabaseError error) {

                    }
                }
        );

    }
}