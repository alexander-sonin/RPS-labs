package ru.lab6s1.model;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "author")
public class AuthorModel implements Serializable {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private Date birthDate;
    private String city;
    public AuthorModel(){}
    public AuthorModel(int id, String surname, String name, String patronymic, Date birthDate, String city) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.city = city;
    }

    public int getId() {
        return id;
    }
    public String getSurname() {
        return surname;
    }
    public String getName() {
        return name;
    }
    public String getPatronymic() {
        return patronymic;
    }
    public Date getBirthDate() { return birthDate; }
    public String getCity() {
        return city;
    }

    public void setId(int id) {this.id = id;}
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString()
    {    return id+ "\t| " + surname + "\t| " + name + "\t| " + patronymic +
                "\t| " + birthDate + "\t| " + city+"\n";
    }
}
