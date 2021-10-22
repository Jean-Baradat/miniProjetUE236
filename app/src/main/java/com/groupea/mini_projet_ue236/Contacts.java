package com.groupea.mini_projet_ue236;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Contacts implements Serializable
{
    private String contactName;
    private int numContact;
    private boolean active;


    public Contacts (String contactName, int numContact)
    {
        this.contactName = contactName;
        this.numContact = numContact;
        this.active = true;
    }

    public Contacts (String contactName, int numContact, boolean active)
    {
        this.contactName = contactName;
        this.numContact = numContact;
        this.active = active;
    }


    public String getContactName ()
    {
        return contactName;
    }

    public void setContactName (String contactName)
    {
        this.contactName = contactName;
    }

    public int getNumContact()
    {
        return numContact;
    }

    public void setNumContact (int numContact)
    {
        this.numContact = numContact;
    }

    public boolean isActive ()
    {
        return active;
    }

    public void setActive (boolean active)
    {
        this.active = active;
    }

    @Override
    public String toString ()
    {
        return this.contactName + "("+ this.numContact+")";
    }
}