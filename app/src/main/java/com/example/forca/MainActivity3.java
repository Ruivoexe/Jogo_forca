package com.example.forca;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    Button btnSair, btnA, btnB, btnC;

    ImageView cabeca, tronco;

    int pontos = 0;
    int erros = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        pontos = getIntent().getIntExtra("pontosAtuais", 0);
        erros = getIntent().getIntExtra("errosAtuais", 0);

        btnSair = findViewById(R.id.btnSair);
        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);


        cabeca = findViewById(R.id.cabeca);
        tronco = findViewById(R.id.corpo);

        aplicarErros();

        btnA.setOnClickListener(v -> respostaErrada(btnA));
        btnB.setOnClickListener(v -> respostaErrada(btnB));
        btnC.setOnClickListener(v -> respostaCerta(btnC));

        btnSair.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity3.this, MainActivity.class));
            finish();
        });
    }

    private void aplicarErros() {
        if (erros >= 1) cabeca.setColorFilter(Color.RED);
        if (erros >= 2) tronco.setColorFilter(Color.RED);
    }

    private void respostaCerta(Button botao) {
        botao.setBackgroundColor(Color.GREEN);
        pontos++;

        new Handler().postDelayed(() -> {
            botao.setBackgroundTintList(null);
            Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
            intent.putExtra("pontosAtuais", pontos);
            intent.putExtra("errosAtuais", erros);
            startActivity(intent);
            finish();
        }, 500);
    }

    private void respostaErrada(Button botao) {
        botao.setBackgroundColor(Color.RED);
        erros++;

        if (erros == 1) cabeca.setColorFilter(Color.RED);
        if (erros == 2) tronco.setColorFilter(Color.RED);

        new Handler().postDelayed(() -> {
            botao.setBackgroundTintList(null);
            Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
            intent.putExtra("pontosAtuais", pontos);
            intent.putExtra("errosAtuais", erros);
            startActivity(intent);
            finish();
        }, 500);
    }
}
