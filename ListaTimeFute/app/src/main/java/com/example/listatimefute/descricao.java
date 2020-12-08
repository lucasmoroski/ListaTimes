package com.example.listatimefute;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class descricao extends RecyclerView.Adapter<descricao.MyViewHolder> {

    List<TimesFut> times;

    public descricao(List<TimesFut> times) {
        this.times = times;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nome, cidade;
        ImageView img;

        public MyViewHolder(View view){
            super(view);
            nome = view.findViewById(R.id.textViewNomeCell);
            cidade = view.findViewById(R.id.textViewCidadeCell);
            img = view.findViewById(R.id.imageViewCell);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_time, parent, false);

        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TimesFut obj = times.get(position);
        holder.nome.setText(obj.getNome());
        holder.cidade.setText(obj.getCidadeEstado());
        holder.img.setImageResource(obj.getImg());
    }

    @Override
    public int getItemCount() {
        return times.size();
    }
}