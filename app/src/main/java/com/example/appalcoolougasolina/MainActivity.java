package com.example.appalcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGaolina;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeItems();
    }

    public void initializeItems(){
        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGaolina = findViewById(R.id.editPrecoGasolina);
        textResult = findViewById(R.id.textResul);
    }

    public void calcularPreco(View view){

        //Calcular Preço da gasolina
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGaolina.getText().toString();

        Boolean resultado = validarCampos(precoAlcool, precoGasolina);

        if(resultado){

            //Converter String para números!
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            //Fazer cálculo saber menor preço
            Double cal = valorAlcool / valorGasolina;
            if(cal >= 0.7){
                textResult.setText("Gasolina é a sua melhor opção!");
            }else{
                textResult.setText("Àlcool é a sua melhor opção!");
            }

        }else{
            textResult.setText("Preença os preços primeiro!");
        }
    }

    public boolean validarCampos(String pAlcool, String pGasolina){

        if(pAlcool.equals("") || pAlcool == null){
            Toast.makeText(this, "Preencha o campo Àlcool", Toast.LENGTH_SHORT).show();
            return false;

        }else if(pGasolina.equals("") || pGasolina == null) {
            Toast.makeText(this, "Preencha o campo Gasolina", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
