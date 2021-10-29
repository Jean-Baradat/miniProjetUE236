package com.groupea.mini_projet_ue236;

// diverses bibliothèques
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

// AppCompatActivity : supporte les màj de librairies || Sérialization : les objets deviennent un
// tableau d'octets
public class Contact extends AppCompatActivity implements Serializable
{
    // Variables d'instance
    // nom du contact
    private String contactName;
    // numéro de telephone du contact
    private String phoneContact;

    // lié d'une façon ou d'une autre au currentCheck.isActive() du MainActivity
    private boolean active;

    // Constructeur avec seulement le nom et le numéro de téléphone en paramètres
    public Contact(String contactName, String phoneContact)
    {
        this.contactName = contactName;
        this.phoneContact = phoneContact;
        this.active= true; //boolean true
    }

    // Constructeur avec le nom, le numéro de télélphone, et l'état du boolean en parapètres
    public Contact(String contactName, String phoneContact, boolean active)
    {
        this.contactName= contactName;
        this.phoneContact = phoneContact;
        this.active= active; //boolean true
    }

    // Méthode récupère le numéro de téléphone du contact
    public String getPhoneContact()
    {
        return phoneContact;
    }

    // Méthode qui définit le numéro de téléphone du contact
    public void setphoneContact(String phoneContact)
    {
        this.phoneContact = phoneContact;
    }

    // Méthode qui récupère le nom du contact
    public String getContactName()
    {
        return contactName;
    }

    // Méthode qui définit le nom du contact
    public void setContactName(String contactName)
    {
        this.contactName = contactName;
    }

    // Méthode qui récupère le parametre active
    public boolean isActive()
    {
        return active;
    }

    // Méthode pour définir le parametre active avec un boolean (true/false)
    public boolean setActive(boolean active)
    {
        this.active = active;
        return active;
    }

    // donne la structure d'affichage de chaque objet contact.
    @Override
    // TODO voir pour peut-etre modif le nom de cette méthode toString()
    public String toString()
    {
        return this.contactName +" ("+ this.phoneContact+")";
    }
}
