package br.com.digitalhouse.dh_agendaapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    private CircleImageView foto;
    private TextInputLayout nome;
    private TextInputLayout telefone;
    private FloatingActionButton botao1;

    public static final String NOME_KEY = "name";
    public static final String TELEFONE_KEY = "phone";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foto = findViewById(R.id.circleImageView);
        nome = findViewById(R.id.textInputLayout2);
        telefone = findViewById(R.id.textInputLayout3);
        botao1 = findViewById(R.id.floatingActionButton);

        botao1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = nome.getEditText().getText().toString();
                String phone = telefone.getEditText().getText().toString();

                if (!name.isEmpty() && !phone.isEmpty()){
//                    Mandar os dados para outra activity
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);

                    Bundle bundle = new Bundle();

                    bundle.putString(NOME_KEY, name);
                    bundle.putString(TELEFONE_KEY, phone);
                    intent.putExtras(bundle);
                    startActivity(intent);

                } else {
                    nome.setError("Preencha o campo nome");
                    telefone.setError("Preencha o campo telefone");
                }
            }
        });

    }
}
