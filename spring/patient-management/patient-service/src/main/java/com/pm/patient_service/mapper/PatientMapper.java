package com.pm.patient_service.mapper;

import com.pm.patient_service.dto.PatientResponseDTO;
import com.pm.patient_service.models.Patient;

public class PatientMapper {
    // converts the patient model to PatientResponseDTO
    // needs to be static because we would use this without instnatiating
    public static PatientResponseDTO toPatientResponseDTO(Patient patient)
    {
        PatientResponseDTO patientResponseDTO=new PatientResponseDTO();
        patientResponseDTO.setId(patient.getId().toString());
        patientResponseDTO.setAddress(patient.getAddress());
        patientResponseDTO.setEmail(patient.getEmail());
        patientResponseDTO.setDate_of_birth(patient.getDate_of_birth().toString());

        return patientResponseDTO;
    }
}
