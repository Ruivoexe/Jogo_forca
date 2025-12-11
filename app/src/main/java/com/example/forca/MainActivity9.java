package com.example.forca;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity9 extends AppCompatActivity {

    ListView listRanking;
    Button btnMenu;
    SharedPreferences sharedPreferences;
    ArrayList<String> ranking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        listRanking = findViewById(R.id.listRanking);
        btnMenu = findViewById(R.id.btnMenu);

        sharedPreferences = getSharedPreferences("Ranking", Context.MODE_PRIVATE);
        ranking = new ArrayList<>();

        carregarRanking();
        mostrarRanking();

        btnMenu.setOnClickListener(v -> {
            finish();
        });
    }

    private void carregarRanking() {
        ranking.clear();
        for (int i = 0; i < 5; i++) {
            String item = sharedPreferences.getString("ranking_" + i, null);
            if (item != null) ranking.add(item);
        }
    }

    private void mostrarRanking() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, ranking);
        listRanking.setAdapter(adapter);
    }
}
