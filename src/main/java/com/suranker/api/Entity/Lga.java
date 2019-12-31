package com.suranker.api.Entity;

import com.suranker.api.Util.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = Constants.lgaEntityName)
public class Lga {

    @Id
    @Column(name = Constants.lgaIdColumn)
    private int lgaId;
    @Column(name = Constants.lgaNameColumnName)
    private String lgaName;
    private String type;
    @Column(name = Constants.populationGrowthColumnName)
    private String populationGrowth;
    private int score;

    public int getLgaId() {
        return lgaId;
    }

    public String getLgaName() {
        return lgaName;
    }

    public String getType() {
        return type;
    }

    public String getPopulationGrowth() {
        return populationGrowth;
    }

    public int getScore() {
        return score;
    }
}
