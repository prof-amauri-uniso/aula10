package com.uniso.lpdm.cafeteria_cap7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BebidaActivity extends AppCompatActivity {

    public static final String EXTRA_BEBIDA_ID = "bebida_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebida);

        int id_bebida = (Integer) getIntent().getExtras().get(EXTRA_BEBIDA_ID);
        Bebida bebida = Bebida.bebidas[id_bebida];

        TextView nome = (TextView) findViewById(R.id.nome);
        nome.setText(bebida.getNome());

        TextView descricao = (TextView) findViewById(R.id.descricao);
        descricao.setText(bebida.getDescricao());

        /*Para cofigurarmos a imagem que será exibida dinamicamente, utilizamos
        * o método setImageResource. Para fins de acessibilidade, também é uma
        * boa prática configurar o ContentDescription, com o método setContentDescription.
        * Ambas as informações são obtidas da fonte de dados, que nesse momento é nossa
        * classe auxiliar Bebida*/
        ImageView foto = (ImageView) findViewById(R.id.foto);
        foto.setImageResource(bebida.getImagem());
        foto.setContentDescription(bebida.getNome());
    }
}