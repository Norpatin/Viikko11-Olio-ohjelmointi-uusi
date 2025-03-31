package com.example.testi;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    ImageView imageViewDelete, imageViewChange;
    TextView contactFullName, contactPuhNumber, contactGroup;


    public ContactViewHolder(@NonNull View itemView){
        super(itemView);
        imageViewDelete = itemView.findViewById(R.id.ContactDeleteButton);
        imageViewChange = itemView.findViewById(R.id.ContactDetailsButton);
        contactFullName = itemView.findViewById(R.id.ContactNameText);
        contactPuhNumber = itemView.findViewById(R.id.ContactNumberText);
        contactGroup = itemView.findViewById(R.id.ContactGroupText);
    }


}