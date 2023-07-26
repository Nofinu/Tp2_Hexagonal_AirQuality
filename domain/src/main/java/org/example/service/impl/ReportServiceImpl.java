package org.example.service.impl;

import org.example.entity.Report;
import org.example.exception.DateFormatNotFit;
import org.example.service.ReportService;
import org.example.spi.port.ReportRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReportServiceImpl implements ReportService {

    private ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Report create(double longitude, double latitude, String dateAndHoursStr, int polution, String comment) throws DateFormatNotFit {
        Date date;
        try{
            date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(dateAndHoursStr);
        }catch (ParseException ex){
            throw new DateFormatNotFit();
        }
        Report report = new Report(longitude,latitude,date,polution,comment);
        return reportRepository.save(report);
    }

    @Override
    public Report findById(int id) {
        return reportRepository.findById(id);
    }

    @Override
    public List<Report> findByLocalisation(double longitude, double latitude) {
        return null;
    }

    @Override
    public List<Report> findByDate(Date date) {
        return null;
    }

    @Override
    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    @Override
    public List<Report> lastPublish() {
        return null;
    }
}
