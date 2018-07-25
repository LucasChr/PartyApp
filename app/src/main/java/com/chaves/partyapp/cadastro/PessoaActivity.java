package com.chaves.partyapp.cadastro;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

import com.chaves.partyapp.R;

public class PessoaActivity extends AppCompatActivity{

    private PessoaDao pessoaDao;
    private Pessoa pessoa;
    private EditText etNome, etRg, etCpf;
    private ImageView imgPessoa;
    private Bitmap ivFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pessoa);

        pessoaDao = new PessoaDao(this);
        Intent it = getIntent();

        if (it != null) {
            pessoa = new Pessoa();
            pessoa = pessoaDao.buscar(it.getStringExtra(Pessoa.ID));
        }

        etNome = findViewById(R.id.activity_pessoa_etNome);
        etRg = findViewById(R.id.activity_pessoa_etRg);
        etCpf = findViewById(R.id.activity_pessoa_etCpf);

        etNome.setText(pessoa.getNome());
        etRg.setText(pessoa.getRg());
        etCpf.setText(pessoa.getCpf());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Nome", etNome.getText().toString());
        outState.putString("RG", etRg.getText().toString());
        outState.putString("CPF", etCpf.getText().toString());
        Log.i("bundle", "save");
    }

    @Override
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        etNome.setText(bundle.getString("Nome"));
        etRg.setText(bundle.getString("RG"));
        etCpf.setText(bundle.getString("CPF"));
        Log.i("bundle", "restore");
    }

}

