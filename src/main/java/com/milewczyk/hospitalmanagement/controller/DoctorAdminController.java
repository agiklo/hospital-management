package com.milewczyk.hospitalmanagement.controller;

import com.milewczyk.hospitalmanagement.model.dto.AdminViewOfDoctorDTO;
import com.milewczyk.hospitalmanagement.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/doctors")
public class DoctorAdminController {

    private final DoctorService doctorService;

    @GetMapping("/{id}")
    public ResponseEntity<AdminViewOfDoctorDTO> getDoctorById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.getFullInformationOfDoctorById(id));
    }
}
