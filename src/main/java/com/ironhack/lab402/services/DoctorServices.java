package com.ironhack.lab402.services;

import com.ironhack.lab402.controller.DTOs.DoctorDTODepartment;
import com.ironhack.lab402.controller.DTOs.DoctorDtoStatus;
import com.ironhack.lab402.enums.Status;
import com.ironhack.lab402.model.Doctor;
import com.ironhack.lab402.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServices {

    @Autowired
    DoctorRepository doctorRepository;


    public Doctor createNewEmployee(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public Doctor updateStatus(Long doctorId, DoctorDtoStatus doctorDtoStatus){
        Doctor doctor = doctorRepository.findById(doctorId).get();
        doctor.setStatus(doctorDtoStatus.getStatus());
        return doctorRepository.save(doctor);
    }

    public Doctor updateDepartment(Long doctorId, DoctorDTODepartment doctorDTODepartment){
        Doctor doctor = doctorRepository.findById(doctorId).get();
        doctor.setDepartment(doctorDTODepartment.getDepartment());
        return doctorRepository.save(doctor);

    }




}
