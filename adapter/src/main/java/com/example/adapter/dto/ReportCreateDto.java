package com.example.adapter.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.Pollution;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportCreateDto {
    @Max(value = 180, message = "longitude must be less than 180")
    @Min(value = -180, message = "longitude must be more than -180")
    private double longitude;
    @Max(value = 90, message = "latitude must be less than 90")
    @Min(value = -90, message = "latitude must be more than -90")
    private double latitude;
    private String dateAndHours;
    @Min(value = 1, message = "polution min is 1")
    @Max(value = 3, message = "polution max is 3")
    private int pollution;
    private String comment;
}
