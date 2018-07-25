package com.chaves.partyapp.Cadastro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.chaves.partyapp.R;

import java.util.List;

public class PessoasListFragment extends Fragment implements AdapterView.OnItemClickListener{

    private List<Pessoa> pessoas;
    private PessoaListAdapter adapter;
    private PessoaDao pessoaDAO;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pessoas_list, container, false);

        ListView listView = (ListView) view.findViewById(R.id.fragment_pessoas_list_listview);
        listView.setEmptyView(view.findViewById(android.R.id.empty));
        listView.setOnItemClickListener(this);

        pessoaDAO = new PessoaDao(getActivity());
        pessoas = pessoaDAO.listar();

        adapter = new PessoaListAdapter(getActivity(), R.layout.fragment_pessoas_list_item, pessoas);

        listView.setAdapter(adapter);

        PessoaDao pessoaDao = new PessoaDao(getActivity());
        pessoas = pessoaDao.listar();

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Pessoa pessoa = pessoas.get(position);
        Intent it = new Intent(getActivity(), PessoaActivity.class);
        String id1 = String.valueOf(pessoa.getId());
        it.putExtra(Pessoa.ID, id1);
        startActivityForResult(it, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        atualizaLista();
        if (resultCode == 1) {
            Toast.makeText(getActivity(), "Salvo com sucesso", Toast.LENGTH_LONG).show();
        } else if (resultCode == 2) {
            Toast.makeText(getActivity(), "Modificado com sucesso", Toast.LENGTH_LONG).show();
        } else if (resultCode == 3) {
            Toast.makeText(getActivity(), "Excluído com sucesso", Toast.LENGTH_LONG).show();
        }
    }

    public void atualizaLista() {
        List<Pessoa> cs = pessoaDAO.listar();
        adapter.clear();
        adapter.addAll(cs);
        adapter.notifyDataSetChanged();
    }
}
