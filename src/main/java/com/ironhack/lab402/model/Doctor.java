package com.ironhack.lab402.model;

import com.ironhack.lab402.enums.Status;
import jakarta.persistence.*;

@Entity
public class Doctor {
    @Id
//    @GeneratedValue(strategy = GenerationType)
    private Long employeeId;
    private String department;
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Doctor() {
    }

    public Doctor(Long employeeId, String department, String name, Status status) {
        this.employeeId = employeeId;
        this.department = department;
        this.name = name;
        this.status = status;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
