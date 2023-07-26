package com.example.infrastructure.repository.impl;

import com.example.infrastructure.entity.ReportEntity;
import com.example.infrastructure.repository.ReportEntityRepository;
import org.example.entity.Report;
import org.example.spi.port.ReportRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ReportRepositoryImpl implements ReportRepository {

    private ReportEntityRepository reportEntityRepository;


    private ModelMapper modelMapper;

    public ReportRepositoryImpl(ReportEntityRepository reportEntityRepository) {
        this.reportEntityRepository = reportEntityRepository;
        modelMapper = new ModelMapper();
    }

    @Override
    public Report save(Report report) {
        ReportEntity reportEntity = modelMapper.map(report,ReportEntity.class);
        ReportEntity reportSave = reportEntityRepository.save(reportEntity);
        return modelMapper.map(reportSave,Report.class);
    }

    @Override
    public Report findById(int id) {
        Optional<ReportEntity> reportEntity = reportEntityRepository.findById(id);
        if(reportEntity.isPresent()){
            return modelMapper.map(reportEntity,Report.class);
        }
        throw new RuntimeException("Not found");
    }

    @Override
    public List<Report> findAll() {
        List<Report> reports =new ArrayList<>();
        reportEntityRepository.findAll().forEach(r -> {
            reports.add(modelMapper.map(r,Report.class));
        });
        return reports;
    }
}
