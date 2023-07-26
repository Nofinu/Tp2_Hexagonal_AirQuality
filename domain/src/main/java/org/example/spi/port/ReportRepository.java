package org.example.spi.port;

import org.example.entity.Report;

import java.util.List;

public interface ReportRepository {
    Report save (Report report);
    Boolean delete (Report report);
    Report findById(int id);
    List<Report> findAll();
    List<Report> findByLocation (double longitude, double latitude);
    List<Report> findLatest ();
}
