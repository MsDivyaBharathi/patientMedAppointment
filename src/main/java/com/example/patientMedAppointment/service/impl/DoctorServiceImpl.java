package com.example.patientMedAppointment.service.impl;
import com.example.patientMedAppointment.dto.DoctorDto;
import com.example.patientMedAppointment.dto.PatientDto;
import com.example.patientMedAppointment.entity.Doctor;
import com.example.patientMedAppointment.repository.DoctorRepository;
import com.example.patientMedAppointment.repository.PatientRepository;
import com.example.patientMedAppointment.service.DoctorService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorRepository;
    private ModelMapper modelMapper;
    @Override
    public List<Doctor> getAllDoctor() {
        return doctorRepository.findAll();
    }

    @Override
    public DoctorDto save(DoctorDto doctorDto) {
        Doctor doctor = modelMapper.map(doctorDto, Doctor.class);

        return modelMapper.map(doctorRepository.save(doctor), DoctorDto.class);
    }

}
