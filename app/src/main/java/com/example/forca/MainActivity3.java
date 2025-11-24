package com.example.forca;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.forca.MainActivity;
import com.example.forca.R;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btnSair = findViewById(R.id.btnSair);
        btnSair.setOnClickListener(v -> {
            Intent intent = new Intent(com.example.forca.MainActivity3.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

    }
}