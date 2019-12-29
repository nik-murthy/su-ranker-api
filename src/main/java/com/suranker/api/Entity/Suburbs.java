package com.suranker.api.Entity;

import com.suranker.api.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = Constants.suburbsEntityName)
public class Suburbs {

    @Id
    @Column(name = Constants.suburbIdColumnName)
    private int suburbId;
    private String name;
    private int postcode;
    private String state;
    private int sa2region;
    private int lga_id;
    private int d_score;
    private int h_score;
    private int u_score;
    private int skew;
    private int total;
    private int medianHousePrice;

    public int getMedianHousePrice() {
        return medianHousePrice;
    }



    public int getSuburbId() {
        return suburbId;
    }

    public String getName() {
        return name;
    }

    public int getPostcode() {
        return postcode;
    }

    public String getState() {
        return state;
    }

    public int getSa2region() {
        return sa2region;
    }

    public int getLga_id() {
        return lga_id;
    }

    public int getD_score() {
        return d_score;
    }

    public int getH_score() {
        return h_score;
    }

    public int getU_score() {
        return u_score;
    }

    public int getSkew() {
        return skew;
    }

    public int getTotal() {
        return total;
    }

}
