package com.example.patientMedAppointment.service;

import com.example.patientMedAppointment.entity.Medicine;

import java.util.List;

public interface MedicineService {


    List<Medicine> getAllMedicines();

    Medicine saveMedicine(Medicine medicine);

    Medicine getMedicineById(String id);

    void deleteMedicine(String id);
}
