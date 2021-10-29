package com.groupea.mini_projet_ue236;

//diverses bibliothèques
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class Contact extends AppCompatActivity implements Serializable //AppCompatActivity : supporte les màj de librairies|| Sérialization : les objets deviennent un tableau d'octets
{
    //Variables d'instance
    private String contactName; //nom du contact
    private String phoneContact; //numéro de t&léphone du contact

    private boolean active; //est lié d'une façon ou d'une autre au currentCheck.isActive() du MainActivity

    //Constructeur avec seulement le nom et le numéro de téléphone en paramètres
    public Contact(String contactName, String phoneContact)
    {
        this.contactName = contactName;
        this.phoneContact = phoneContact;
        this.active= true; //boolean true
    }

    //Constructeur avec le nom, le numéro de télélphone, et l'état du boolean en parapètres
    public Contact(String contactName, String phoneContact, boolean active)
    {
        this.contactName= contactName;
        this.phoneContact = phoneContact;
        this.active= active; //boolean true
    }

    //Méthode récupère le numéro de téléphone du contact
    public String getPhoneContact()
    {
        return phoneContact;
    }

    //Méthode qui définit le numéro de téléphone du contact
    public void setphoneContact(String phoneContact)
    {
        this.phoneContact = phoneContact;
    }

    //Méthode qui récupère le nom du contact
    public String getContactName()
    {
        return contactName;
    }

    //Méthode qui définit le nom du contact
    public void setContactName(String contactName)
    {
        this.contactName = contactName;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    @Override
    public String toString() //donne la structure d'affichage de chaque objet contact au sein de la listView située dans la mainactivity
    {
        return this.contactName +" ("+ this.phoneContact+")";
    }
}
