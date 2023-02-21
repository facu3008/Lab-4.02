package com.ironhack.lab402.controller.implementacion;

import com.ironhack.lab402.controller.interfaces.PatientController;
import com.ironhack.lab402.enums.Status;
import com.ironhack.lab402.model.Doctor;
import com.ironhack.lab402.model.Patient;
import com.ironhack.lab402.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class PatientControllerImpl implements PatientController {
    @Autowired
    PatientRepository patientRepository;


    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    @GetMapping("/patients/{patientId}")
    public Patient findById(@PathVariable(name="patientId") Long patientId) {

        return patientRepository.findById(patientId).get();
    }
}
