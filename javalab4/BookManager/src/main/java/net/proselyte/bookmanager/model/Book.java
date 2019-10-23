package net.proselyte.bookmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "id_book")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;
    @Column(name = "price")
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookTitle='" + name + '\'' +
                ", bookAuthor='" +author + '\'' +
                ", bookPrice='" +price + '\'' +

                '}';
    }
}
