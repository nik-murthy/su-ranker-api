package com.suranker.api.Repository;

import com.suranker.api.Entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {
    public List<University> findBySuburbId(int suburbId);
}
