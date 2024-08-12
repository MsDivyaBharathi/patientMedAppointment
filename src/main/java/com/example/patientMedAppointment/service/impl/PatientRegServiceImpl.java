package com.example.patientMedAppointment.service.impl;
import com.example.patientMedAppointment.dto.PatientDto;
import com.example.patientMedAppointment.entity.Patient;
import com.example.patientMedAppointment.repository.PatientRepository;
import com.example.patientMedAppointment.service.PatientRegService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientRegServiceImpl implements PatientRegService {


    private PatientRepository patientRepository;

    private ModelMapper modelMapper;
    @Override
    public PatientDto save(PatientDto patientDto) {

            Patient patient = modelMapper.map(patientDto, Patient.class);

        return modelMapper.map(patientRepository.save(patient), PatientDto.class);
    }

    @Override
    public PatientDto getPatientDetail(String phoneNumber) {
        return patientRepository.findByphoneNumber(phoneNumber);
    }

    @Override
    public List<Patient> getpatient() {
        return patientRepository.findAll();
    }

    @Override
   public void deletepatient(String id) {
         patientRepository.deleteById(id);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Optional<Patient> findPatientById(String id) {
        return patientRepository.findById(id);
    }


}
