package com.example.forca;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    Button btnSair, btnA, btnB, btnC;
    ImageView cabeca;

    int pontos = 0;
    int erros = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        pontos = getIntent().getIntExtra("pontosAtuais", 0);
        erros = getIntent().getIntExtra("errosAtuais", 0);

        btnSair = findViewById(R.id.btnSair);
        btnSair.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        cabeca = findViewById(R.id.cabeca);


        aplicarErros();

        btnA.setOnClickListener(v -> respostaErrada(btnA));
        btnB.setOnClickListener(v -> respostaCerta(btnB));
        btnC.setOnClickListener(v -> respostaErrada(btnC));
    }


    private void aplicarErros() {
        if (erros >= 1) {
            cabeca.setColorFilter(Color.RED);
        }
    }


    private void respostaCerta(Button botao) {
        botao.setBackgroundColor(Color.GREEN);
        pontos++;

        new Handler().postDelayed(() -> {
            botao.setBackgroundTintList(null);

            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            intent.putExtra("pontosAtuais", pontos);
            intent.putExtra("errosAtuais", erros);
            startActivity(intent);
            finish();

        }, 500);
    }


    private void respostaErrada(Button botao) {
        botao.setBackgroundColor(Color.RED);

        erros++;
        cabeca.setColorFilter(Color.RED);

        new Handler().postDelayed(() -> {
            botao.setBackgroundTintList(null);

            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            intent.putExtra("pontosAtuais", pontos);
            intent.putExtra("errosAtuais", erros);
            startActivity(intent);
            finish();

        }, 500);
    }

}
