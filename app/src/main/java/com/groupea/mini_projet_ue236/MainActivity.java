package com.groupea.mini_projet_ue236;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getListeContacts();
    }

    public ArrayList<Contact> listeContacts = new ArrayList<Contact>();

    public ArrayList<Contact> getListeContacts() {
        return listeContacts;
    }

    Contact contact1 = new Contact("Dumas", "Lucie", "+33601020304");
    Contact contact2 = new Contact("Machon", "Adélaïde", "+33602040608");
    Contact contact3 = new Contact("Baradat", "Jean", "+33601030507");
    Contact contact4 = new Contact("Cliquennois", "Salomé", "+33605060708");
    Contact contact5 = new Contact("Menvussa", "Gérard", "+33611223344");
    Contact contact6 = new Contact("L'ourson", "Winnie", "+33655667788");
    Contact contact7 = new Contact("Zidane", "Zinedine", "+33611335577");
    Contact contact8 = new Contact("Deschamps", "Didier", "+33622446688");
    Contact contact9 = new Contact("Amazon", "Alexa", "+33698765432");
    Contact contact10 = new Contact("Contact", "Jean-Jacques", "+33697531864");

    public class Contact {

        // variables d'instance
        private String nom;
        private String prenom;
        private String numero;

        // constructeur sans paramètre
        public Contact() {
            this.nom = "";
            this.prenom = "";
            this.numero = "+33000000000";
            listeContacts.add(this);
        }

        // constructeur avec nom, prenom, numero
        public Contact(String newNom, String newPrenom, String newNumero) {
            this.nom = newNom;
            this.prenom = newPrenom;
            this.numero = newNumero;
            listeContacts.add(this);
        }

        // setters
        public void setNom(String newNom) {
            this.nom = newNom;
        }

        public void setPrenom(String newPrenom) {
            this.prenom = newPrenom;
        }

        public void setNumero(String newNumero) {
            this.numero = newNumero;
        }

        // getters
        public String getNom() {
            return this.nom;
        }

        public String getPrenom() {
            return this.prenom;
        }

        public String getNumero() {
            return this.numero;
        }
    }
}