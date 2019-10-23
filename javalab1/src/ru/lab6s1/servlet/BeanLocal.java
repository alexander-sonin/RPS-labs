package ru.lab6s1.servlet;

import javax.ejb.Local;

@Local
public interface BeanLocal {
    String businessAnswer(String s);
}
