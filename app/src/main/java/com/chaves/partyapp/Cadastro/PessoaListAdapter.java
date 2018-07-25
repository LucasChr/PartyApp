package com.chaves.partyapp.Cadastro;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaves.partyapp.R;

import java.util.List;

public class PessoaListAdapter extends ArrayAdapter<Pessoa> {

    private TextView tvNome, tvRg, tvCpf;
    private ImageView imgPessoa;
    private int layout;
    private Context context;
    private List<Pessoa> pessoasList;

    public PessoaListAdapter(Context context, int layout, List<Pessoa> pessoasList) {
        super(context, layout, pessoasList);
        this.context = context;
        this.layout = layout;
        this.pessoasList = pessoasList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(layout, null);

        tvNome = (TextView) itemView.findViewById(R.id.fragment_pessoa_list_item_tvNome);
        tvRg = (TextView) itemView.findViewById(R.id.fragment_pessoa_list_item_tvRg);
        tvCpf = (TextView) itemView.findViewById(R.id.fragment_pessoa_list_item_tvCpf);
        imgPessoa = (ImageView) itemView.findViewById(R.id.fragment_pessoa_list_item_imgPessoa);

        final Pessoa pessoa = pessoasList.get(position);
        tvNome.setText(pessoa.getNome());
        tvRg.setText(pessoa.getRg());
        tvCpf.setText(pessoa.getCpf());

        if (pessoa.getFoto() != null) {
            byte[] bytearray = Base64.decode(pessoa.getFoto(), Base64.DEFAULT);
            Bitmap bmimage = BitmapFactory.decodeByteArray(bytearray, 0, bytearray.length);
            imgPessoa.setImageBitmap(bmimage);
        }
        return itemView;
    }
}
