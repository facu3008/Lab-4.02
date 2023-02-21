package com.ironhack.lab402.controller.DTOs;

import jakarta.validation.constraints.NotNull;

public class DoctorDTODepartment {
    @NotNull(message = "Introduce a department")
    private String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
