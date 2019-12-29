package com.suranker.api.Entity;

import com.suranker.api.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = Constants.lgaEntityName)
public class Lgas {

    @Id
    @Column(name = Constants.lgaIdColumn)
    private int lgaId;
    private String lga_name;
    private String type;
    private String population_growth;
    private int score;

    public int getLgaId() {
        return lgaId;
    }

    public String getLga_name() {
        return lga_name;
    }

    public String getType() {
        return type;
    }

    public String getPopulation_growth() {
        return population_growth;
    }

    public int getScore() {
        return score;
    }
}
