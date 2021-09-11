package com.milewczyk.hospitalmanagement.controller;

import com.milewczyk.hospitalmanagement.model.dto.DoctorSummaryDTO;
import com.milewczyk.hospitalmanagement.model.dto.PatientViewOfDoctorDTO;
import com.milewczyk.hospitalmanagement.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/web/doctors")
public class DoctorWebController {

    private final DoctorService doctorService;

    @GetMapping("/summaries")
    public ResponseEntity<Page<DoctorSummaryDTO>> getAllDoctorsSummaries(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.getAllDoctorsSummaries(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientViewOfDoctorDTO> getDoctorById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.getGeneralInformationOfDoctorById(id));
    }

    @GetMapping("/")
    public ResponseEntity<Page<DoctorSummaryDTO>> getSummariesOfDoctorsByFirstnameOrLastname(
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(doctorService.getSummariesOfDoctorsByFirstnameOrLastname(firstname, lastname, pageable));
    }
}
