package it.epicode.be.entities;

import it.epicode.be.enumerazioni.StudentType;

import javax.persistence.*;


@Entity // <-- Mi indica che questa classe dovrà essere mappata ad una tabella del db
@Table(name = "students") // <-- Consente di specificare il nome della tabella (Non è obbligatorio)
public class Student {
    @Id // <-- Indica che sarà chiave primaria (obbligatorio)
    @GeneratedValue  // Si usa se si vuol fare gestire gli id al database
    private long id; // Se uso un long con @GeneratedValue mi ritroverò ad avere un bigserial come tipo di dato della colonna
    @Column(name = "nome") // <-- Consente di personalizzare il nome della colonna (Non è obbligatorio)
    private String name;
    @Column(name = "cognome")
    private String surname;
    //@Column(name = "pippo_uno") nel caso la tabella students esiste già l'annotazione @Column è obbligatorio
    //private String pippoPluto;
    @Enumerated(EnumType.STRING)
    // Di default gli enum vengono convertiti in numeri interi, se voglio che essi siano invece Stringhe devo usare @Enumerated
    private StudentType studentType;

    public Student() {
        // Se voglio che JPA sia in grado di leggere dati dal DB e crearmi un oggetto
        // è obbligatorio avere il costruttore vuoto
    }

    public Student(String name, String surname, StudentType studentType) {
        this.name = name;
        this.surname = surname;
        this.studentType = studentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public StudentType getStudentType() {
        return studentType;
    }

    public void setStudentType(StudentType studentType) {
        this.studentType = studentType;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", studentType=" + studentType +
                '}';
    }
}
