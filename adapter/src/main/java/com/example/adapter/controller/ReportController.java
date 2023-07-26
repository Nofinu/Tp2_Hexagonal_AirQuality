package com.example.adapter.controller;

import com.example.adapter.dto.ReportCreateDto;
import org.example.entity.Report;
import org.example.exception.DateFormatNotFit;
import org.example.service.impl.ReportServiceImpl;
import org.example.spi.port.ReportRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/report")
public class ReportController {
    private final ReportServiceImpl reportService;

    public ReportController(ReportRepository reportRepository) {
        reportService = new ReportServiceImpl(reportRepository);
    }

    @GetMapping("")
    public ResponseEntity<List<Report>> findAllReport (){
        return new ResponseEntity<>(reportService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Report> addReport(@RequestBody ReportCreateDto report) throws DateFormatNotFit {
        if(report != null){
            return new ResponseEntity<>(reportService.create(report.getLongitude(),report.getLatitude(),report.getDateAndHours(),report.getPollution(),report.getComment()),HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

}
