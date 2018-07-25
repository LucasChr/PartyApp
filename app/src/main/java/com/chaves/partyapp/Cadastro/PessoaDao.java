package com.chaves.partyapp.Cadastro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.chaves.partyapp.sqlite.BancoPessoas;

import java.util.ArrayList;
import java.util.List;

public class PessoaDao {

    SQLiteDatabase db;

    public PessoaDao(Context context) {
        db = BancoPessoas.getDB(context);
    }

    public void salvar(Pessoa pessoa) {
        ContentValues values = new ContentValues();
        values.put(Pessoa.NOME, pessoa.getNome());
        values.put(Pessoa.RG, pessoa.getRg());
        values.put(Pessoa.CPF, pessoa.getCpf());
        values.put(Pessoa.FOTO, pessoa.getFoto());
        db.insert(Pessoa.TABELA, null, values);
    }

    public void alterar(Pessoa pessoa) {
        ContentValues values = new ContentValues();
        values.put(Pessoa.NOME, pessoa.getNome());
        values.put(Pessoa.RG, pessoa.getRg());
        values.put(Pessoa.CPF, pessoa.getCpf());
        values.put(Pessoa.FOTO, pessoa.getFoto());
        String id = String.valueOf(pessoa.getId());

        String[] whereArgs = new String[]{id};
        db.update(Pessoa.TABELA, values, Pessoa.ID + " = ?", whereArgs);
    }

    public Pessoa buscar(String id) {

        String[] colunas = Pessoa.COLUNAS;
        String[] whereArgs = new String[]{id};

        Cursor c = db.query(Pessoa.TABELA, colunas, Pessoa.ID + " = ?", whereArgs, null, null, null);

        c.moveToFirst();

        Pessoa pessoa = new Pessoa();
        pessoa.setId(c.getLong(c.getColumnIndex(Pessoa.ID)));
        pessoa.setNome(c.getString(c.getColumnIndex(Pessoa.NOME)));
        pessoa.setRg(c.getInt(c.getColumnIndex(Pessoa.RG)));
        pessoa.setCpf(c.getInt(c.getColumnIndex(Pessoa.CPF)));
        pessoa.setFoto(c.getString(c.getColumnIndex(Pessoa.FOTO)));

        return pessoa;
    }

    public List<Pessoa> listar() {

        String[] colunas = Pessoa.COLUNAS;
        Cursor c = db.query(Pessoa.TABELA, colunas, null, null, null, null, null);

        List<Pessoa> pessoasList = new ArrayList<>();
        if (c.moveToFirst()) {
            do {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(c.getLong(c.getColumnIndex(Pessoa.ID)));
                pessoa.setNome(c.getString(c.getColumnIndex(Pessoa.NOME)));
                pessoa.setRg(c.getInt(c.getColumnIndex(Pessoa.RG)));
                pessoa.setCpf(c.getInt(c.getColumnIndex(Pessoa.CPF)));
                pessoa.setFoto(c.getString(c.getColumnIndex(Pessoa.FOTO)));

                pessoasList.add(pessoa);

                Log.i("lista", pessoa.getNome());
            } while (c.moveToNext());
        }
        return pessoasList;
    }

    public void excluir(String id) {
        String[] whereArgs = new String[]{id};
        db.delete(Pessoa.TABELA, Pessoa.ID + " = ?", whereArgs);
    }

}
