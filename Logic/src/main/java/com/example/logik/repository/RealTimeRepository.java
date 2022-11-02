package com.example.logik.repository;

import com.example.logik.entity.RealTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealTimeRepository extends JpaRepository<RealTime,Integer> {
}
