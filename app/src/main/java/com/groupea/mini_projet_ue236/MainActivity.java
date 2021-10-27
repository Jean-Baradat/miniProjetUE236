package com.groupea.mini_projet_ue236;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements Serializable {


    private ListView listView;
    private ArrayList<Contact> listeDesContacts;
    private ArrayList<Contact> listeDesContactsSelectionnes;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listView = findViewById(R.id.listView);

        this.listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        this.listView.setOnItemClickListener((parent, view, position, id) -> {

            CheckedTextView v = (CheckedTextView) view;
            boolean currentCheck = v.isChecked();
            Contact contact = (Contact) listView.getItemAtPosition(position);
            contact.setActive(!currentCheck);
        });

        this.initListViewData();
    }

    private void initListViewData() {

        Contact Jean = new Contact("Jean Baradat", "0033601030507", false);
        Contact Lucie = new Contact ("Lucie Dumas", "0033600000000", false);
        Contact Salome = new Contact ("Salomé Cliquennois", "0033601030507", false);
        Contact Henri = new Contact ("Henri Michaud", "0033601020304", false);
        Contact Valentine = new Contact ("Valentine Maillard", "0033601020304", false);
        Contact Adelaide = new Contact ("Adélaïde Machon", "0033601020304", false);
        Contact Mathilde = new Contact ("Mathilde Titi", "0033601020304", false);
        Contact Emma = new Contact ("Emma Amore", "0033601020304", false);
        Contact Dave = new Contact ("Dave Strider", "0033601020304", false);
        Contact Lou = new Contact ("Lou Pépèle", "0033601020304", false);
        Contact Yannis = new Contact ("Yannis Kuro", "0033601020304", false);
        Contact Achille = new Contact ("Achille Talon", "0033601020304", false);
        Contact Gregory = new Contact ("Grégory Flotti", "0033601020304", false);
        Contact Winnie = new Contact ("Winnie L'Ourson", "0033611223344", false);
        Contact Gerard = new Contact ("Gérard Menvussa", "0033611223344", false);
        Contact Jean_Marie = new Contact ("Jean-Marie Saint-Joseph", "0033601020304", false);
        Contact Zinedine = new Contact ("Zinedine Zidane", "003311335577", false);
        Contact Germaine = new Contact ("Germaine Langlisse", "0033601020304", false);
        Contact Titouan = new Contact ("Titouan Gaming", "0033601020304", false);
        Contact Alexa = new Contact ("Alexa Amazon", "0033600000000", false);
        Contact Didier = new Contact ("Didier Deschamps", "0033600000001", false);

        this.listeDesContacts = new ArrayList<Contact>();
        listeDesContacts.add(Jean);
        listeDesContacts.add(Lucie);
        listeDesContacts.add(Salome);
        listeDesContacts.add(Henri);
        listeDesContacts.add(Valentine);
        listeDesContacts.add(Adelaide);
        listeDesContacts.add(Mathilde);
        listeDesContacts.add(Emma);
        listeDesContacts.add(Dave);
        listeDesContacts.add(Lou);
        listeDesContacts.add(Yannis);
        listeDesContacts.add(Achille);
        listeDesContacts.add(Gregory);
        listeDesContacts.add(Winnie);
        listeDesContacts.add(Gerard);
        listeDesContacts.add(Jean_Marie);
        listeDesContacts.add(Zinedine);
        listeDesContacts.add(Germaine);
        listeDesContacts.add(Titouan);
        listeDesContacts.add(Alexa);
        listeDesContacts.add(Didier);

        ArrayAdapter<Contact> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, getListeDesContacts());
        this.listView.setAdapter(arrayAdapter);


        for(int i = 0 ; i < listeDesContacts.size() ; i++ ) {

            this.listView.setItemChecked(i, listeDesContacts.get(i).isActive());
        }
    }

    public ArrayList<Contact> getListeDesContacts() {
        return listeDesContacts;
    }

    public ArrayList<Contact> getListeDesContactsSelectionnes() {
        return listeDesContactsSelectionnes;
    }

    public void printSelectedItems(View v){


        this.listeDesContactsSelectionnes = new ArrayList<Contact>();
        SparseBooleanArray sp = listView.getCheckedItemPositions();

        for(int i = 0 ; i < getListeDesContacts().size() ; i++) {

            if (sp.valueAt(i) == true) {

                this.listeDesContactsSelectionnes.add(listeDesContacts.get(i));
            }
        }

        Intent intent = new Intent(this, ContactSelectionne.class);
        intent.putExtra("listSelectedContacts", listeDesContactsSelectionnes);
        startActivity(intent);

    }
}
