package com.example.forca;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity8 extends AppCompatActivity {

    TextView tvPontos, tvErros;
    Button btnSair;
    int pontos = 0;
    int erros = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        tvPontos = findViewById(R.id.tvPontos);
        tvErros = findViewById(R.id.tvErros);
        btnSair = findViewById(R.id.btnSair);
        pontos = getIntent().getIntExtra("pontosAtuais", 0);
        erros = getIntent().getIntExtra("errosAtuais", 0);

        tvPontos.setText("Pontos: " + pontos);
        tvErros.setText("Erros: " + erros);

        btnSair.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity8.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
