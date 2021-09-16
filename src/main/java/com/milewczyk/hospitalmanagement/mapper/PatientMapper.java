package com.milewczyk.hospitalmanagement.mapper;

import com.milewczyk.hospitalmanagement.model.Patient;
import com.milewczyk.hospitalmanagement.model.dto.PatientDTO;
import com.milewczyk.hospitalmanagement.model.dto.PatientSummaryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PatientMapper {


    @Mapping(target = "city", source = "address.city")
    @Mapping(target = "street", source = "address.street")
    @Mapping(target = "streetNumber", source = "address.streetNumber")
    @Mapping(target = "apartmentNumber", source = "address.apartmentNumber")
    @Mapping(target = "postCode", source = "address.postCode")
    @Mapping(target = "country", source = "address.country")
    PatientDTO mapPatientToPatientDTO(Patient patient);


    PatientSummaryDTO mapPatientToPatientSummaryDTO(Patient patient);
}
