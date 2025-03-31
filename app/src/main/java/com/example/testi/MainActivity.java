package com.example.testi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    private ContactStorage contactStorage;
    private RecyclerView recyclerView;
    private ContactListAdapter contactListAdapter;
    ArrayList<String> workOrPersonal = new ArrayList<>();


    //private ArrayList<String> firstNamesList = new ArrayList<>();;
    //private ContactListAdapter adapter; //LISÄTTY

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.ListContactsRV);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        contactListAdapter = new ContactListAdapter(getApplicationContext(), ContactStorage.getInstance().getContacts());
        recyclerView.setAdapter(contactListAdapter);



    }

    public void SwitchToAddContactActivity(View view){
        Intent intent = new Intent(this, AddContactActivity.class);
        startActivity(intent);
    }

    public void SortByFirsNameLetter(View view){
        //for(Contact names : ContactStorage.getInstance().getContacts()){
        //    firstNamesList.add(names.getFirstName());
        //}
        Collections.sort(ContactStorage.getInstance().getContacts(), new Comparator<Contact>() {
            @Override
            public int compare(Contact contact1, Contact contact2) {
                return contact1.getFirstName().compareTo(contact2.getFirstName());
            }
        });


        contactListAdapter.notifyDataSetChanged();
    }

    public void SortByGroup(View view){
        ArrayList<Contact> work = new ArrayList<>();
        ArrayList<Contact> personal = new ArrayList<>();

        work.clear();
        personal.clear();

        Iterator<Contact> iterator = ContactStorage.getInstance().getContacts().iterator();
        while(iterator.hasNext()){
            Contact group = iterator.next();
            if(group.getContactGroup().equals("Työt")){
                work.add(group);
            }
            else{
                personal.add(group);
            }
        }

        ContactStorage.getInstance().getContacts().clear();
        ContactStorage.getInstance().getContacts().addAll(work);
        ContactStorage.getInstance().getContacts().addAll(personal);
        contactListAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        contactListAdapter.notifyDataSetChanged();
    }
}