package it.epicode.be.bw.entities.concrete_classes;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Utente {

	@Id
	@SequenceGenerator(name = "utente_seq", sequenceName = "utente_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utente_seq")
	private Long id;
	
	private String nome;
	private String cognome;
	private Date dataDiNascita;
	private String email;


	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Date getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	}
