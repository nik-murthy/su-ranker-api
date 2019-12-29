package com.suranker.api.Repository;

import com.suranker.api.Entity.Hospitals;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospitals, Integer> {
    List<Hospitals> findBySuburbId(int suburbId);
}
