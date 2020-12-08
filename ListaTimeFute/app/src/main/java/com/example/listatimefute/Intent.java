package com.example.listatimefute;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Intent extends AppCompatActivity {

    TextView textViewNome, textViewCidade, textViewTitulos;
    ImageView imgView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao);
        textViewNome = findViewById(R.id.textViewNome);
        textViewCidade = findViewById(R.id.textViewCidade);
        imgView = findViewById(R.id.imageView);
        textViewTitulos = findViewById(R.id.textViewTitulos);

        android.content.Intent it = getIntent();
        if(it!=null){
            Bundle params = it.getExtras();
            if(params!=null){
                int pos = params.getInt("time");
                TimesFut time = MainActivity.times.get(pos);
                textViewNome.setText(time.getNome());
                textViewCidade.setText(time.getCidadeEstado());
                imgView.setImageResource(time.getImg());
                textViewTitulos.setText(time.getTitulos());
            }
        }
    }
}
