package it.epicode.be.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "blogs")
public class BlogPost {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // <--- FOREIGN KEY

    @ManyToMany
    @JoinTable(name = "blogs_categories", // DEFINIAMO COME SARA' FATTA LA JUNCTION TABLE
            joinColumns = @JoinColumn(name = "blog_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id") // DEFINIAMO I NOMI DELLE SUE COLONNE
    )
    // QUESTA DEFINIZIONE DELLE COLONNE E' SPECULARE RISPETTO A QUELLA DEFINITA SU CATEGORIES
    private List<Category> categoryList;

    public BlogPost(){}

    public BlogPost(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "BlogPost{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
