package com.example.patientMedAppointment.controller;
import com.example.patientMedAppointment.entity.Medicine;
import com.example.patientMedAppointment.entity.Patient;
import com.example.patientMedAppointment.service.MedicineService;
import com.example.patientMedAppointment.service.PatientRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/medicines")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @Autowired
    private PatientRegService patientRegService;


        @GetMapping
        public String listMedicines(Model model) {
            model.addAttribute("medicines", medicineService.getAllMedicines());
            return "medicineList";
        }

        @GetMapping("/add")
        public String showAddForm(Model model) {
            List<Patient> patients =patientRegService.getpatient();
            model.addAttribute("medicine", new Medicine());
            model.addAttribute("patients",patients);
            return "addMedicine";
        }

        @PostMapping("/add")
        public String addMedicine(@ModelAttribute Medicine medicine,Model model,@RequestParam("patientName") String patientname) {
            medicine.setPatientname(patientname);
            medicineService.saveMedicine(medicine);
            return "redirect:/";

        }

        @GetMapping("/edit/{id}")
        public String showEditForm(@PathVariable("id") String id, Model model) {
            Medicine medicine = medicineService.getMedicineById(id);
            if (medicine != null) {
                model.addAttribute("medicine", medicine);
                return "editMedicine";
            } else {
                return "redirect:/";
            }
        }

        @PostMapping("/edit/{id}")
        public String editMedicine(@PathVariable("id") String id, @ModelAttribute Medicine medicine) {
            medicine.setId(id);
            medicineService.saveMedicine(medicine);
            return "redirect:/medicines";
        }

        @GetMapping("/delete/{id}")
        public String deleteMedicine(@PathVariable("id") String id) {
            medicineService.deleteMedicine(id);
            return "redirect:/medicines";
        }
    }



