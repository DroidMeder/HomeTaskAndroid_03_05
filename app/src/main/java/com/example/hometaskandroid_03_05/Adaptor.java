package com.example.hometaskandroid_03_05;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.hometaskandroid_03_05.world.World;
import java.util.ArrayList;
import java.util.List;

public class Adaptor extends RecyclerView.Adapter<Adaptor.CustomViewHolder> {
    private final List<World> list;
    private final OnClick onClick;

    public Adaptor(List<World> list, OnClick onClick) {
        this.list = list;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.bind(list.get(position));
        holder.itemView.setOnClickListener(v -> onClick.onClick(list.get(position)));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected static class CustomViewHolder extends RecyclerView.ViewHolder{
        private final TextView text;
        private final ImageView image;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.textView);
            image=itemView.findViewById(R.id.imageView);
        }

        public void bind(World world) {
            text.setText(world.getName());
            image.setImageResource(world.getFlags());
        }
    }
}
