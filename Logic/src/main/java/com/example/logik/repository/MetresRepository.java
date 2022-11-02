package com.example.logik.repository;

import com.example.logik.entity.Metres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetresRepository extends JpaRepository<Metres,Integer>{
}
