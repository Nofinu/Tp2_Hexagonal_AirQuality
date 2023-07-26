package org.example.service;

import org.example.entity.Report;
import org.example.exception.DateFormatNotFitException;
import org.example.exception.InputOutOfRangeException;

import java.util.Date;
import java.util.List;

public interface ReportService {

    Report create (double longitude,double latitude,String dateAndHoursStr,int polution,String comment) throws DateFormatNotFitException;
    Report update (int id,double longitude,double latitude,String dateAndHoursStr,int polution,String comment) throws DateFormatNotFitException;
    Boolean delete (int id);
    Report findById (int id);
    List<Report> findByLocalisation (double longitude,double latitude) throws InputOutOfRangeException;
    List<Report> findByDate(Date date);
    List<Report> findAll();
    List<Report> lastPublish();

}
