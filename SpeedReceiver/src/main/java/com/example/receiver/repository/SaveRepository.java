package com.example.receiver.repository;

import com.example.receiver.entity.RootEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaveRepository extends JpaRepository<RootEntity,Integer> {
}
