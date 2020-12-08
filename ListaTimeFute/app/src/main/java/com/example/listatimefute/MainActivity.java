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
    public static List<TimesFut> timesFutList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewTimes = findViewById(R.id.recyclerViewTimes);

        this.createTimes();
        descricao adapter = new descricao(timesFutList);

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
        if(timesFutList.size() == 0) {
            String titulos = "Mundial Fifa Interclubes. 2000. 2012. \nLibertadores da América. 2012. \nRecopa Sul-Americana. 2013. \n Campeonato Brasileiro. 1990. 1998. 1999. 2005. 2011. 2015. 2017.";
            TimesFut obj = new TimesFut("Corinthians", "São Paulo-SP", R.drawable.cor, titulos);
            titulos = "Campeonato Brasileiro. 1985. \nCampeonato Brasileiro - Série B 2007, 2010. \nFestival Brasileiro 1997";
            timesFutList.add(obj);
            obj = new TimesFut("Coritiba", "Curitiba-PR", R.drawable.cfc, titulos);
            timesFutList.add(obj);
            titulos = "Campeonato Brasileiro - 1980, 1982, 1983, 1987, 1992, 2009 e 2019 \nCopa do Brasil - 1990, 2006 e 2013. \nLibertadores - 2019 \n Supercopa do Brasil - 2020.";
            obj = new TimesFut("Flamengo", "Rio de Janeiro-RJ", R.drawable.fla, titulos);
            timesFutList.add(obj);
            titulos = "Copa Sul-Americana - 2018 \nCampeonato Brasileiro - 2001 \nCopa do Brasil - 2019";
            obj = new TimesFut("Athletico", "Curitiba-PR", R.drawable.cap, titulos);
            timesFutList.add(obj);
        }
    }
}