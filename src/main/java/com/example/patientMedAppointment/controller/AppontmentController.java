package com.example.patientMedAppointment.controller;

import com.example.patientMedAppointment.dto.AppointmentDto;
import com.example.patientMedAppointment.dto.DoctorDto;
import com.example.patientMedAppointment.dto.PatientDto;
import com.example.patientMedAppointment.entity.Appointment;
import com.example.patientMedAppointment.entity.Doctor;
import com.example.patientMedAppointment.entity.Patient;
import com.example.patientMedAppointment.repository.PatientRepository;
import com.example.patientMedAppointment.service.AppointmentService;
import com.example.patientMedAppointment.service.DoctorService;
import com.example.patientMedAppointment.service.PatientRegService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;


@Controller
@AllArgsConstructor
public class AppontmentController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PatientRegService patientRegService;
    @Autowired
    private DoctorService doctorService;


    @PostMapping("/Appointment")
    public String saveDr(@ModelAttribute("appointment") AppointmentDto appointmentDto, @RequestParam("doctorName") String doctorname,Model model)  {

        try {
            String phoneNumber = appointmentDto.getPatientPhoneNumber();
            PatientDto patientDto = patientRegService.getPatientDetail(phoneNumber);
            if (patientDto != null) {
                appointmentDto.setPatientName(patientDto.getPatientname());
                appointmentDto.setPatientPhoneNumber(patientDto.getPhoneNumber());
            } else if (patientDto == null) {
                throw new NullPointerException("No patient found with this phone number.");
            }
        }
     catch (NullPointerException e) {
        model.addAttribute("errorMessage", e.getMessage());
        return "showDoctor";
    }
            appointmentDto.setDoctorname(doctorname);
        appointmentService.create(appointmentDto);
       return "redirect:/";
    }

    @GetMapping( "/viewAppointment")
    public String getAppointment(Model m){
        List<Appointment> appoint =appointmentService.getappointment();
        m.addAttribute("appoint",appoint);
        return "viewAppointment";
    }

    @GetMapping("/deleteAppointment/{id}")
    public String deletePatient(@PathVariable("id") String id,Model m){
        appointmentService.deleteAppointById(id);
        List<Appointment> appoint =appointmentService.getappointment();
        m.addAttribute("appoint",appoint);
        return "viewAppointment";
    }

    @PostMapping("/Updateappointment/{id}")
    public String updatePatient(@PathVariable("id") String id, Appointment appointment, Model m) {
        appointment.setId(id);
        appointmentService.updateAppointment(appointment);
        List<Appointment> appointment1 = appointmentService.getappointment();
        m.addAttribute("appoint",appointment1);
        return "viewAppointment";
    }

    @GetMapping("/editAppointment/{id}")
    public String editPatient(@PathVariable("id") String id, Model model) {
        Optional<Appointment> appointment = appointmentService.findAppointmentById(id);
        if (appointment.isPresent()) {
            model.addAttribute("appoint", appointment.get());
            return "editAppointment";
        } else {
            return "redirect:/viewAppointment";
        }
    }
}
