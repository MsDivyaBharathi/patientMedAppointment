package com.example.patientMedAppointment.controller;
import com.example.patientMedAppointment.dto.AppointmentDto;
import com.example.patientMedAppointment.dto.DoctorDto;
import com.example.patientMedAppointment.dto.PatientDto;
import com.example.patientMedAppointment.entity.Appointment;
import com.example.patientMedAppointment.entity.Doctor;
import com.example.patientMedAppointment.entity.Patient;
import com.example.patientMedAppointment.service.DoctorService;
import com.example.patientMedAppointment.service.PatientRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;

@Controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientRegService patientRegService;

    @GetMapping("/DoctorDtl")
    public String addPatient(Model model){
        Doctor doctor = new Doctor();
        model.addAttribute("doctor", doctor);
        return "Doctor";
    }

    @GetMapping("/displayDoctors")
    public String viewHomePage(Model model){
        model.addAttribute("allDrlist", doctorService.getAllDoctor());
        return "showDoctor";
    }

    @GetMapping("/Appointment/display")
    public String viewAppointment(@RequestParam String phoneNumber,Model model){
        try {
            AppointmentDto appointment = new AppointmentDto();
            PatientDto patientDto = patientRegService.getPatientDetail(phoneNumber);
            appointment.setPatientName(patientDto.getPatientname());
            appointment.setPatientPhoneNumber(patientDto.getPhoneNumber());

            if (patientDto == null) {
                throw new NullPointerException("No patient found with this phone number.");
            }
            else if (patientDto != null) {
                model.addAttribute("appointment", appointment);
                model.addAttribute("doctors", doctorService.getAllDoctor());
            }
        }
        catch (NullPointerException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "showDoctor";
        }
        return "appointment";
    }

    @PostMapping("/saveDoctor")
    public String saveDr(@ModelAttribute("doctor") DoctorDto doctorDto, @RequestParam("file") MultipartFile file) throws IOException{
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            String encodedPhoto = Base64.getEncoder().encodeToString(bytes);
            doctorDto.setDoctorphoto(encodedPhoto);
        }
        doctorService.save(doctorDto);
        return "redirect:/";
    }


}
