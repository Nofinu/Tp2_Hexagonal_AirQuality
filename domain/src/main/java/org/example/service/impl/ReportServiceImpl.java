package org.example.service.impl;

import org.example.entity.Report;
import org.example.exception.DateFormatNotFitException;
import org.example.exception.InputOutOfRangeException;
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
    public Report create(double longitude, double latitude, String dateAndHoursStr, int polution, String comment) throws DateFormatNotFitException {
        Report report = new Report(longitude,latitude,getDateFromStr(dateAndHoursStr),polution,comment);
        return reportRepository.save(report);
    }

    @Override
    public Report update(int id, double longitude, double latitude, String dateAndHoursStr, int polution, String comment) throws DateFormatNotFitException {
        Report report = reportRepository.findById(id);
        report.setLongitude(longitude);
        report.setLatitude(latitude);
        report.setDateAndHours(getDateFromStr(dateAndHoursStr));
        report.setPollutionByInt(polution);
        report.setComment(comment);
        return reportRepository.save(report);
    }

    @Override
    public Boolean delete(int id) {
        Report report = findById(id);
        return reportRepository.delete(report);
    }

    private Date getDateFromStr (String dateStr) throws DateFormatNotFitException {
        Date date;
        try{
            date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(dateStr);
        }catch (ParseException ex){
            throw new DateFormatNotFitException();
        }
        return date;
    }

    @Override
    public Report findById(int id) {
        return reportRepository.findById(id);
    }

    @Override
    public List<Report> findByLocalisation(double longitude, double latitude) throws InputOutOfRangeException {
        if(longitude<180 && longitude>-180 && latitude<90 && latitude>-90){
            return reportRepository.findByLocation(longitude,latitude);
        }
        throw new InputOutOfRangeException();
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
        return reportRepository.findLatest();
    }
}
