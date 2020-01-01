package com.suranker.api.Entity;

import com.suranker.api.Util.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = Constants.wikiSumaaryEntityName)
public class WikipediaSummary {

    @Id
    @Column(name = Constants.suburbIdColumn)
    private int suburbId;
    private String wikipedia_summary;

    public int getSuburbId() {
        return suburbId;
    }

    public String getWikipedia_summary() {
        return wikipedia_summary;
    }


}
