package com.suranker.api.Repository;

import com.suranker.api.Entity.WikipediaSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WikipediaSummariesRepository extends JpaRepository<WikipediaSummary, Integer> {

    List<WikipediaSummary> findBySuburbId(int suburbId);
}
