package com.codehustle.ems.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Attendance implements Serializable {

    private Long attendanceId;
    private LocalDate attendanceDate;
    private LocalDateTime checkinTime;
    private LocalDateTime checkoutTime;
    private Employee employee;
}
