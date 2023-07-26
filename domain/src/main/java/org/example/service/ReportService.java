package org.example.service;

import org.example.entity.Report;
import org.example.exception.DateFormatNotFit;

import java.util.Date;
import java.util.List;

public interface ReportService {

    Report create (double longitude,double latitude,String DateAndHoursStr,int polution,String Ccomment) throws DateFormatNotFit;
    Report findById (int id);
    List<Report> findByLocalisation (double longitude,double latitude);
    List<Report> findByDate(Date date);
    List<Report> findAll();
    List<Report> lastPublish();

}
