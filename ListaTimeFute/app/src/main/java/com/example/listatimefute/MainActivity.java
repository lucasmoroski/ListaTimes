package com.example.listatimefute;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    
    private RecyclerView recyclerViewTimes;
    public static List<TimesFut> times = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewTimes = findViewById(R.id.recyclerViewTimes);

        this.createTimes();
        descricao adapter = new descricao(times);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewTimes.setLayoutManager(layoutManager);

        recyclerViewTimes.setHasFixedSize(true);

        recyclerViewTimes.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));

        recyclerViewTimes.setAdapter(adapter);

        recyclerViewTimes.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerViewTimes,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                android.content.Intent it = new Intent(MainActivity.this, Intent.class);
                                Bundle params =new Bundle();
                                params.putInt("time", position);
                                it.putExtras(params);
                                startActivity(it);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );

    }

    private void createTimes(){
        if(times.size() == 0) {
            String titulos = "Campeonato Catarinense(2013) \nCampeonato Brasileiro Série C(2006) \nCampeonato Catarinense(2005)";
            TimesFut obj = new TimesFut("Criciúma", "Criciúma-SC", R.drawable.cor, titulos);
            titulos = "Campeonato Brasileiro(2008) \nCampeonato Brasileiro (2007) \nMundial(2005)";
            times.add(obj);
            obj = new TimesFut("São Paulo", "São Paulo-SP", R.drawable.fla, titulos);
            times.add(obj);
            titulos = "Campeonato Carioca(2020) \nCampeonato Brasileiro (2019) \nLibertadores(2019)";
            obj = new TimesFut("Flamengo", "Rio de Janeiro-RJ", R.drawable.cfc, titulos);
            times.add(obj);
            titulos = "Campeonato Mineiro(2019) \nCampeonato Mineiro (2018) \nCopa do Brasil(2018)";
            obj = new TimesFut("Cruzeiro", "Belo Horizonte-MG", R.drawable.cap, titulos);
            times.add(obj);
        }
    }
}