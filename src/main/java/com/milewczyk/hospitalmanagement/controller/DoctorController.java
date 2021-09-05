package com.milewczyk.hospitalmanagement.controller;

import com.milewczyk.hospitalmanagement.model.Doctor;
import com.milewczyk.hospitalmanagement.model.dto.DoctorSummaryDTO;
import com.milewczyk.hospitalmanagement.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping(value = "/summaries")
    public ResponseEntity<Page<DoctorSummaryDTO>> getAllDoctorsSummaries(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.getAllDoctorsSummaries(pageable));
    }

    @PostMapping
    public ResponseEntity<Doctor> addNewDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.addNewDoctor(doctor));
    }
}
