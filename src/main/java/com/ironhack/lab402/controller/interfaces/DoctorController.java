package com.ironhack.lab402.controller.interfaces;

import com.ironhack.lab402.controller.DTOs.DoctorDTODepartment;
import com.ironhack.lab402.controller.DTOs.DoctorDtoStatus;
import com.ironhack.lab402.enums.Status;
import com.ironhack.lab402.model.Doctor;

import java.util.List;

public interface DoctorController {
    // FindAll
    List<Doctor> getAllDoctors();

    // FindById
    Doctor findById(Long employeeId);
    // FindByStatus
    List<Doctor> findByStatus(String status);

    // FindByDepartment
    List<Object> findByDepartment(String department);
//    Doctor findByDepartment(String department);

    Doctor addNewEmployee(Doctor employee);
    void updateStatusEmployee(Long id, DoctorDtoStatus doctorDtoStatus);
    void updateDepartmentEmployee(Long id, DoctorDTODepartment doctorDTODepartment);

}
