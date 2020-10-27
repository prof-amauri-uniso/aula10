package com.uniso.lpdm.cafeteria_cap7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CategoriaBebidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_bebida);

        /*O ListView é uma classe que é filha de AdapterView. Por isso podemos utilizar o método que
        * vimos na MainActivity para configurar o listener de clicar em um item. Outro exemplo de
        * uma classe que também é um adapterView é o spinner, que vimos lá no primeiro conteúdo
        * com o app de sugestão de cervejas. Os AdapterVies são elementos que interagem com adaptadores.
        * Para exibir dados em um ListView (ou em outro AdapterView) provenientes de uma fonte
        * que não seja um recurso em strings.xml, como um array em uma classe java ou um banco de dados,
        * será necessário o uso de um adaptador. O adaptador serve como uma ponte entre a fonte
        * de dados e o ListView.
        *
        * Aqui utilizaremos o ArrayAdapter, que é um tipo de adaptador especifico para arrays.
        * Para cada tipo de fonte de dados possiveis um adaptador especifico deve ser utilizado.
        * Como o de arrays é mais simples, vamos utiliza-lo para entender a intereação entre a atividade
        * e o adaptador e depois utilizaremos um adaptador para interagir com fontes de dados de um
        * banco de dados SQLite*/

        /*Para inicializarmos o ArrayAdapter, primeiro espefifique o tipo dee dado que está contido
        * no array a ser vinculado. Também precisamos informar um contexto, que é a atividade atual,
        * um recurso de layout para especificar como cada item do array será exbidido e o array*/
        ArrayAdapter<Bebida> bebidaArrayAdapter = new ArrayAdapter<>(
                this, //contexto
                android.R.layout.simple_list_item_1, // simple_list_item_1 é um recurso de layout definido pela plataforma para itens em uma ListView. Você pode usá-lo em vez de criar o próprio layout para itens de lista.
                Bebida.bebidas //Array que será a fonte de dados
        );

        /*Após criar o adaptador, precisamos associa-lo ao ListView, usando o método
        * setAdapter*/
        ListView listView = findViewById(R.id.lista_bebidas);
        listView.setAdapter(bebidaArrayAdapter);

        /*Após criarmos o adaptador, temos os itens do menu preenchidos. Para isso precisamos
        * novamente utilizar um Ouvinte, que vai funcionar de maneira muito semelhante ao da
        * MainActivity*/
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                /* A atividade que vai efetivamente exibir as informações das bebidas é a
                * atividade BebidaActivity. As informações da bebida estão no vetor constante na
                * classe Bebida, então para que a atividade BebidaActivity saiba qual o elemento
                * deve ser exibido, mandamos junto na intenção o id da linha que foi clicado.
                * Como o ListView foi preenchido utilizando o ArrayAdapter, esse id corresponde
                * ao indice do elemento no vetor que foi passado como configuração na criação
                * do adaptador*/
                Intent intent = new Intent(CategoriaBebidaActivity.this, BebidaActivity.class);
                intent.putExtra(BebidaActivity.EXTRA_BEBIDA_ID, (int) id);
                startActivity(intent);
            }
        };

        listView.setOnItemClickListener(itemClickListener);
    }
}