package com.milewczyk.hospitalmanagement.service;

import com.milewczyk.hospitalmanagement.mapper.PatientMapper;
import com.milewczyk.hospitalmanagement.model.dto.PatientDTO;
import com.milewczyk.hospitalmanagement.model.dto.PatientSummaryDTO;
import com.milewczyk.hospitalmanagement.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public Page<PatientSummaryDTO> getAllPatientsSummaries(Pageable pageable) {
        var patients = patientRepository.findAll(pageable).stream()
                .map(patientMapper::mapPatientToPatientSummaryDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(patients);
    }

    public PatientDTO getPatientById(Long id) {
        var patient = patientRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient does not exist!"));
        return patientMapper.mapPatientToPatientDTO(patient);
    }
}
