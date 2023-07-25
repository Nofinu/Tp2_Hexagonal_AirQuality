package org.example.spi.port;

import org.example.entity.Report;

import java.util.List;

public interface ReportRepository {
    void save (Report report);
    Report findById(int id);
    List<Report> findAll();
}
