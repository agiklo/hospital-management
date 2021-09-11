package com.milewczyk.hospitalmanagement.service;

import com.milewczyk.hospitalmanagement.mapper.DoctorMapper;
import com.milewczyk.hospitalmanagement.model.Doctor;
import com.milewczyk.hospitalmanagement.model.dto.AdminViewOfDoctorDTO;
import com.milewczyk.hospitalmanagement.model.dto.DoctorSummaryDTO;
import com.milewczyk.hospitalmanagement.model.dto.PatientViewOfDoctorDTO;
import com.milewczyk.hospitalmanagement.repository.DoctorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {DoctorService.class})
@SpringBootTest
@AutoConfigureMockMvc
class DoctorServiceTest {

    @MockBean
    private DoctorMapper doctorMapper;

    @MockBean
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorService doctorService;

    @Test
    void shouldGetPageOfAllDoctorsSummaries() {
        Doctor doctor = mock(Doctor.class);
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(doctor);
        PageImpl<Doctor> pageImpl = new PageImpl<>(doctors);

        when(this.doctorRepository.findAll((Pageable) any())).thenReturn(pageImpl);
        when(this.doctorMapper.mapDoctorToDoctorSummaryDTO(any())).thenReturn(new DoctorSummaryDTO());

        assertEquals(1, this.doctorService.getAllDoctorsSummaries(null).getSize());
        verify(this.doctorMapper).mapDoctorToDoctorSummaryDTO(any());
        verify(this.doctorRepository).findAll((Pageable) any());
    }

    @Test
    void shouldGetEmptyPageOfDoctorSummaries() {
        when(this.doctorRepository.findAll((Pageable) any())).thenReturn(new PageImpl<>(new ArrayList<>()));
        assertTrue(this.doctorService.getAllDoctorsSummaries(null).isEmpty());
        verify(this.doctorRepository).findAll((Pageable) any());
    }

    @Test
    void shouldGetGeneralInformationOfDoctorById() {
        Doctor doctor = mock(Doctor.class);
        PatientViewOfDoctorDTO patientViewOfDoctorDTO = new PatientViewOfDoctorDTO();
        Optional<Doctor> ofResult = Optional.of(doctor);

        when(this.doctorRepository.findById(anyLong())).thenReturn(ofResult);
        when(this.doctorMapper.mapDoctorToPatientViewOfDoctorDTO(any())).thenReturn(patientViewOfDoctorDTO);

        assertSame(patientViewOfDoctorDTO, this.doctorService.getGeneralInformationOfDoctorById(doctor.getId()));
        verify(this.doctorMapper).mapDoctorToPatientViewOfDoctorDTO(any());
        verify(this.doctorRepository).findById(anyLong());
    }

    @Test
    void shouldNotGetGeneralInformationOfDoctorByIdAndThrowException() {
        when(this.doctorRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> this.doctorService.getGeneralInformationOfDoctorById(anyLong()));
        verify(this.doctorRepository).findById(anyLong());
    }

    @Test
    void shouldGetFullInformationOfDoctorById() {
        Doctor doctor = mock(Doctor.class);
        AdminViewOfDoctorDTO adminViewOfDoctorDTO = new AdminViewOfDoctorDTO();
        Optional<Doctor> ofResult = Optional.of(doctor);

        when(this.doctorRepository.findById(anyLong())).thenReturn(ofResult);
        when(this.doctorMapper.mapDoctorToAdminViewOfDoctorDTO(any())).thenReturn(adminViewOfDoctorDTO);

        assertSame(adminViewOfDoctorDTO, this.doctorService.getFullInformationOfDoctorById(doctor.getId()));
        verify(this.doctorMapper).mapDoctorToAdminViewOfDoctorDTO(any());
        verify(this.doctorRepository).findById(anyLong());
    }

    @Test
    void shouldNotGetFullInformationOfDoctorByIdAndThrowException() {
        when(this.doctorRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> this.doctorService.getFullInformationOfDoctorById(anyLong()));
        verify(this.doctorRepository).findById(anyLong());
    }

    @Test
    void shouldGetPageOfSummariesOfDoctorsByFirstnameOrLastname() {
        Doctor doctor = mock(Doctor.class);
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(doctor);
        PageImpl<Doctor> pageImpl = new PageImpl<>(doctors);

        when(this.doctorRepository.findByFirstnameContainsOrLastnameContains(anyString(), anyString(), any()))
                .thenReturn(pageImpl);
        when(this.doctorMapper.mapDoctorToDoctorSummaryDTO(any())).thenReturn(new DoctorSummaryDTO());

        assertEquals(1, this.doctorService.getSummariesOfDoctorsByFirstnameOrLastname(anyString(), anyString(), any()).getSize());
        verify(this.doctorMapper).mapDoctorToDoctorSummaryDTO(any());
        verify(this.doctorRepository).findByFirstnameContainsOrLastnameContains(anyString(), anyString(), any());
    }

    @Test
    void shouldNotGetPageOfSummariesOfDoctorsByFirstnameOrLastname() {
        Doctor doctor = mock(Doctor.class);
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(doctor);
        PageImpl<Doctor> pageImpl = new PageImpl<>(doctors);

        when(this.doctorRepository.findByFirstnameContainsOrLastnameContains(anyString(), anyString(), any()))
                .thenReturn(pageImpl);
        when(this.doctorMapper.mapDoctorToDoctorSummaryDTO(any())).thenReturn(new DoctorSummaryDTO());

        assertNotEquals(2, this.doctorService.getSummariesOfDoctorsByFirstnameOrLastname(anyString(), anyString(), any()).getSize());
        verify(this.doctorMapper).mapDoctorToDoctorSummaryDTO(any());
        verify(this.doctorRepository).findByFirstnameContainsOrLastnameContains(anyString(), anyString(), any());
    }

    @Test
    void shouldGetEmptyPageOfSummariesOfDoctorsByFirstnameOrLastname() {
        when(this.doctorRepository.findByFirstnameContainsOrLastnameContains(anyString(), anyString(), any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        assertTrue(this.doctorService.getSummariesOfDoctorsByFirstnameOrLastname(anyString(), anyString(), any()).isEmpty());
        verify(this.doctorRepository).findByFirstnameContainsOrLastnameContains(anyString(), anyString(), any());
    }
}
