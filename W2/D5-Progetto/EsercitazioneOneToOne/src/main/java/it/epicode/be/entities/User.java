package it.epicode.be.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @OneToOne(mappedBy = "user")
    // Se inserisco OneToOne anche su questo lato (NON E' OBBLIGATORIO)
    // la relazione diventa BIDIREZIONALE
    // Bidirezionale significa che aggiungo una possibilità in più ovvero
    // non solo potrò dal document risalire a chi sia l'utente ad esso collegato
    // ma potrò anche dallo user risalire a quale è il suo documento
    // mappedBy serve per specificare il nome dell'attributo dell'altra classe a cui collegarsi
    // N.B. il mappedBy NON CREA NESSUNA NUOVA COLONNA IN QUESTA TABELLA
    private Document document;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BlogPost> blogPostList;


    public User(){}

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<BlogPost> getBlogPostList() {
        return blogPostList;
    }

    public void setBlogPostList(List<BlogPost> blogPostList) {
        this.blogPostList = blogPostList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
