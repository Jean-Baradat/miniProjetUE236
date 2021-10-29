package com.groupea.mini_projet_ue236;

//diverses bibliothèques
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class ContactSelectionne extends AppCompatActivity implements Serializable { //AppCompatActivity : supporte les màj de librairies|| Sérialization : les objets deviennent un tableau d'octets

    String newLine = System.getProperty("line.separator"); //saut de ligne pour le textView listant les contacts sélectionnés
    public Contact contactChosen; //permettra ensuite d'invoquer le nom du contact sélectionné, au sein du textView
    final String infoTitre = "Voulez-vous envoyer un message à :"; //simple phrase d'ouverture du sujet

    @Override
    protected void onCreate(Bundle savedInstanceState) { //à la création de l'application (= à son ouverture), récupère les données initiales contenues dans savedInstanceState

        super.onCreate(savedInstanceState); //pour que notre code puisse être lu en addition du code existant déjà dans le onCreate()
        setContentView(R.layout.contact_selectionne); //pose l'interface visuelle depuis les ressources (R) correspondant à contact_selectionne.xml

        Bundle infos = getIntent().getExtras(); //récupère les valeurs issues de l'intent stockées dans le bundle
        final ArrayList<Contact> listSelectedContacts = (ArrayList<Contact>) infos.getSerializable("listSelectedContacts"); //récupère le tableau sous forme d'octets et le "décrypte" grâce à la clé "listSelectedContacts"

        TextView textView = findViewById(R.id.textview1); //appel du textView grâce à son id

        for (int i = 0; i < listSelectedContacts.size() ; i++) { //pour toute la longueur de la liste des contacts sélectionnés (=lit le tableau de haut en bas)
            if (i == 0){
                textView.append(infoTitre + newLine); //permet d'appeler la phrase d'intro lorsque l'index du nuveau tableau est à 0 (=économise un textView) et rajoute un retour à la ligne
            }
            contactChosen = listSelectedContacts.get(i); //récupère l'index du contact
            textView.append(newLine + "• " + contactChosen); //saut de ligne + point de liste + nom du contact à l'index i
        }
    }

    public void boutonNextActiviteMainActivity(View v) //retourne à l'activité précédente
    {
        //TODO : trouver un moyen de conserver les contacts précédemment cochés afin d'éviter à l'utilisateur de devoir tous les recocher pour une simple erreur ?
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void boutonValider(View view) //Validation du choix des contacts et envoi du message, retourne au début de l'activité précédente
    {
        Toast.makeText(this, "Le message a été envoyé !", Toast.LENGTH_SHORT).show(); //petite bulle en bas de l'écran indiquant que le message a été envoyé aux contacts sélectionnés
        Intent intent = new Intent(this, MainActivity.class); //fait le lien entre cette activité et l'activité MainActivity
        startActivity(intent); //lance l'intent décrit
    }
}