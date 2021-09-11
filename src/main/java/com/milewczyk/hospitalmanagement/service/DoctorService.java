package com.milewczyk.hospitalmanagement.service;

import com.milewczyk.hospitalmanagement.mapper.DoctorMapper;
import com.milewczyk.hospitalmanagement.model.dto.AdminViewOfDoctorDTO;
import com.milewczyk.hospitalmanagement.model.dto.PatientViewOfDoctorDTO;
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
                .map(doctorMapper::mapDoctorToDoctorSummaryDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(doctors);
    }

    public PatientViewOfDoctorDTO getGeneralInformationOfDoctorById(Long id) {
        var doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Doctor with id " + id + " does not exist"));
        return doctorMapper.mapDoctorToPatientViewOfDoctorDTO(doctor);
    }

    public AdminViewOfDoctorDTO getFullInformationOfDoctorById(Long id) {
        var doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Doctor with id " + id + " does not exist"));
        return doctorMapper.mapDoctorToAdminViewOfDoctorDTO(doctor);
    }

    public Page<DoctorSummaryDTO> getSummariesOfDoctorsByFirstnameOrLastname(String firstname, String lastname, Pageable pageable) {
        var doctors = doctorRepository.findByFirstnameContainsOrLastnameContains(firstname, lastname, pageable)
                .stream()
                .map(doctorMapper::mapDoctorToDoctorSummaryDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(doctors);
    }
}
