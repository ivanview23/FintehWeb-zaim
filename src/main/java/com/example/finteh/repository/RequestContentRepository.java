package com.example.finteh.repository;

import com.example.finteh.entity.RequestContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestContentRepository extends JpaRepository<RequestContentEntity, Long> {
}
