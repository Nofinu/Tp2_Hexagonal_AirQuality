package com.example.infrastructure.repository;

import com.example.infrastructure.entity.ReportEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportEntityRepository extends CrudRepository<ReportEntity,Integer> {

    List<ReportEntity> findByLatitudeBetweenAndLongitudeBetween (double latitudeMin,double latitudeMax,double longitudeMin,double longitudeMax);

    @Query("SELECT r FROM ReportEntity as r ORDER BY r.dateAndHours desc LIMIT 10")
    List<ReportEntity> findOrderByDate ();
}
