package com.suranker.api.Entity;

import com.suranker.api.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = Constants.univerisitiesEntityName)
public class Universities {

    @Id
    @Column(name = Constants.universityIdColumn)
    private int universityId;
    private String name;
    private String campus_type;
    private int suburb_id;

    public int getUniversityId() {
        return universityId;
    }

    public String getName() {
        return name;
    }

    public String getCampus_type() {
        return campus_type;
    }

    public int getSuburb_id() {
        return suburb_id;
    }

    public int getScore() {
        return score;
    }

    private int score;

}
