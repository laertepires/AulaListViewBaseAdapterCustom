package thiagocury.eti.br.aulalistviewbaseadaptercustom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Tela1 extends AppCompatActivity {

    //Widgets
    private EditText etNome;
    private EditText etSexo;
    private EditText etIdade;
    private ListView lvPessoas;
    private Button btnOK;
    //Objeto
    private Pessoa p;
    //Array + Adapters
    private ArrayList<Pessoa> pessoas;
    private PessoaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);
        //Referencias
        etNome = (EditText) findViewById(R.id.t1_et_nome);
        etIdade = (EditText) findViewById(R.id.t1_et_idade);
        etSexo = (EditText) findViewById(R.id.t1_et_sexo);
        lvPessoas = (ListView) findViewById(R.id.t1_lv_pessoas);
        btnOK = (Button) findViewById(R.id.t1_btn_ok);
        //Adapter + Array
        pessoas = new ArrayList<>();
        adapter = new PessoaAdapter(Tela1.this,pessoas);
        lvPessoas.setAdapter(adapter);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p = new Pessoa();
                p.setNome(etNome.getText().toString());
                p.setSexo(etSexo.getText().toString());
                p.setIdade(
                        Integer.parseInt(
                                etIdade.getText().toString()));
                pessoas.add(p);
                adapter.notifyDataSetChanged();
                Toast.makeText(getBaseContext(),
                        "Cadastro OK",Toast.LENGTH_LONG).show();
            }
        });
    }//fecha onCreate
}//fecha classe
