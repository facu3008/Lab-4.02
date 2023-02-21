package com.ironhack.lab402.services;

import com.ironhack.lab402.controller.DTOs.PatientDTO;
import com.ironhack.lab402.model.Patient;
import com.ironhack.lab402.model.Doctor;
import com.ironhack.lab402.repository.DoctorRepository;
import com.ironhack.lab402.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PatientService {

    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;

//    public Patient createNewPatient(PatientDTO patientDTO){
//        Doctor doctor = doctorRepository.findById(patientDTO.get()).get();
//        return patientRepository.save(new Patient(patientDTO.getName(), patientDTO.getDateOfBirth(), employee));
//    }


    public void updatePatientInfo(Long id, PatientDTO patientDTO) {
        //We need to find the patient the user wants to update, if it doesn't exist throw an error. Here we have made the throw in a one line instead of doing it with ifs like we did before.
        Patient patientDB = patientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found"));
        //Check if any of the fields is filled in the patientDTO, update the patientDB and finally save it in the repo.
        if(patientDTO.getName() != null) patientDB.setName(patientDTO.getName());
        if(patientDTO.getBirthDate() != null) patientDB.setDateOfBirth(patientDTO.getBirthDate());
        if(patientDTO.getAdmittedBy() != null) patientDB.setAdmittedBy(patientDTO.getAdmittedBy());
        patientRepository.save(patientDB);
    }

}
