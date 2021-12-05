package com.example.quartlemobile2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Rewards extends AppCompatActivity {

    private Button redeemBtn, redeemBtn1, redeemBtn2, redeemBtn3; //0 es premio 2, 1 es premio 1, 2 es premio 3 y 4 es premio 4

    private FirebaseDatabase db;
    private FirebaseAuth auth;

    private ImageView scanBtn, homeBtn, rewardsBtn;

    private String id;

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

        SharedPreferences sp = getSharedPreferences("sp",MODE_PRIVATE);
        id = sp.getString("uid","UserNotFound");

        DatabaseReference ref = db.getReference().child(id);

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
                    clainReward("RAPPI25%OFF", 1500, ref);

                }
        );

        redeemBtn1.setOnClickListener( //cine colombia
                (v) -> {
                    clainReward("CC1TICKETRDM", 1000, ref);

                }
        );

        redeemBtn2.setOnClickListener( //netflix
                (v) -> {
                    clainReward("NETFLIX1MONTHFREE", 3000, ref);

                }
        );

        redeemBtn3.setOnClickListener( //spotify
                (v) -> {
                    clainReward("SPOTIFY1MONTHFREE", 3000, ref);

                }
        );
    }

    public void clainReward(String codeReward, int cost, DatabaseReference ref){
        ref.addListenerForSingleValueEvent(
                new ValueEventListener() {

                    @Override
                    public void onDataChange( DataSnapshot data) {

                        User user = data.getValue(User.class);

                        int points = Integer.parseInt(user.getPoints());
                        Log.e("a", user.getPoints());

                        if(points < cost){
                            toastAlert("You don't have enoght points");
                        }else{
                            points = points - cost;
                            toastAlert("successfully claimed price" + "\n" + "code: " + codeReward);
                            user.setPoints("" + points);
                            ref.setValue(user);
                        }
                    }
                    @Override
                    public void onCancelled( DatabaseError error) {

                    }
                });
    }

    private void toastAlert(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}