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

public class MainActivity3 extends AppCompatActivity {

    Button btnSair, btnA, btnB, btnC;
    ImageView corpo;
    int pontos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);
        pontos = getIntent().getIntExtra("pontosAtuais",0);

        btnSair = findViewById(R.id.btnSair);
        btnSair.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity3.this,MainActivity.class);

            startActivity(intent);
            finish();
        });

        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        corpo = findViewById(R.id.corpo);

        btnA.setOnClickListener(v -> respostaErrada(btnA));
        btnB.setOnClickListener(v -> respostaCerta(btnB));
        btnC.setOnClickListener(v -> respostaErrada(btnC));

    }

    private void respostaCerta(Button botao)
    {
        botao.setBackgroundColor(Color.GREEN);
        pontos++;
        new Handler().postDelayed(()->{
            botao.setBackgroundColor(Color.TRANSPARENT);
            Intent intent = new Intent(MainActivity3.this,MainActivity4.class);
            intent.putExtra("pontosAtuais",pontos);
            startActivity(intent);
            finish();
        },500);
    }

    private void respostaErrada(Button botao) {
        botao.setBackgroundColor(Color.RED);
        corpo.setColorFilter(Color.RED);

        new Handler().postDelayed(()->{
            botao.setBackgroundColor(Color.TRANSPARENT);
            Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
            intent.putExtra("pontosAtuais",pontos);
            startActivity(intent);
            finish();
        },500);
    }


}