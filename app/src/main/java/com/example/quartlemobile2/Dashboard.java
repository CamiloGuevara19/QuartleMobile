package com.example.quartlemobile2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        prueba = findViewById(R.id.prueba);
        db = FirebaseDatabase.getInstance();


        SharedPreferences sp = getSharedPreferences("sp",MODE_PRIVATE);
        id = sp.getString("uid","UserNotFound");

        loadDataBase();


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