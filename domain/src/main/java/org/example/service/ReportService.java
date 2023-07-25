package org.example.service;

import org.example.entity.Report;

import java.util.Date;
import java.util.List;

public interface ReportService {

    void create (double longitude,double latitude,String DateAndHoursStr,int polution,String Ccomment);
    Report findById (int id);
    List<Report> findByLocalisation (double longitude,double latitude);
    List<Report> findByDate(Date date);
    List<Report> findAll();
    List<Report> lastPublish();

}
