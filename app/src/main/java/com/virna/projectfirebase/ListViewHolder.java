package com.virna.projectfirebase;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListViewHolder extends RecyclerView.ViewHolder {
    public TextView titleList, notesList;
    public ListViewHolder(@NonNull View itemView){
        super(itemView);
        titleList = itemView.findViewById(R.id.titleList);
        notesList = itemView.findViewById(R.id.notesList);
    }
}
