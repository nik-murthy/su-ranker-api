package com.suranker.api.Entity;

import com.suranker.api.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = Constants.universitiesEntityName)
public class Universities {

    @Id
    @Column(name = Constants.universityIdColumn)
    private int universityId;
    private String name;
    private String campus_type;
    @Column(name = "suburb_id")
    private int suburbId;

    public int getUniversityId() {
        return universityId;
    }

    public String getName() {
        return name;
    }

    public String getCampus_type() {
        return campus_type;
    }

    public int getSuburbId() {
        return suburbId;
    }

    public int getScore() {
        return score;
    }

    private int score;

}
