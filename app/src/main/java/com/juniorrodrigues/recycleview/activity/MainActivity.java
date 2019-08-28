package com.juniorrodrigues.recycleview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.juniorrodrigues.recycleview.R;
import com.juniorrodrigues.recycleview.adapter.MeuAdapter;
import com.juniorrodrigues.recycleview.model.FilmesModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvList;
    //lista de filmes
    private List<FilmesModel> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvList = findViewById(R.id.rvList);

        //*Crinado um mock de itens para passar para alista*
        this.populaFilmesList();

        //configurando adpter - Adapter retornar o layout de cada item que é necessario exibir, linh a linha, cada item pode ter um diferente
        MeuAdapter adapter = new MeuAdapter(listaFilmes);

        //Configurando recyclerView
        //passo 1 - criando um layout manager instanciando o layout de lista que queira
        rvList.setLayoutManager(new LinearLayoutManager(getApplicationContext())); //repassando o contexto para o layout
        rvList.setHasFixedSize(true); //otimiza a lista, ja que não precisamos de itens de tamanhos dinamicos.
        //configurando divisor de itens na lista
        rvList.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        //repassando o adapter
        rvList.setAdapter(adapter);
    }

    //popula a lista de filmes
    public void populaFilmesList(){
        for(int i=0; i <10; i++){
            FilmesModel filme = new FilmesModel("Titulo "+i, "Genero "+i, "201"+i);
            this.listaFilmes.add(filme);
        }
    }
}
