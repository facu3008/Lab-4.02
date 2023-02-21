package com.ironhack.lab402.repository;

import com.ironhack.lab402.enums.Status;
import com.ironhack.lab402.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient> findByBirthDateBetween(Date startDate, Date endDate);

    List<Patient> findByAdmittedByDepartment(String department);

    List<Patient> findByAdmittedByStatus(Status status);
}
