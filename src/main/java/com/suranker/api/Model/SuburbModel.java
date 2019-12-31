package com.suranker.api.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.suranker.api.Entity.*;

import java.util.List;

public class SuburbModel {


    @JsonProperty
    private Suburb suburbInfo;

    @JsonProperty
    private Lga lga;

    @JsonProperty
    private List<Hospital> hospitals;

    @JsonProperty
    private List<University> universities;

    @JsonProperty
    private WikipediaSummary wikiSummary;

    public void setSuburbInfo(Suburb suburbInfo) {
        this.suburbInfo = suburbInfo;
    }

    public void setWikiSummary(WikipediaSummary wikiSummary) {
        this.wikiSummary = wikiSummary;
    }

    public void setLga(Lga lga) {
        this.lga = lga;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    public void setUniversities(List<University> universities) {
        this.universities = universities;
    }

    public Suburb getSuburbInfo() {
        return suburbInfo;
    }

}
