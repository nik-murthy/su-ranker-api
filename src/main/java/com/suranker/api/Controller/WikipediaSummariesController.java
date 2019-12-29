package com.suranker.api.Controller;

import com.suranker.api.Entity.WikipediaSummaries;
import com.suranker.api.Service.WikipediaSummariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WikipediaSummariesController {

    @Autowired
    WikipediaSummariesService wikiSummariesService;

    @GetMapping("/api/v1/wikisummary")
    public List<WikipediaSummaries> getWikiSummary(@RequestParam String suburbId) {
        return wikiSummariesService.getWikiSummaries(Integer.parseInt(suburbId));
    }

}
