package com.ironhack.lab402.controller.DTOs;

import com.ironhack.lab402.enums.Status;
import jakarta.validation.constraints.NotNull;

public class DoctorDtoStatus {
    @NotNull(message = "Introduce a status")
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
