package com.virna.projectfirebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListViewHolder extends RecyclerView.Adapter<ListViewHolder.MyViewHolder> {
//    public TextView titleList, notesList;
//    public ListViewHolder(@NonNull View itemView){
//        super(itemView);
//        titleList = itemView.findViewById(R.id.titleList);
//        notesList = itemView.findViewById(R.id.notesList);
//    }

    Context context;
    ArrayList<Title> list;

    public ListViewHolder(Context context, ArrayList<Title> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Title title = list.get(position);
        holder.titleList.setText(title.getTitle());
        holder.notesList.setText(title.getNotes());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titleList, notesList;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleList = itemView.findViewById(R.id.titleList);
            notesList = itemView.findViewById(R.id.notesList);
        }
    }
}
