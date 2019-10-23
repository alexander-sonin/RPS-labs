package ru.lab6s1.servlet;

import ru.lab6s1.data.dao.DAO;
import ru.lab6s1.model.AuthorModel;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//import javax.enterprise.context.ConversationScoped;
//import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "Controller")
@SessionScoped
//@Named(value="indexBean")
//@SessionScoped
//@Stateful
public class UIController /*implements BeanLocal<AuthorModel>*/{
    @EJB(name = "dao")
    private DAO dao;

    public String getMystr() {
        return mystr;
    }
    public void setMystr(String mystr) {
        this.mystr = mystr;
    }
    private String mystr = "";

    @EJB(name = "sbl")
    private BeanLocal sessionBean;
    ArrayList selections = new ArrayList<AuthorModel>();
    public ArrayList getSelections() {
        return selections;
    }
    public void setSelections(ArrayList selections) {
        this.selections = selections;
    }
    public List<AuthorModel> getList() {
        return dao.selectList();
    }
    public void insert(AuthorModel am) {
        dao.insert(am);
    }
    public void update(AuthorModel am) {
        dao.update(am);
    }
    public void delete(int id) {
        dao.delete(id);
    }
    public void autoInc(AuthorModel am) {
        dao.autoIncrement(am);
    }

    public void stringAction(String s){
        mystr = sessionBean.businessAnswer(s);
    }
}
