package com.groupea.mini_projet_ue236;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class ContactSelectionne extends AppCompatActivity implements Serializable {

    String newLine = System.getProperty("line.separator");
    public Contact contactChosen;
    final String infoTitre = "Voulez-vous envoyer un message à :";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_selectionne);

        Bundle infos = getIntent().getExtras();
        final ArrayList<Contact> listSelectedContacts = (ArrayList<Contact>) infos.getSerializable("listSelectedContacts");

        TextView textView = findViewById(R.id.textview1);

        for (int i = 0; i < listSelectedContacts.size() ; i++) {
            if (i == 0){
                textView.append(infoTitre + newLine);
            }
            contactChosen = listSelectedContacts.get(i);
            textView.append(newLine + "• " + contactChosen);
        }
    }

    public void boutonNextActiviteMainActivity(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void boutonValider(View view)
    {
        Toast.makeText(this, "Le message a été envoyé !", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}