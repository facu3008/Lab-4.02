package com.ironhack.lab402.controller.interfaces;

import com.ironhack.lab402.enums.Status;
import com.ironhack.lab402.model.Doctor;
import com.ironhack.lab402.model.Patient;

import java.time.LocalDate;
import java.util.List;

public interface PatientController {
List<Patient>getAllPatients();

}
