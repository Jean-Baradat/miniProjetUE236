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

    //TODO à sup !
    /*public static final String TAG = "ListViewExample";*/

    private ListView listView;
    private ArrayList<Contact> listeDesContacts;
    private ArrayList<Contact> listeDesContactsSelectionnes;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listView = findViewById(R.id.listView);
        //TODO à sup !
        /*Button button = findViewById(R.id.button);*/

        this.listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        this.listView.setOnItemClickListener((parent, view, position, id) -> {

            //TODO à sup ?
            /*Log.i(TAG, "onItemClick: " +position);*/
            CheckedTextView v = (CheckedTextView) view;
            boolean currentCheck = v.isChecked();
            Contact contact = (Contact) listView.getItemAtPosition(position);
            contact.setActive(!currentCheck);
        });

        //TODO à sup !
        /*button.setOnClickListener(v -> printSelectedItems());*/

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


        //TODO à sup !
        /*
        Contact[] contacts = new Contact[]
        {
            Jean,
            Lucie,
            Salome,
            Henri,
            Valentine,
            Adelaide,
            Mathilde,
            Emma,
            Dave,
            Lou,
            Yannis,
            Achille,
            Gregory,
            Winnie,
            Gerard,
            Jean_Marie,
            Zinedine,
            Germaine,
            Titouan,
            Alexa,
            Didier
        };
         */

        ArrayAdapter<Contact> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, getListeDesContacts());
        this.listView.setAdapter(arrayAdapter);

        //TODO c'est pour quoi faire ?
        for(int i = 0 ; i < listeDesContacts.size() ; i++ ){
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


        /*String newLine = System.getProperty("line.separator");*/
        this.listeDesContactsSelectionnes = new ArrayList<Contact>();
        System.out.println(getListeDesContacts());
        System.out.println(getListeDesContactsSelectionnes());

        for(int i = 0 ; i < getListeDesContacts().size() ; i++) {
            /*if (listeDesContacts.get(i) == )*/
            this.listeDesContactsSelectionnes.add(listeDesContacts.get(i));
            System.out.println("ICI" + getListeDesContactsSelectionnes());
        }



        /*
        SparseBooleanArray sp = listView.getCheckedItemPositions();

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < sp.size() ; i++)
        {
            if(sp.valueAt(i))
            {
                Contact contact= (Contact) listView.getItemAtPosition(i);
                String s = contact.getContactName();
                String t = contact.getPhoneContact();
                sb = sb.append(newLine + "• " ).append(s + " " + "(" + t + ")");
            }
        }
        */



        Intent intent = new Intent(this, ContactSelectionne.class);
        /*intent.putExtra("listSelectedContacts", sb.toString());*/
        startActivity(intent);
    }
}
