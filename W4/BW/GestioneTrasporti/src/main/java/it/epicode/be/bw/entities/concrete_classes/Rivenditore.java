package it.epicode.be.bw.entities.concrete_classes;

import it.epicode.be.bw.entities.abstract_classes.PuntoVendita;

import javax.persistence.Entity;

@Entity
public class Rivenditore extends PuntoVendita {
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
