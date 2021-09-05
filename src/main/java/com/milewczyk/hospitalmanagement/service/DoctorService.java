package com.milewczyk.hospitalmanagement.service;

import com.milewczyk.hospitalmanagement.mapper.DoctorMapper;
import com.milewczyk.hospitalmanagement.model.Doctor;
import com.milewczyk.hospitalmanagement.model.dto.DoctorSummaryDTO;
import com.milewczyk.hospitalmanagement.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public Page<DoctorSummaryDTO> getAllDoctorsSummaries(Pageable pageable) {
        var doctors = doctorRepository.findAll(pageable)
                .stream()
                .map(doctorMapper::mapDoctorToDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(doctors);
    }

    public Doctor addNewDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}
