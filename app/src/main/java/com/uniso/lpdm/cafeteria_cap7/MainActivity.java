package com.uniso.lpdm.cafeteria_cap7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Para que os itens de um listview respondam a cliques, você deve implementar
        * um ouvinte de eventos.
        * O ouvinte de eventos captura os eventos que ocorrem no app, como cliques nos
        * views, saída e entradas no primeiro plano e teclas pressionadas no hardware
        * do dispositivo. Ao implementar um ouvinte de eventos, você pode definir o
        * momento em que um usuário executa uma determinada ação (quando ele clica
        * em um item em um list vire, por exemplo e definir uma resposta correspondente.*/

        /*Para que os itens em um list view respondam a cliques, você precisa criar um
        OnItemClickListener e implementar seu método onItemClick(). O OnItemClickListener
        ouve os eventuais cliques nos itens e o método onItemClick() define como a atividade
        deve responder a um clique. O método onItemClick() dispõe de vários parametros para
        definir o item clicado, como a referencia do item do view em questão, sua posição no
        list view a id da linha dos dados subjacentes.

        Para compreendermos melhor quando podemos usar os métodos e classes de ADapterView, podemos
        consutar a documentação do android: https://developer.android.com/reference/android/widget/AdapterView */

        /*OnItemClickListener é uma classe aninhada da classe AdapterView. O ListView é uma subclasse
        * de AdapterView.*/
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, //Este é o view clicado, no caso, o list view
                                    View view, // O view que foi clicado, o elemento clicado
                                    int posicao, // a posicao no listview, começando em 0
                                    long id) { // o id da linha

                /*Como bebidas é o primeiro elemento, então abrimos a acitvidade com as bebidas. As demais
                * seriam a categoria de opções de comida e de lojas*/
                if(posicao == 0){
                    /*Simplesmente criamos a intenção para iniciar a proxima atividade*/
                    Intent intent = new Intent(MainActivity.this, CategoriaBebidaActivity.class);
                    startActivity(intent);
                }
            }
        };

        /*Depois de criado o ouvinte, precisamos associa-lo com o ListView. Recuperamos ele e utilizamos
        * o método setOnClickListener() passando como parametro o ouvinte que criamos*/
        ListView listview = (ListView) findViewById(R.id.lista_opcoes);
        listview.setOnItemClickListener(itemClickListener);
    }


}