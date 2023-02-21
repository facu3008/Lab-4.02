package com.ironhack.lab402.controller.implementacion;

import com.ironhack.lab402.controller.DTOs.PatientDTO;
import com.ironhack.lab402.controller.interfaces.PatientController;
import com.ironhack.lab402.enums.Status;
import com.ironhack.lab402.model.Doctor;
import com.ironhack.lab402.model.Patient;
import com.ironhack.lab402.repository.PatientRepository;
import com.ironhack.lab402.services.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class PatientControllerImpl implements PatientController {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    PatientService patientService;

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    @GetMapping("/patients/{patientId}")
    public Patient findById(@PathVariable(name="patientId") Long patientId) {

        return patientRepository.findById(patientId).get();
    }

    @GetMapping("/patients/{dateOfBirth}")
    public List<Patient> findByDateOfBirthBetween(@RequestParam LocalDate start, @RequestParam LocalDate end) {
        return patientRepository.findByDateOfBirthBetween(start, end);
    }




    @GetMapping("/patients/{department}")
    public List<Patient> findPatientsByDoctorDepartment(@RequestParam String department){
        return patientRepository.findByAdmittedByDepartment(department);
    }

    @Override
    public List<Patient> findPatientsByDoctorStatus(Status status) {
        return null;
    }

    @PostMapping("/patients/add-patient")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient addNewPatient(@RequestBody @Valid Patient patient){
        return patientRepository.save(patient);
    }
    @PutMapping("/patients/update-patient/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePatientInfo(@PathVariable Long id, @RequestBody @Valid PatientDTO patientDTO){
        patientService.updatePatientInfo(id, patientDTO);
    }


//    @PutMapping("/patients/update-patient/{id}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public Patient updatePatient(@RequestBody PatientDTO patientDTO, @PathVariable Integer id){
//        return patientService.updatePatient(patientDTO, id);
//    }





}
