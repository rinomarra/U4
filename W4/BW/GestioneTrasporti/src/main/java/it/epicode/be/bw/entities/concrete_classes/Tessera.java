package it.epicode.be.bw.entities.concrete_classes;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Tessera {

	
	@Id
	@SequenceGenerator(name = "tessera_seq", sequenceName = "tessera_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tessera_seq")
	private Long id;
	
	private Date dataEmissione;
	
	private Date dataScadenza;

	private String numeroTessera;
	
	@ManyToOne
	private Utente utente;
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(Date dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public String getNumeroTessera() {
		return numeroTessera;
	}

	public void setNumeroTessera(String numeroTessera) {
		this.numeroTessera = numeroTessera;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}


}
