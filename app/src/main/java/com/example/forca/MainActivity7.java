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

public class MainActivity7 extends AppCompatActivity {

    Button btnSair, btnA, btnB, btnC;
    ImageView perna_dir;
    int pontos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main7);
        pontos = getIntent().getIntExtra("pontosAtuais",0);

        btnSair = findViewById(R.id.btnSair);
        btnSair.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity7.this,MainActivity.class);

            startActivity(intent);
            finish();
        });

        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        perna_dir = findViewById(R.id.perna_dir);

        btnA.setOnClickListener(v -> respostaCerta(btnA));
        btnB.setOnClickListener(v -> respostaErrada(btnB));
        btnC.setOnClickListener(v -> respostaErrada(btnC));

    }

    private void respostaCerta(Button botao)
    {
        botao.setBackgroundColor(Color.GREEN);
        pontos++;
        new Handler().postDelayed(()->{
            botao.setBackgroundColor(Color.TRANSPARENT);
            Intent intent = new Intent(MainActivity7.this,MainActivity.class);
            intent.putExtra("pontosAtuais",pontos);
            startActivity(intent);
            finish();
        },500);
    }

    private void respostaErrada(Button botao) {
        botao.setBackgroundColor(Color.RED);
        perna_dir.setColorFilter(Color.RED);

        new Handler().postDelayed(()->{
            botao.setBackgroundColor(Color.TRANSPARENT);
            Intent intent = new Intent(MainActivity7.this, MainActivity.class);
            intent.putExtra("pontosAtuais",pontos);
            startActivity(intent);
            finish();
        },500);
    }


}