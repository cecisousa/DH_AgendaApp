package br.com.digitalhouse.dh_agendaapp;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private static final String NOME_KEY = ;
    private static final String TELEFONE_KEY = ;
    private TextInputLayout texto1;
    private TextInputLayout texto2;
    private Button botao2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        texto1 = findViewById(R.id.textInputLayout);
        texto2 = findViewById(R.id.textInputLayout2);
        botao2 = findViewById(R.id.button);

        Intent intent = getIntent();

        if(getIntent() != null && intent.getExtras() != null){
            Bundle bundle = intent.getExtras();
            String name = bundle.getString(NOME_KEY);
            String phone = bundle.getString(TELEFONE_KEY);

            texto1.setText(name);
            texto2.setText(phone);

        } else {
            Snackbar.make(texto1, "Não há dados!", Snackbar.LENGTH_LONG).show();
        }

        botao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
            }
        });

    }
}
