package it.epicode.be.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue
    private long id;
    @Column(name ="issue_date")
    private LocalDate issueDate;
    private String country;
    private String code;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    // Join Column identifica dove posizioniamo la chiave esterna
    // Nullable = false serve per far si che non sia possibile NON inserire quel valore al suo interno
    private User user;

    public Document() {}

    public Document(LocalDate issueDate, String country, String code, User user) {
        this.issueDate = issueDate;
        this.country = country;
        this.code = code;
        this.user = user;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", issueDate=" + issueDate +
                ", country='" + country + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
