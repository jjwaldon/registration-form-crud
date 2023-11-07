package com.crud.app.crudjavafx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class UniModel
{

    private final StringProperty id;
    private final StringProperty firstName;
    private final StringProperty secondName;
    private final StringProperty Phone;

    public UniModel()
    {
        id = new SimpleStringProperty(this, "id");
        firstName = new SimpleStringProperty(this, "firstName");
        secondName = new SimpleStringProperty(this, "secondName");
        Phone = new SimpleStringProperty(this, "Phone");
    }
    public StringProperty idProperty()
    {
        return id;
    }
    public String getId()
    {
        return id.get();
    }
    public void setId(String newId)
    {
        id.set(newId);
    }
    public StringProperty FirstnameProperty()
    {
        return firstName;
    }
    public String getFirstName()
    {
        return firstName.get();
    }
    public void setFirstName(String newFirstName)
    {
        firstName.set(newFirstName);
    }
    public StringProperty secondNameProperty()
    {
        return secondName;
    }
    public String getSecondName()
    {
        return secondName.get();
    }
    public void setSecondName(String newSecondName)
    {
        secondName.set(newSecondName);
    }

    public StringProperty phoneProperty()
    {
        return Phone;
    }
    public String getPhone()
    {
        return Phone.get();
    }
    public void setPhone(String newPhone)
    {
        Phone.set(newPhone);
    }
}


