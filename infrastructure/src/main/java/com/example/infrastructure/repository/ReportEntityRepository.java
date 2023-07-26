package com.example.infrastructure.repository;

import com.example.infrastructure.entity.ReportEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportEntityRepository extends CrudRepository<ReportEntity,Integer> {
}
