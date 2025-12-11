package com.example.forca;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity8 extends AppCompatActivity {

    TextView tvPontos, tvErros;
    Button btnRanking, btnSair;
    int pontos = 0;
    int erros = 0;
    String nome;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        tvPontos = findViewById(R.id.tvPontos);
        tvErros = findViewById(R.id.tvErros);
        btnRanking = findViewById(R.id.btnRanking);
        btnSair = findViewById(R.id.btnSair);

        pontos = getIntent().getIntExtra("pontosAtuais", 0);
        erros = getIntent().getIntExtra("errosAtuais", 0);

        tvPontos.setText("Acertos: " + pontos);
        tvErros.setText("Erros: " + erros);

        sharedPreferences = getSharedPreferences("Ranking", MODE_PRIVATE);

        btnRanking.setOnClickListener(v -> solicitarNome());
        btnSair.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity8.this, MainActivity.class));
            finish();
        });
    }

    private void solicitarNome() {
        final EditText input = new EditText(this);
        input.setHint("Digite seu nome");

        new AlertDialog.Builder(this)
                .setTitle("Fim de Jogo")
                .setMessage("Informe seu nome para salvar no ranking:")
                .setView(input)
                .setCancelable(false)
                .setPositiveButton("Salvar", (dialog, which) -> {
                    nome = input.getText().toString().trim();
                    if (nome.isEmpty()) nome = "Jogador";
                    salvarRanking();
                    abrirRanking();
                })
                .show();
    }

    private void salvarRanking() {

        String[] ranking = new String[5];
        for (int i = 0; i < 5; i++) {
            ranking[i] = sharedPreferences.getString("ranking_" + i, null);
        }

        String novo = nome + " - Acertos: " + pontos + " - Erros: " + erros;

        java.util.ArrayList<String> lista = new java.util.ArrayList<>();
        for (String s : ranking) if (s != null) lista.add(s);
        lista.add(novo);


        java.util.Collections.sort(lista, (a, b) -> {
            int pa = Integer.parseInt(a.split(" - ")[1].split(": ")[1]);
            int pb = Integer.parseInt(b.split(" - ")[1].split(": ")[1]);
            return Integer.compare(pb, pa);
        });

        SharedPreferences.Editor editor = sharedPreferences.edit();
        for (int i = 0; i < 5 && i < lista.size(); i++) {
            editor.putString("ranking_" + i, lista.get(i));
        }
        editor.apply();
    }

    private void abrirRanking() {
        Intent intent = new Intent(MainActivity8.this, MainActivity9.class);
        startActivity(intent);
        finish();
    }
}
