package com.milewczyk.hospitalmanagement.service;

import com.milewczyk.hospitalmanagement.mapper.DoctorMapper;
import com.milewczyk.hospitalmanagement.model.Doctor;
import com.milewczyk.hospitalmanagement.model.dto.DoctorSummaryDTO;
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
        when(this.doctorMapper.mapDoctorToDTO(any())).thenReturn(new DoctorSummaryDTO());

        assertEquals(1, this.doctorService.getAllDoctorsSummaries(null).getSize());
        verify(this.doctorMapper).mapDoctorToDTO(any());
        verify(this.doctorRepository).findAll((Pageable) any());
    }

    @Test
    void shouldGetEmptyPageOfDoctorSummaries() {
        when(this.doctorRepository.findAll((Pageable) any())).thenReturn(new PageImpl<>(new ArrayList<>()));
        assertTrue(this.doctorService.getAllDoctorsSummaries(null).isEmpty());
        verify(this.doctorRepository).findAll((Pageable) any());
    }
}
