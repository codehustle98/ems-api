package com.codehustle.ems.entity;

import com.codehustle.ems.constants.ApplicationConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "attendance")
@Data
public class AttendanceEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "seq")
    @GenericGenerator(name = "seq",strategy = "increment")
    @Column(name = "attendance_id")
    private Long attendanceId;

    @Column(name = "attendance_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = ApplicationConstants.DATE_FORMAT)
    private LocalDate attendanceDate;

    @Column(name = "checkin_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = ApplicationConstants.DATE_TIME)
    private LocalDateTime checkinTime;

    @Column(name = "checkout_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = ApplicationConstants.DATE_TIME)
    private LocalDateTime checkoutTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id")
    private EmployeeEntity employee;
}
