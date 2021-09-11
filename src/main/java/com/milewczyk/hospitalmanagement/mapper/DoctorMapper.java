package com.milewczyk.hospitalmanagement.mapper;

import com.milewczyk.hospitalmanagement.model.Doctor;
import com.milewczyk.hospitalmanagement.model.dto.AdminViewOfDoctorDTO;
import com.milewczyk.hospitalmanagement.model.dto.PatientViewOfDoctorDTO;
import com.milewczyk.hospitalmanagement.model.dto.DoctorSummaryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    DoctorSummaryDTO mapDoctorToDoctorSummaryDTO(Doctor doctor);

    PatientViewOfDoctorDTO mapDoctorToPatientViewOfDoctorDTO(Doctor doctor);

    @Mapping(target = "city", source = "address.city")
    @Mapping(target = "street", source = "address.street")
    @Mapping(target = "streetNumber", source = "address.streetNumber")
    @Mapping(target = "apartmentNumber", source = "address.apartmentNumber")
    @Mapping(target = "postCode", source = "address.postCode")
    @Mapping(target = "country", source = "address.country")
    AdminViewOfDoctorDTO mapDoctorToAdminViewOfDoctorDTO(Doctor doctor);
}
