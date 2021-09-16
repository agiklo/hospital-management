package com.milewczyk.hospitalmanagement.service;

import com.milewczyk.hospitalmanagement.mapper.PatientMapper;
import com.milewczyk.hospitalmanagement.model.Patient;
import com.milewczyk.hospitalmanagement.model.dto.PatientDTO;
import com.milewczyk.hospitalmanagement.model.dto.PatientSummaryDTO;
import com.milewczyk.hospitalmanagement.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ContextConfiguration(classes = {PatientService.class})
@SpringBootTest
@AutoConfigureMockMvc
class PatientServiceTest {

    @MockBean
    private PatientMapper patientMapper;

    @MockBean
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    void shouldGetAllPatientsSummaries() {
        Patient patient = mock(Patient.class);
        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(patient);
        PageImpl<Patient> pageImpl = new PageImpl<>(patients);

        when(this.patientRepository.findAll((Pageable) any())).thenReturn(pageImpl);
        when(this.patientMapper.mapPatientToPatientSummaryDTO(any())).thenReturn(new PatientSummaryDTO());

        assertEquals(1, this.patientService.getAllPatientsSummaries(null).getSize());
        verify(this.patientMapper).mapPatientToPatientSummaryDTO(any());
        verify(this.patientRepository).findAll((Pageable) any());
    }

    @Test
    void shouldGetEmptyPageOfPatientSummaries() {
        when(this.patientRepository.findAll((Pageable) any())).thenReturn(new PageImpl<>(new ArrayList<>()));
        assertTrue(this.patientService.getAllPatientsSummaries(null).isEmpty());
        verify(this.patientRepository).findAll((Pageable) any());
    }

    @Test
    void shouldGetPatientById() {
        Patient patient = mock(Patient.class);
        PatientDTO patientDTO = new PatientDTO();
        Optional<Patient> ofResult = Optional.of(patient);

        when(this.patientRepository.findById(anyLong())).thenReturn(ofResult);
        when(this.patientMapper.mapPatientToPatientDTO(any())).thenReturn(patientDTO);

        assertSame(patientDTO, this.patientService.getPatientById(patient.getId()));
        verify(this.patientMapper).mapPatientToPatientDTO(any());
        verify(this.patientRepository).findById(anyLong());
    }

    @Test
    void shouldNotGetPatientByIdAndThrowException() {
        when(this.patientRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> this.patientService.getPatientById(anyLong()));
        verify(this.patientRepository).findById(anyLong());
    }

}
