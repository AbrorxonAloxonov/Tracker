package com.example.logik.repository;

import com.example.logik.entity.History;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HistoryRepository extends JpaRepository<History,Integer> {
    @Query(value = "select * from history where ids = ? order by id desc limit 1 offset 1",nativeQuery = true)
    Optional<History> getHistory(Integer id);
}
