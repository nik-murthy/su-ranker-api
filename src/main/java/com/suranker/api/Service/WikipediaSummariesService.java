package com.suranker.api.Service;

import com.suranker.api.Entity.WikipediaSummary;
import com.suranker.api.Repository.WikipediaSummariesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WikipediaSummariesService {

    @Autowired
    WikipediaSummariesRepository wikiSummaries;

    public List<WikipediaSummary> getWikiSummaries(int suburbId) {
        return wikiSummaries.findBySuburbId(suburbId);
    }
}
