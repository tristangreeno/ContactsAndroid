package com.theironyard.contacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ArrayAdapter<String> contacts;

    EditText name;
    EditText number;
    Button addContact;
    ListView listOfContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.Name);
        number = (EditText) findViewById(R.id.Number);
        addContact = (Button) findViewById(R.id.Add);
        listOfContacts = (ListView) findViewById(R.id.listView);

        listOfContacts.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
            int pos, long id) {
                String contact = contacts.getItem(pos);
                contacts.remove(contact);
                return true;
            }
        });


        contacts = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listOfContacts.setAdapter(contacts);
    }

    @Override
    public void onClick(View view) {
        String nameNumber = name.getText().toString() + " (" + number.getText().toString() + ")";
        contacts.add(nameNumber);
        name.setText("");
        number.setText("");
    }
}
