package com.example.databaseexamplecontact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listContactView;
    EditText edtName;
    TextView tvwId;
    Button btnAdd, btnRemove,btnCancel;
    ConstraintLayout constraintLayout;
    DatabaseHandler db;
    List<Contact> contacts;
    int pos =-1;
    ContactAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        init();

        /*db.addContact(new Contact("Ravi", "9100000000"));
        db.addContact(new Contact("Srinivas", "9199999999"));
        db.addContact(new Contact("Tommy", "9522222222"));
        db.addContact(new Contact("Karthik", "9533333333"));*/

        contacts = db.getAllContacts();
        adapter = new ContactAdapter(this,R.layout.contact_layout, contacts);
        listContactView.setAdapter(adapter);

        listContactView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pos = i;
         }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.addContact(new Contact(edtName.getText().toString(), "9199999999"));
                adapter.notifyDataSetChanged();
                refresh();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pos !=-1) {
                    Contact contact = contacts.get(pos);
                    db.deleteContact(contact);
                    contacts.remove(pos);
                    adapter.notifyDataSetChanged();
                }else {
                       Toast.makeText(MainActivity.this, "Chọn liên lạc muốn xoá", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }

    private void init() {
        db = new DatabaseHandler(this);
        edtName = (EditText) findViewById(R.id.edtName);
        listContactView = (ListView) findViewById(R.id.idlvwName);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnRemove = (Button) findViewById(R.id.btnRemove);
        constraintLayout = (ConstraintLayout) listContactView.findViewById(R.id.idConstrantLayout);
    }

    void refresh(){
        contacts = db.getAllContacts();
        adapter = new ContactAdapter(this,R.layout.contact_layout, contacts);
        listContactView.setAdapter(adapter);
    }
}