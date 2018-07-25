package com.chaves.partyapp.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by lucas on 25/07/18.
 */

public class BancoPessoas {

    private static final String NOME_BANCO = "pessoas";
    private static final int VERSAO_BANCO = 1;

    private static final String[] SCRIPT_DATABASE_DELETE = new String[]{"DROP TABLE IF EXISTS pessoas;"};


    private static final String[] SCRIPT_DATABASE_CREATE = new String[]{
            "create table pessoas(_id integer primary key, p_nome text, p_rg text, p_cpf text, p_foto text)"};

    private static SQLiteDatabase db;

    public static SQLiteDatabase getDB(Context ctx) {
        if (db == null) {
            SQLiteHelper dbHelper = new SQLiteHelper(ctx, NOME_BANCO, VERSAO_BANCO, SCRIPT_DATABASE_CREATE, SCRIPT_DATABASE_DELETE);
            db = dbHelper.getWritableDatabase();
        }
        return db;
    }

}
