package com.groupea.mini_projet_ue236;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class Contact extends AppCompatActivity implements Serializable
{
    private String contactName;
    private String phoneContact;

    private boolean active;

    public Contact(String contactName, String phoneContact)
    {
        this.contactName = contactName;
        this.phoneContact = phoneContact;
        this.active= true;
    }

    public Contact(String contactName, String phoneContact, boolean active)
    {
        this.contactName= contactName;
        this.phoneContact = phoneContact;
        this.active= active;
    }

    public String getPhoneContact()
    {
        return phoneContact;
    }

    public void setphoneContact(String phoneContact)
    {
        this.phoneContact = phoneContact;
    }

    public String getContactName()
    {
        return contactName;
    }

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
    public String toString()
    {
        return this.contactName +" ("+ this.phoneContact+")";
    }
}
