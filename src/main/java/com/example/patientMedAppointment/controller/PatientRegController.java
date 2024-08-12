package com.example.patientMedAppointment.controller;

import com.example.patientMedAppointment.dto.PatientDto;
import com.example.patientMedAppointment.entity.Appointment;
import com.example.patientMedAppointment.entity.Patient;
import com.example.patientMedAppointment.repository.PatientRepository;
import com.example.patientMedAppointment.service.PatientRegService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class PatientRegController {

    private PatientRegService patientRegService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        return "index";
    }

    @GetMapping("/patientRegister")
    public String addPatient(Model model){
        //map to dto & handle entity
        Patient patient = new Patient();
        model.addAttribute("patient", patient);
        return "patientRegistration";
    }

    @PostMapping("/save")
    public String savePatient(@Valid @ModelAttribute("patient") PatientDto patientDto){
        patientRegService.save(patientDto);
        return "redirect:/";
    }

    @GetMapping( "/viewPatients")
    public String getAppointment(Model m){
        List<Patient> patient =patientRegService.getpatient();
        m.addAttribute("pat",patient);
        return "viewPatients";
    }

    @GetMapping("/delete_patient/{id}")
    public String deletePatient(@PathVariable("id") String id,Model m){
        patientRegService.deletepatient(id);
        List<Patient> patient =patientRegService.getpatient();
        m.addAttribute("pat",patient);
        return "redirect:/viewPatients";
    }

    @PostMapping("/Updatepatient/{id}")
    public String updatePatient(@PathVariable("id") String id, Patient patient,Model m) {
        patient.setId(id);
        patientRegService.updatePatient(patient);
        List<Patient> patients =patientRegService.getpatient();
        m.addAttribute("pat",patients);
        return "viewPatients";
    }

    @GetMapping("/edit_Patient/{id}")
    public String editPatient(@PathVariable("id") String id, Model model) {
        Optional<Patient> patient = patientRegService.findPatientById(id);
        if (patient.isPresent()) {
            model.addAttribute("patient", patient.get());
            return "editPatient";
        } else {
            return "redirect:/viewPatients";
        }
    }

}
