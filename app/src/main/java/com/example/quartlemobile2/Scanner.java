package com.example.quartlemobile2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.zxing.integration.android.IntentIntegrator;

public class Scanner extends AppCompatActivity implements View.OnClickListener {

    private Button scannerBtn;
    private EditText scannerResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        scannerBtn = findViewById(R.id.scannerBtn);
        scannerResult = findViewById(R.id.scannerResult);

        scannerBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.scannerBtn:
                IntentIntegrator inte
                break;
        }
    }
}