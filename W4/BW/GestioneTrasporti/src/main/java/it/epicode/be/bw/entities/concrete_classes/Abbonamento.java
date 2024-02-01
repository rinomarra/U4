package it.epicode.be.bw.entities.concrete_classes;

import it.epicode.be.bw.entities.abstract_classes.TitoloDiViaggio;
import it.epicode.be.bw.enumerators.TipoAbbonamento;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Abbonamento extends TitoloDiViaggio {
		
	@Enumerated
	private TipoAbbonamento tipoAbbonamento;

	private Date dataScadenza;
	
	@ManyToOne
	private Tessera tessera;

	public TipoAbbonamento getTipoAbbonamento() {
		return tipoAbbonamento;
	}

	public void setTipoAbbonamento(TipoAbbonamento tipoAbbonamento) {
		this.tipoAbbonamento = tipoAbbonamento;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public Tessera getTessera() {
		return tessera;
	}

	public void setTessera(Tessera tessera) {
		this.tessera = tessera;
	}
	
}
