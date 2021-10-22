package com.groupea.mini_projet_ue236;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

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
        }

        // constructeur avec nom, prenom, numero
        public Contact(String newNom, String newPrenom, int newNumero) {
            this.nom = newNom;
            this.prenom = newPrenom;
            this.numero = newNumero;
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