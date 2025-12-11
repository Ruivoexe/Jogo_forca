package com.example.forca;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {

    Button btnSair, btnA, btnB, btnC;
    ImageView cabeca, corpo, braco_esq, braco_dir, perna_esq, perna_dir;

    int pontos = 0;
    int erros = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        pontos = getIntent().getIntExtra("pontosAtuais", 0);
        erros = getIntent().getIntExtra("errosAtuais", 0);


        btnSair = findViewById(R.id.btnSair);
        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);

        btnSair.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity5.this, MainActivity.class);
            startActivity(intent);
            finish();
        });


        cabeca = findViewById(R.id.cabeca);
        corpo = findViewById(R.id.corpo);
        braco_esq = findViewById(R.id.braco_esq);
        braco_dir = findViewById(R.id.braco_dir);
        perna_esq = findViewById(R.id.perna_esq);
        perna_dir = findViewById(R.id.perna_dir);


        atualizarBoneco();

        btnA.setOnClickListener(v -> respostaErrada(btnA));
        btnB.setOnClickListener(v -> respostaErrada(btnB));
        btnC.setOnClickListener(v -> respostaCerta(btnC));
    }

    private void respostaCerta(Button botao) {
        botao.setBackgroundColor(Color.GREEN);
        pontos++;

        new Handler().postDelayed(() -> {
            botao.setBackgroundColor(Color.TRANSPARENT);
            irParaProximaTela();
        }, 500);
    }

    private void respostaErrada(Button botao) {
        botao.setBackgroundColor(Color.RED);
        erros++;


        if (erros == 4) {
            braco_dir.setColorFilter(Color.RED);
        }

        new Handler().postDelayed(() -> {
            botao.setBackgroundColor(Color.TRANSPARENT);
            irParaProximaTela();
        }, 500);
    }

    private void irParaProximaTela() {
        Intent intent = new Intent(MainActivity5.this, MainActivity6.class);
        intent.putExtra("pontosAtuais", pontos);
        intent.putExtra("errosAtuais", erros);
        startActivity(intent);
        finish();
    }

    private void atualizarBoneco() {
        if (erros >= 1) cabeca.setColorFilter(Color.RED);
        if (erros >= 2) corpo.setColorFilter(Color.RED);
        if (erros >= 3) braco_esq.setColorFilter(Color.RED);
        if (erros >= 4) braco_dir.setColorFilter(Color.RED);
        if (erros >= 5) perna_esq.setColorFilter(Color.RED);
        if (erros >= 6) perna_dir.setColorFilter(Color.RED);
    }
}
