package com.example.infrastructure.repository;

import com.example.infrastructure.entity.ReportEntity;
import org.springframework.data.repository.CrudRepository;

public interface ReportEntityRepository extends CrudRepository<ReportEntity,Integer> {
}
