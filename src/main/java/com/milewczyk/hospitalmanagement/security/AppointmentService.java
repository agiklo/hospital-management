package com.milewczyk.hospitalmanagement.security;

import com.milewczyk.hospitalmanagement.mapper.AppointmentMapper;
import com.milewczyk.hospitalmanagement.model.Appointment;
import com.milewczyk.hospitalmanagement.model.dto.AppointmentDetailsDTO;
import com.milewczyk.hospitalmanagement.model.dto.AppointmentSummaryDTO;
import com.milewczyk.hospitalmanagement.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    public Page<AppointmentSummaryDTO> getAllAppointments(Pageable pageable) {
        var appointmentSummaries = appointmentRepository.findAll(pageable)
                .stream()
                .map(appointmentMapper::mapAppointmentToAppointmentSummaryDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(appointmentSummaries);
    }

    public Page<AppointmentSummaryDTO> getAllAppointmentsByDate(LocalDateTime date, Pageable pageable) {
        var appointmentSummaries = appointmentRepository.getByDate(date, pageable)
                .stream()
                .map(appointmentMapper::mapAppointmentToAppointmentSummaryDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(appointmentSummaries);
    }

    public Page<AppointmentSummaryDTO> getAllAppointmentsByDoctorsLastname(String lastname, Pageable pageable) {
        var appointmentSummaries = appointmentRepository.getByDoctor_Lastname(lastname, pageable)
                .stream()
                .map(appointmentMapper::mapAppointmentToAppointmentSummaryDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(appointmentSummaries);
    }

    public Page<AppointmentSummaryDTO> getAllAppointmentsByPatientsLastname(String lastname, Pageable pageable) {
        var appointmentSummaries = appointmentRepository.getByPatient_Lastname(lastname, pageable)
                .stream()
                .map(appointmentMapper::mapAppointmentToAppointmentSummaryDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(appointmentSummaries);
    }

    public AppointmentDetailsDTO getAppointmentById(Long id) {
        var appointment = appointmentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Appointment does not exist, wrong id!"));
        return appointmentMapper.mapAppointmentToAppointmentDetailsDTO(appointment);
    }

    public Appointment addNewAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public AppointmentDetailsDTO changeDateOfAppointment(Long id, Appointment appointment) {
        var newAppointment = appointmentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Appointment does not exist, wrong id!"));
        newAppointment.setDate(appointment.getDate());
        return appointmentMapper.mapAppointmentToAppointmentDetailsDTO(newAppointment);
    }

    public void deleteAppointmentById(Long id) {
        appointmentRepository.deleteById(id);
    }

}
