package com.ftn.ApotekaApp.model;

import javax.persistence.*;

@Entity
@Table(name="izvestaji")
public class Izvestaj {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "izvestaj_generator")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name="informacije", unique=false)
	private String informacije;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "radnja_id")
	private Radnja radnja;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "recept_id")
	private ERecept eRecept;
	
	@OneToOne
    @JoinColumn(name="dijagnoza_id")
	private Dijagnoza dijagnoza;

	public Izvestaj() {
		
	}
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInformacije() {
		return informacije;
	}

	public void setInformacije(String informacije) {
		this.informacije = informacije;
	}



	public Dijagnoza getDijagnoza() {
		return dijagnoza;
	}

	public void setDijagnoza(Dijagnoza dijagnoza) {
		this.dijagnoza = dijagnoza;
	}
	
	
	
}
