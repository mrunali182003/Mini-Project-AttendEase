
package com.example.attendease.model;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "attendance_reports")
public class AttendanceReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String subject;
    private int percentage;
    private String status;

    public AttendanceReport() {}

    public AttendanceReport(LocalDate date, String subject, int percentage, String status) {
        this.date = date;
        this.subject = subject;
        this.percentage = percentage;
        this.status = status;
    }

    // Getters and setters
    public Long getId() { return id; }
    public LocalDate getDate() { return date; }
    public String getSubject() { return subject; }
    public int getPercentage() { return percentage; }
    public String getStatus() { return status; }

    public void setId(Long id) { this.id = id; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setSubject(String subject) { this.subject = subject; }
    public void setPercentage(int percentage) { this.percentage = percentage; }
    public void setStatus(String status) { this.status = status; }
}
