package com.example.forca;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    Button btnSair, btnA, btnB, btnC;
    ImageView cabeca;
    int pontos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        btnSair = findViewById(R.id.btnSair);
        btnSair.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this,MainActivity.class);
            startActivity(intent);
            finish();
        });

        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        cabeca = findViewById(R.id.cabeca);

        btnA.setOnClickListener(v -> respostaErrada(btnA));
        btnB.setOnClickListener(v -> respostaCerta(btnB));
        btnC.setOnClickListener(v -> respostaErrada(btnC));

    }

    private void respostaCerta(Button botao)
    {
        botao.setBackgroundColor(Color.GREEN);

        new Handler().postDelayed(()->{
            botao.setBackgroundTintList(null);
            Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
            startActivity(intent);
            finish();
        },500);
    }

    private void respostaErrada(Button botao) {
        botao.setBackgroundColor(Color.RED);
        cabeca.setColorFilter(Color.RED);

        new Handler().postDelayed(()->{
            botao.setBackgroundTintList(null);
            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            startActivity(intent);
            finish();
        },500);
    }


}