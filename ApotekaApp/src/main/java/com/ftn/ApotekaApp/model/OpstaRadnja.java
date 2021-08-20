package com.ftn.ApotekaApp.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("O")
public class OpstaRadnja extends Radnja{

    @Column
    private TipOpsteRadnje tipOpsteRadnje;

    public OpstaRadnja() {
    }

    public OpstaRadnja(TipOpsteRadnje tipOpsteRadnje) {
        this.tipOpsteRadnje = tipOpsteRadnje;
    }

    public TipOpsteRadnje getTipOpsteRadnje() {
        return tipOpsteRadnje;
    }

    public void setTipOpsteRadnje(TipOpsteRadnje tipOpsteRadnje) {
        this.tipOpsteRadnje = tipOpsteRadnje;
    }
}
