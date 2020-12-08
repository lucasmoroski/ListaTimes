package com.example.listatimefute;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Intent extends AppCompatActivity {

    TextView textNome, textCidade, textTitulos;
    ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao);
        img = findViewById(R.id.imageView);
        textNome = findViewById(R.id.textViewNome);
        textCidade = findViewById(R.id.textViewCidade);
        textTitulos = findViewById(R.id.textViewTitulos);

        android.content.Intent it = getIntent();
        if(it!=null){
            Bundle params = it.getExtras();
            if(params!=null){
                int pos = params.getInt("TimesF");
                TimesFut TimesF = MainActivity.timesFutList.get(pos);
                img.setImageResource(TimesF.getImg());
                textNome.setText(TimesF.getNome());
                textCidade.setText(TimesF.getCidadeEstado());
                textTitulos.setText(TimesF.getTitulos());
            }
        }
    }
}
