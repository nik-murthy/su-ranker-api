package com.suranker.api.Repository;

import com.suranker.api.Entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    List<Hospital> findBySuburbId(int suburbId);
}
