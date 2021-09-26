package com.milewczyk.hospitalmanagement.service;

import com.milewczyk.hospitalmanagement.model.Prescription;
import com.milewczyk.hospitalmanagement.repository.PrescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    //TODO: CREATE DTO CLASSES AND MAP ENTITIES TO THEM

    public Page<Prescription> getPrescriptionsByDoctorId(Long id, Pageable pageable) {
        var prescriptions = prescriptionRepository.getByAppointment_Doctor_Id(id, pageable);
        updatePrescriptionsActiveStatusInCollection(prescriptions);
        return new PageImpl<>(prescriptions);
    }

    public Page<Prescription> getPrescriptionsByPatientId(Long id, Pageable pageable) {
        var prescriptions = prescriptionRepository.getByAppointment_Patient_Id(id, pageable);
        updatePrescriptionsActiveStatusInCollection(prescriptions);
        return new PageImpl<>(prescriptions);
    }

    private void updatePrescriptionsActiveStatusInCollection(Collection<Prescription> prescriptions) {
        for (Prescription prescription: prescriptions){
            updateActiveStatus(prescription);
        }
    }

    private void updateActiveStatus(Prescription prescription) {
        if (prescription.getValidUntil().isAfter(LocalDateTime.now())) {
            prescription.setActive(false);
        }
    }

    public Prescription getPrescriptionById(Long id) {
        var prescription = prescriptionRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Prescription does not exist"));
        updateActiveStatus(prescription);
        return prescription;
    }

    public Prescription addNewPrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    public void deletePrescriptionById(Long id) {
        prescriptionRepository.deleteById(id);
    }
}
