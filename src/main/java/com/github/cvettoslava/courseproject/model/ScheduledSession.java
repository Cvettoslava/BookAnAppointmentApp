package com.github.cvettoslava.courseproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "schedule")
public class ScheduledSession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    // @Min(value = 5, message = "Client name must be at least 5 characters long")
    // @Max(value = 50, message = "Client name must not exceed 50 characters")
    @NotNull(message = "Please enter a client name")
    @Column(name = "name")
    private String name;

    // @Min(value = 8, message = "Phone number must be at least 8 characters long")
    // @Max(value = 12, message = "Phone number cannot be over 12 characters long")
    @Column(name = "phone")
    private String phone;

    @Column(name = "service")
    private int service_id;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

}
