package com.juniorrodrigues.recycleview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.juniorrodrigues.recycleview.R;
import com.juniorrodrigues.recycleview.model.FilmesModel;

import java.util.List;

//repassa um View Holder - Como fixaos um tanho fixo para a RV, o View Holder apos execer esse tamanho fixo, recicla a linha
// trocando somente as informaçoes no layout(texto, imagem, etc.) sem a necessidade de criar e renderiar um novo componente.
public class MeuAdapter extends RecyclerView.Adapter<MeuAdapter.MinhaHolder>{

    private List<FilmesModel> listaFilmes;

    public MeuAdapter(List<FilmesModel> listaFilmes) {
        this.listaFilmes = listaFilmes;
    }

    public List<FilmesModel> getListaFilmes() {
        return listaFilmes;
    }

    public void setListaFilmes(List<FilmesModel> listaFilmes) {
        this.listaFilmes = listaFilmes;
    }

    //Cria as visualizaçoes da lista
    //é necessario criar um layout XML com a visualização que queremos exibir linha a linha.
    //pasta RES -> layout -> cria o arquivo
    @NonNull
    @Override
    public MinhaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //convertendo meu novo layout "meu_adapter_lista.xml" em um objeto tipo View
        View itemLista = LayoutInflater.from(parent.getContext()) //recupera o contexto da activiti onde o componente será criado
                .inflate(R.layout.meu_adapter_lista, parent, false);//repasso o layout, o context que pegamos e um boolean
        return new MinhaHolder(itemLista); //retorno uma nova instancia View Holder, repassando o layout criado
    }

    @Override
    public void onBindViewHolder(@NonNull MinhaHolder holder, int position) {
        //exibe os item apos su criação
        FilmesModel filme = listaFilmes.get(position);
        holder.txtTitle.setText(filme.getTitle());
        holder.txtGerero.setText(filme.getGenero());
        holder.txtYear.setText(filme.getYear());

    }

    @Override
    public int getItemCount() {
        //retorna a quantidade de itens que devem ser exibidos
        return listaFilmes.size();
    }

    //criando minha classe VH
    public class MinhaHolder extends RecyclerView.ViewHolder{

        //Componentes do layout
        TextView txtTitle;
        TextView txtGerero;
        TextView txtYear;

        public MinhaHolder(@NonNull View itemView) {
            super(itemView);

            //recuperamos os componentes do layout passado

            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtYear = itemView.findViewById(R.id.txtYear);
            txtGerero = itemView.findViewById(R.id.txtGenero);
        }
    }

}
