package com.example.adapter.controller;

import com.example.adapter.dto.ReportCreateDto;
import org.example.entity.Report;
import org.example.exception.DateFormatNotFitException;
import org.example.exception.InputOutOfRangeException;
import org.example.service.ReportService;
import org.example.service.impl.ReportServiceImpl;
import org.example.spi.port.ReportRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService){
        this.reportService = reportService;
    }

    @GetMapping("")
    public ResponseEntity<List<Report>> findAllReport (){
        return new ResponseEntity<>(reportService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Report> addReport(@RequestBody ReportCreateDto report) throws DateFormatNotFitException {
        if(report != null){
            return new ResponseEntity<>(reportService.create(report.getLongitude(),report.getLatitude(),report.getDateAndHours(),report.getPollution(),report.getComment()),HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/{id}")
    public ResponseEntity<Report> updateReport(@PathVariable int id, @RequestBody ReportCreateDto report) throws DateFormatNotFitException {
        if(report != null){
            return new ResponseEntity<>(reportService.update(id,report.getLongitude(),report.getLatitude(),report.getDateAndHours(),report.getPollution(),report.getComment()),HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{longitude}/{latitude}")
    public ResponseEntity<List<Report>> findByPosition (@PathVariable double longitude, @PathVariable double latitude) throws InputOutOfRangeException {
        return new ResponseEntity<>(reportService.findByLocalisation(longitude,latitude),HttpStatus.OK);
    }

    @GetMapping("/latest")
    public ResponseEntity<List<Report>> findLatest (){
        return new ResponseEntity<>(reportService.lastPublish(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReport(@PathVariable int id){
        if(reportService.delete(id)){
            return new ResponseEntity<>("Report Delete",HttpStatus.OK);
        }
        return new ResponseEntity<>("Error During Delete",HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
