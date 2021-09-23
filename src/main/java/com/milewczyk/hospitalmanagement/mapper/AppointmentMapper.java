package com.milewczyk.hospitalmanagement.mapper;

import com.milewczyk.hospitalmanagement.model.Appointment;
import com.milewczyk.hospitalmanagement.model.dto.AppointmentDetailsDTO;
import com.milewczyk.hospitalmanagement.model.dto.AppointmentSummaryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    @Mapping(target = "doctorFirstname", source = "doctor.firstname")
    @Mapping(target = "doctorLastname", source = "doctor.lastname")
    @Mapping(target = "patientFirstname", source = "patient.firstname")
    @Mapping(target = "patientLastname", source = "patient.lastname")
    AppointmentSummaryDTO mapAppointmentToAppointmentSummaryDTO(Appointment appointment);

    @Mapping(target = "doctorFirstname", source = "doctor.firstname")
    @Mapping(target = "doctorLastname", source = "doctor.lastname")
    @Mapping(target = "patientFirstname", source = "patient.firstname")
    @Mapping(target = "patientLastname", source = "patient.lastname")
    AppointmentDetailsDTO mapAppointmentToAppointmentDetailsDTO(Appointment appointment);
}
