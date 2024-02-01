package it.epicode.be.bw.entities.concrete_classes;

import it.epicode.be.bw.enumerators.TipoMezzo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Mezzo {

	@Id
	@SequenceGenerator(name = "mezzo_seq", sequenceName = "mezzo_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mezzo_seq")
	private Long id;
	
	private String codice;
	
	@Enumerated(EnumType.STRING)
	private TipoMezzo tipoMezzo;
	
	@OneToMany(mappedBy = "mezzo",cascade = CascadeType.ALL,orphanRemoval = true)
	@OrderBy(value = "dataInizio DESC")
	private List<StatoMezzo> listaStatoMezzo;
	
	@ManyToOne
	private Tratta trattaAssegnata;


	}
