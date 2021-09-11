package com.milewczyk.hospitalmanagement.repository;

import com.milewczyk.hospitalmanagement.model.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findByEmail(String email);

    Page<Doctor> findByFirstnameContainsOrLastnameContains(String firstname, String lastname, Pageable pageable);
}
