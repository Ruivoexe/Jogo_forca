package com.example.forca;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnIniciar, btnRanking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciar = findViewById(R.id.btniniciar);
        btnRanking = findViewById(R.id.btnranking);

        btnIniciar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });

        btnRanking.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity9.class);
            startActivity(intent);
        });
    }
}
