package com.groupea.mini_projet_ue236;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public ArrayList<Contact> listeContacts = new ArrayList<Contact>();

    Contact contact1 = new Contact("Dumas", "Lucie", 0601020304);
    Contact contact2 = new Contact("Machon", "Adélaïde", 0602040608);
    Contact contact3 = new Contact("Baradat", "Jean", 0601030507);
    Contact contact4 = new Contact("Cliquennois", "Salomé", 0605060708);
    Contact contact5 = new Contact("Menvussa", "Gérard", 0611223344);
    Contact contact6 = new Contact("L'ourson", "Winnie", 0655667788);
    Contact contact7 = new Contact("Zidane", "Zinedine", 0611335577);
    Contact contact8 = new Contact("Deschamps", "Didier", 0622446688);
    Contact contact9 = new Contact("Amazon", "Alexa", 0698765432);
    Contact contact10 = new Contact("Menvussa", "Gérard", 0697531864);

    public class Contact {

        // variables d'instance
        private String nom;
        private String prenom;
        private int numero;

        // constructeur sans paramètre
        public Contact() {
            this.nom = "";
            this.prenom = "";
            this.numero = 0000000000;
            listeContacts.add(this);
        }

        // constructeur avec nom, prenom, numero
        public Contact(String newNom, String newPrenom, int newNumero) {
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

        public void setNumero(int newNumero) {
            this.numero = newNumero;
        }

        // getters
        public String getNom() {
            return this.nom;
        }

        public String getPrenom() {
            return this.prenom;
        }

        public int getNumero() {
            return this.numero;
        }
    }
}