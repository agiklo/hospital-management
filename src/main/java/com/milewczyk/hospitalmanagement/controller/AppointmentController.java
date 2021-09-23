package com.milewczyk.hospitalmanagement.controller;

import com.milewczyk.hospitalmanagement.model.Appointment;
import com.milewczyk.hospitalmanagement.model.dto.AppointmentDetailsDTO;
import com.milewczyk.hospitalmanagement.model.dto.AppointmentSummaryDTO;
import com.milewczyk.hospitalmanagement.security.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/web/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping("/summaries")
    public ResponseEntity<Page<AppointmentSummaryDTO>> getAllAppointments(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService.getAllAppointments(pageable));
    }

    @GetMapping("/date")
    public ResponseEntity<Page<AppointmentSummaryDTO>> getAllAppointmentsByDate(@RequestParam("date") LocalDateTime date, Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService.getAllAppointmentsByDate(date, pageable));
    }

    @GetMapping("/doctor")
    public ResponseEntity<Page<AppointmentSummaryDTO>> getAllAppointmentsByDoctorsLastname(@RequestParam("lastname") String lastname, Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService.getAllAppointmentsByDoctorsLastname(lastname, pageable));
    }

    @GetMapping("/patient")
    public ResponseEntity<Page<AppointmentSummaryDTO>> getAllAppointmentsByPatientsLastname(@RequestParam("lastname") String lastname, Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService.getAllAppointmentsByPatientsLastname(lastname, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDetailsDTO> getAppointmentById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService.getAppointmentById(id));
    }

    @PostMapping
    public ResponseEntity<Appointment> addNewAppointment(@RequestBody Appointment appointment) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.addNewAppointment(appointment));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AppointmentDetailsDTO> changeDateOfAppointment(@PathVariable("id") Long id, @RequestBody Appointment appointment) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.changeDateOfAppointment(id, appointment));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAppointmentById(@PathVariable("id") Long id) {
        appointmentService.deleteAppointmentById(id);
    }
}
