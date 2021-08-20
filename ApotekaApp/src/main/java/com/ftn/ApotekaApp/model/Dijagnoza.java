package com.ftn.ApotekaApp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="dijagnoze")
public class Dijagnoza {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dijagnoza_generator")
	@SequenceGenerator(name="dijagnoza_generator",initialValue = 2 ,sequenceName = "dijagnoza_seq")
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	
	@Column(name="tip", unique=true, nullable=false)
	private TipDijagnoza tip;

	public Dijagnoza() {
		
	}
	
	
	public Dijagnoza(TipDijagnoza tip) {
		super();
		this.tip = tip;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipDijagnoza getTip() {
		return tip;
	}

	public void setTip(TipDijagnoza tip) {
		this.tip = tip;
	}

	
	
	
}
