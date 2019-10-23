package ru.lab6s1.servlet;

import javax.ejb.Stateful;

@Stateful(name = "SessionEJB")
public class SessionBean implements BeanLocal{
    public SessionBean() {
    }
    private String str ="City: ";
    public String businessAnswer(String s){
        str += s;
        return str;
    }

}
