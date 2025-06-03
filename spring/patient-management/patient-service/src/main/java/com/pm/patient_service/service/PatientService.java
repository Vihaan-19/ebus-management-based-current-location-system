package com.pm.patient_service.service;

import com.pm.patient_service.dto.PatientResponseDTO;
import com.pm.patient_service.mapper.PatientMapper;
import com.pm.patient_service.models.Patient;
import com.pm.patient_service.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    // This is called dependency injection
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients(){
        List<Patient>patients=patientRepository.findAll();

        // converts the list of patients to list of response dto's
        List<PatientResponseDTO>patientResponseDTOS=patients.stream().map(patient -> PatientMapper.toPatientResponseDTO(patient)).toList();

        return patientResponseDTOS;
    }
}
