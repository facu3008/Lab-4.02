package com.ironhack.lab402.controller.implementacion;

import com.ironhack.lab402.controller.DTOs.DoctorDTODepartment;
import com.ironhack.lab402.controller.DTOs.DoctorDtoStatus;
import com.ironhack.lab402.controller.interfaces.DoctorController;
import com.ironhack.lab402.enums.Status;
import com.ironhack.lab402.model.Doctor;
import com.ironhack.lab402.repository.DoctorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class DoctorControllerImpl implements DoctorController {
    @Autowired
    DoctorRepository doctorRepository;
    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @GetMapping("/doctors/{employeeId}")
    public Doctor findById(@PathVariable (name="employeeId") Long employeeId) {

        return doctorRepository.findById(employeeId).get();
    }




    @GetMapping("/doctorsStatus/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> findByStatus(@PathVariable String status) {
        return doctorRepository.findByStatus(Status.valueOf(status.toUpperCase()));
    }

    @GetMapping("/doctorsDepartment/{department}")
    public List<Object> findByDepartment(@PathVariable String department) {
        return doctorRepository.findByDepartment(department);
    }

    //We use PATCH mapping because we want to update certain properties from a certain employee, and we create a specific DTO for this.
    //We don't need to return anything and that's why the response is NO_CONTENT.
    //http://localhost:8081/employees/update-status/172456
    @PatchMapping("/doctors/update-status/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatusEmployee(@PathVariable Long employeeId, @RequestBody @Valid DoctorDtoStatus doctorDTOStatus){
        doct.updateStatus(id, doctorDTOStatus);
    }

    //We use PATCH mapping because we want to update certain properties from a certain employee, and we create a specific DTO for this.
    //We don't need to return anything and that's why the response is NO_CONTENT.
    //http://localhost:8081/employees/update-department/172456
    @PatchMapping("/employees/update-department/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDepartmentEmployee(@PathVariable Long id, @RequestBody @Valid DoctorDTODepartment doctorDTODepartment){
        doctorService.updateDepartment(id, doctorDTODepartment;
    }

}
