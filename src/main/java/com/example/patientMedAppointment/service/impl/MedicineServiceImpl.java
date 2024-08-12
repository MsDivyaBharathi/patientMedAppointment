package com.example.patientMedAppointment.service.impl;

import com.example.patientMedAppointment.entity.Medicine;
import com.example.patientMedAppointment.repository.MedicineRepository;
import com.example.patientMedAppointment.service.MedicineService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }


    public Medicine saveMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @Override
    public Medicine getMedicineById(String id) {
        return medicineRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteMedicine(String id) {
        medicineRepository.deleteById(id);
    }
}
