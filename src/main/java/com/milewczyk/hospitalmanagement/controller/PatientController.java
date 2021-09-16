package com.milewczyk.hospitalmanagement.controller;

import com.milewczyk.hospitalmanagement.model.dto.PatientDTO;
import com.milewczyk.hospitalmanagement.model.dto.PatientSummaryDTO;
import com.milewczyk.hospitalmanagement.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/web/patients")
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<Page<PatientSummaryDTO>> getAllPatientsSummaries(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(patientService.getAllPatientsSummaries(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(patientService.getPatientById(id));
    }
}
