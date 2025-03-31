package com.example.testi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactListAdapter  extends RecyclerView.Adapter<ContactViewHolder> {
    private Context context;
    private ArrayList<Contact> contacts = new ArrayList<>();


    public ContactListAdapter(Context context, ArrayList<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContactViewHolder(LayoutInflater.from(context).inflate(R.layout.contact_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.contactFullName.setText(contacts.get(position).getFullName());
        holder.contactPuhNumber.setText(contacts.get(position).getNumber());
        holder.contactGroup.setText(contacts.get(position).getContactGroup());

        holder.imageViewDelete.setImageResource(R.drawable.delete);
        holder.imageViewChange.setImageResource(R.drawable.showhide);

        holder.imageViewDelete.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            ContactStorage.getInstance().removeContact(contacts.get(pos).getId());
            notifyItemRemoved(pos);
        });

        /*holder.imageViewChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();

                if(holder.contactFullName.getVisibility() == View.VISIBLE) {
                    Contact contact = ContactStorage.getInstance().getContactByIdWithoutRemove(pos);
                    //rocket.setId(holder..getText().toString());
                    //holder.editName.setVisibility(View.GONE);
                    notifyDataSetChanged();
                }
                else {
                    //holder.editName.setVisibility(View.VISIBLE);
                }

            }/**/
        };

    /*public void setContacts(ArrayList<Contact> newContacts) {
        this.contacts = newContacts;
        notifyDataSetChanged();
    }/**/


    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
