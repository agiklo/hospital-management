package com.milewczyk.hospitalmanagement.mapper;

import com.milewczyk.hospitalmanagement.model.Doctor;
import com.milewczyk.hospitalmanagement.model.dto.DoctorSummaryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    DoctorSummaryDTO mapDoctorToDTO(Doctor doctor);
}
