package com.ftn.ApotekaApp.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class ERecept {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "erecept_generator")
    @SequenceGenerator(name="erecept_generator",initialValue = 2 ,sequenceName = "erecept_seq")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column
    private LocalDate datumIzdavanja;

    @Column
    private StatusERecept status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pacijent pacijent;

    @OneToMany(mappedBy="id")
    private Set<Lek> lekovi;

    @OneToOne(mappedBy = "eRecept", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Izvestaj izvestaj;
}
