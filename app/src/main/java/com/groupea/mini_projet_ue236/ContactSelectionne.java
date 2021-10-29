package com.groupea.mini_projet_ue236;

// diverses bibliothèques
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;

// AppCompatActivity : supporte les màj de librairies || Sérialization : les objets deviennent un
// tableau d'octets
public class ContactSelectionne extends AppCompatActivity implements Serializable {

    // saut de ligne pour le textView listant les contacts sélectionnés
    String newLine = System.getProperty("line.separator");
    // permettra ensuite d'invoquer le nom du contact sélectionné, au sein du textView
    public Contact contactChosen;
    // simple phrase d'ouverture du sujet
    final String infoTitre = "Voulez-vous envoyer un message à :";

    // à la création de l'application (= à son ouverture), récupère les données initiales contenues
    // dans savedInstanceState
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // pour que notre code puisse être lu en addition du code existant déjà dans le onCreate()
        super.onCreate(savedInstanceState);
        // pose l'interface visuelle depuis les ressources (R) correspondant à
        // contact_selectionne.xml
        setContentView(R.layout.contact_selectionne);

        // récupère les valeurs issues de l'intent stockées dans le bundle
        Bundle infos = getIntent().getExtras();
        // récupère le tableau sous forme d'octets et le "décrypte" grâce à la clé
        // "listSelectedContacts"
        final ArrayList<Contact> listSelectedContacts =
                (ArrayList<Contact>) infos.getSerializable("listSelectedContacts");

        // appel du textView grâce à son id
        TextView textView = findViewById(R.id.textview1);

        // pour toute la longueur de la liste des contacts sélectionnés (=lit le tableau de
        // haut en bas)
        for (int i = 0; i < listSelectedContacts.size() ; i++) {
            if (i == 0){
                // permet d'appeler la phrase d'intro lorsque l'index du nuveau tableau est à 0
                // (=économise un textView) et rajoute un retour à la ligne
                textView.append(infoTitre + newLine);
            }
            // récupère l'index du contact et la palce dans contactChosen
            contactChosen = listSelectedContacts.get(i);
            // saut de ligne + point de liste + nom du contact à l'index i (contactChosen)
            textView.append(newLine + "• " + contactChosen);
        }
    }

    // retourne à l'activité précédente
    public void buttonNextActivityMainActivity(View v)
    {
        //TODO : trouver un moyen de conserver les contacts précédemment cochés afin d'éviter à
        // l'utilisateur de devoir tous les recocher pour une simple erreur ?
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // Validation du choix des contacts et envoi du message, retourne à l'activite 1 (MainActivity)
    public void boutonValider(View view)
    {
        // petite bulle en bas de l'écran indiquant que le message a été envoyé aux contacts
        // sélectionnés
        Toast.makeText(this, "Le message a été envoyé !", Toast.LENGTH_SHORT).show();
        // fait le lien entre cette activité et l'activité MainActivity
        Intent intent = new Intent(this, MainActivity.class);
        // lance l'intent décrit
        startActivity(intent);
    }
}