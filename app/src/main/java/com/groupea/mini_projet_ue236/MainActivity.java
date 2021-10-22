package com.groupea.mini_projet_ue236;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.listContacts);

        class Contact {

            // variables d'instance
            private String nom;
            private String prenom;
            private String numero;

            // constructeur avec nom, prenom, numero
            public Contact(String newNom, String newPrenom, String newNumero) {
                this.nom = newNom;
                this.prenom = newPrenom;
                this.numero = newNumero;
            }

        }

        ArrayAdapter<Contact> tab = new ArrayAdapter<Contact>(this, R.layout.checkbox);

        tab.add(new Contact("Dumas", "Lucie", "+33601020304"));
        tab.add(new Contact("Machon", "Adélaïde", "+33602040608"));
        tab.add(new Contact("Baradat", "Jean", "+33601030507"));
        tab.add(new Contact("Cliquennois", "Salomé", "+33605060708"));
        tab.add(new Contact("Menvussa", "Gérard", "+33611223344"));
        tab.add(new Contact("L'ourson", "Winnie", "+33655667788"));
        tab.add(new Contact("Zidane", "Zinedine", "+33611335577"));
        tab.add(new Contact("Deschamps", "Didier", "+33622446688"));
        tab.add(new Contact("Amazon", "Alexa", "+33698765432"));
        tab.add(new Contact("Contact", "Jean-Jacques", "+33697531864"));
        tab.add(new Contact("Dumas", "Lucie", "+33601020304"));
        tab.add(new Contact("Machon", "Adélaïde", "+33602040608"));
        tab.add(new Contact("Baradat", "Jean", "+33601030507"));
        tab.add(new Contact("Cliquennois", "Salomé", "+33605060708"));
        tab.add(new Contact("Menvussa", "Gérard", "+33611223344"));
        tab.add(new Contact("L'ourson", "Winnie", "+33655667788"));
        tab.add(new Contact("Zidane", "Zinedine", "+33611335577"));
        tab.add(new Contact("Deschamps", "Didier", "+33622446688"));
        tab.add(new Contact("Amazon", "Alexa", "+33698765432"));
        tab.add(new Contact("Contact", "Jean-Jacques", "+33697531864"));

        list.setAdapter(tab);

    }

    public void boutonNextActiviteContactSelectionne(View v) {
        Intent intent = new Intent(this, ContactSelectionne.class);
        startActivity(intent);
    }

}