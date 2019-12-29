package com.suranker.api.Repository;

import com.suranker.api.Entity.Universities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<Universities, Integer> {
    public List<Universities> findBySuburbId(int suburbId);
}
