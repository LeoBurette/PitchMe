package com.example.pitchme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View.OnClickListener;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerListAdaptater extends RecyclerView.Adapter<RecyclerListAdaptater.MyViewHolder> {
    private List<String> list;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public RecyclerListAdaptater(Context context , List<String> list){
        this.list = list;
        mInflater = LayoutInflater.from(context);
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.player_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String txt = list.get(position);
        holder.name.setText(txt);
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    public String getName(int position){
        return this.list.get(position);
    }

    void setClickListener(ItemClickListener itemClickListener){
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
