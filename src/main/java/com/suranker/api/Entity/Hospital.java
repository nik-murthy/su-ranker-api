package com.suranker.api.Entity;

import com.suranker.api.Util.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = Constants.hospitalEntityName)
public class Hospital {

    @Id
    @Column(name = Constants.hospitalIdColumn)
    private int hospitalId;
    @Column(name = Constants.hospitalNameColumn)
    private String hospitalName;
    @Column(name = Constants.suburbIdColumn)
    private int suburbId;
    private String beds;
    private String teaching_hospital;
    private int score;

    public int getHospitalId() {
        return hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public int getSuburbId() {
        return suburbId;
    }

    public String getBeds() {
        return beds;
    }

    public String getTeaching_hospital() {
        return teaching_hospital;
    }

    public int getScore() {
        return score;
    }

}
