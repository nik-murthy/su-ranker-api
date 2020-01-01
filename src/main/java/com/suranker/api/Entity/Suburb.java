package com.suranker.api.Entity;

import com.suranker.api.Util.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = Constants.suburbsEntityName)
public class Suburb {

    @Id
    @Column(name = Constants.suburbIdColumn)
    private int suburbId;
    @Column(name = Constants.suburbNameColumn)
    private String name;
    private int postcode;
    private String state;
    private int sa2region;
    private int lgaId;
    //@Column(name = Constants.demographicsSortColumn)
    private int dScore;
    private int hScore;
    private int uScore;
    private int skew;
    private int total;
    private int overallRank;
    private int medianHousePrice;
    private int medianUnitPrice;

    public int getMedianHousePrice() {
        return medianHousePrice;
    }

    public int getMedianUnitPrice() {
        return medianUnitPrice;
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

    public int getLgaId() {
        return lgaId;
    }

    public int getdScore() {
        return dScore;
    }

    public int gethScore() {
        return hScore;
    }

    public int getuScore() {
        return uScore;
    }

    public int getSkew() {
        return skew;
    }

    public int getTotal() {
        return total;
    }

}
