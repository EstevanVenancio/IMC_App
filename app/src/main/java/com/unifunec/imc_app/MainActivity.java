package com.unifunec.imc_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText peso = findViewById(R.id.edtPeso);
        EditText altura = findViewById(R.id.edtAltura);

        TextView resut = findViewById(R.id.txtResult);
        TextView classificacao = findViewById(R.id.txtClassificacao);

        Button limpar = findViewById(R.id.btnLimpar);
        Button calcular = findViewById(R.id.btnCalcular);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               double ps = Double.parseDouble(peso.getText().toString());
               double alt = Double.parseDouble(altura.getText().toString());


                double rs = (ps/(alt*alt));

                if (rs < 16){
                    resut.setText(String.format("IMC: %.2f", rs));
                    classificacao.setText("MAGREZA GRAU III");
                } else if (rs < 16 && rs <= 16.9){
                    resut.setText(String.format("IMC: %.2f", rs));
                    classificacao.setText("MAGREZA GRAU II");
                } else if (rs < 17 && rs <= 18.4){
                    resut.setText(String.format("IMC: %.2f", rs));
                    classificacao.setText("MAGREZA GRAU I");
                } else if (rs > 18.5 && rs <= 24.9){
                    resut.setText(String.format("IMC: %.2f", rs));
                    classificacao.setText("EUTROFIA");
                } else if (rs >25 && rs <= 29.9){
                    resut.setText(String.format("IMC: %.2f", rs));
                    classificacao.setText("PRÉ-OBESIDADE");
                } else if (rs > 30 && rs <= 34.9){
                    resut.setText(String.format("IMC: %.2f", rs));
                    classificacao.setText("OBESIDADE MODERADA (GRAU I)");
                } else if (rs > 35 && rs <= 39.9){
                    resut.setText(String.format("IMC: %.2f", rs));
                    classificacao.setText("OBESIDADE SEVERA (GRAU II)");
                } else if (rs > 40){
                    resut.setText(String.format("IMC: %.2f", rs));
                    classificacao.setText("OBESIDADE MÓRBIDA (GRAU III)");
                }

                calcular.setEnabled(false);
                limpar.setEnabled(true);
            }
        });

            limpar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    peso.setText("");
                    altura.setText("");
                    resut.setText("");
                    classificacao.setText("");

                    limpar.setEnabled(false);
                    calcular.setEnabled(true);
                }
            });
    }
}