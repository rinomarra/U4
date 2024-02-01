package it.epicode.be.bw.entities.concrete_classes;

import it.epicode.be.bw.entities.abstract_classes.PuntoVendita;
import it.epicode.be.bw.enumerators.StatoDistributore;

import javax.persistence.Entity;

@Entity
public class DistributoreAutomatico extends PuntoVendita {
	
	private StatoDistributore stato;

	public StatoDistributore getStato() {
		return stato;
	}

	public void setStato(StatoDistributore stato) {
		this.stato = stato;
	}




}
