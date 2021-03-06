package com.suranker.api.Entity;

import com.suranker.api.Util.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = Constants.universitiesEntityName)
public class University {

    @Id
    @Column(name = Constants.universityIdColumn)
    private int universityId;
    @Column(name = Constants.uniNameColumn)
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
