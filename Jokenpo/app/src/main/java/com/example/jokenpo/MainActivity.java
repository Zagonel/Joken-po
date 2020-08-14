package com.example.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        opcaoSelecionada("Pedra");
    }

    public void selecionadoPapel(View view) {
        opcaoSelecionada("Papel");
    }

    public void selecionadoTesoura(View view) {
        opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String opcaoUser) {
        ImageView imagemResultado = findViewById(R.id.ImagemVazia);

        int numero = new Random().nextInt(3);
        String opcoes[] = {"Pedra", "Papel", "Tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp) {
            case "Pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if (opcaoApp.equals("Tesoura") && opcaoUser.equals("Papel") || opcaoApp.equals("Papel") && opcaoUser.equals("Pedra") || opcaoApp.equals("Pedra") && opcaoUser.equals("Tesoura")) {
            TextView texto = findViewById(R.id.textoPrincipal);
            texto.setText("Você Perdeu :P");

        } else if (opcaoApp.equals("Papel") && opcaoUser.equals("Tesoura") || opcaoApp.equals("Pedra") && opcaoUser.equals("Papel") || opcaoApp.equals("Tesoura") && opcaoUser.equals("Pedra")) {
            TextView texto = findViewById(R.id.textoPrincipal);
            texto.setText("Você Ganhou :D");
        } else {
            TextView texto = findViewById(R.id.textoPrincipal);
            texto.setText("Empatou !!!");
        }
    }
}