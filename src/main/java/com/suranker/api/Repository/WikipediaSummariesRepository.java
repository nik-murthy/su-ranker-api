package com.suranker.api.Repository;

import com.suranker.api.Entity.WikipediaSummaries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WikipediaSummariesRepository extends JpaRepository<WikipediaSummaries, Integer> {

    List<WikipediaSummaries> findBySuburbId(int suburbId);
}
