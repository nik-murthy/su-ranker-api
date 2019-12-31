package com.suranker.api.Repository;

import com.suranker.api.Entity.Lga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LgaRepository extends JpaRepository<Lga, Integer> {
    List<Lga> findByLgaId(int lgaId);
}
