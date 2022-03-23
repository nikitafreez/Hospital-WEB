package com.example.medicom.Controllers;

import com.example.medicom.Models.Patient;
import com.example.medicom.Models.Position;
import com.example.medicom.Models.User;
import com.example.medicom.Models.Worker;
import com.example.medicom.Repository.PatientRepository;
import com.example.medicom.Repository.PositionRepository;
import com.example.medicom.Repository.UserRepository;
import com.example.medicom.Repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.DateFormatter;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class MedicomController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/")
    public String main(Model model) {
        return "MainTemplate";
    }

    @PostMapping("/")
    public String mainPost(Model model) {

        return "MainTemplate";
    }

    @GetMapping("/users")
    public String userMain(Model model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "User/UserTemplate";
    }

    @GetMapping("/users/add")
    public String userGet(User user) {

        return "Worker/WorkerTemplate-Add";
    }

    @PostMapping("/users/add")
    public String userPost(@Valid User user,
                           BindingResult bindingResult,
                           @RequestParam String login,
                           @RequestParam String password,
                           @RequestParam String role) {
        if (bindingResult.hasErrors())
            return "Worker/WorkerTemplate-Add";
        else {
            Calendar calendar = new GregorianCalendar();
            Date lastEnter = calendar.getTime();
            User user1 = new User(login, password, role, lastEnter);
            userRepository.save(user1);
            return "redirect:/users";
        }
    }

    @GetMapping("/users/{id}/edit")
    public String userEdit(@PathVariable(value = "id") Long id,
                           User user, Model model) {
        if (!userRepository.existsById(id))
            return "redirect:/users";
        Optional<User> users = userRepository.findById(id);
        ArrayList<User> res = new ArrayList<>();
        users.ifPresent(res::add);
        model.addAttribute("user1", res);
        return "Worker/WorkerTemplate-Edit";
    }

    @PostMapping("/users/{id}/edit")
    public String userUpdate(@PathVariable(value = "id") Long id,
                             @Valid User user,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            Optional<User> users = userRepository.findById(id);
            ArrayList<User> res = new ArrayList<>();
            users.ifPresent(res::add);
            model.addAttribute("user1", res);
            return "Worker/WorkerTemplate-Edit";
        } else {
            Calendar calendar = new GregorianCalendar();
            Date lastEnter = calendar.getTime();
            user.setLastEnter(lastEnter);
            userRepository.save(user);
            return "redirect:/users";
        }
    }

    @GetMapping("/users/{id}/delete")
    public String userDelete(@PathVariable(value = "id") Long id,
                             Model model) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
        return "redirect:/users";
    }


    @GetMapping("/positions")
    public String positionMain(Model model) {
        Iterable<Position> positions = positionRepository.findAll();
        model.addAttribute("positions", positions);
        return "Position/PositionTemplate";
    }

    @GetMapping("/positions/add")
    public String positionGet(Position position) {

        return "Position/PositionTemplate-Add";
    }

    @PostMapping("/positions/add")
    public String positionPost(@Valid Position position,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "Position/PositionTemplate-Add";
        else {
            positionRepository.save(position);
            return "redirect:/positions";
        }
    }

    @GetMapping("/positions/{id}/edit")
    public String positionEdit(@PathVariable(value = "id") Long id,
                               Position position, Model model) {
        if (!positionRepository.existsById(id))
            return "redirect:/positions";
        Optional<Position> positions = positionRepository.findById(id);
        ArrayList<Position> res = new ArrayList<>();
        positions.ifPresent(res::add);
        model.addAttribute("position1", res);
        return "Position/PositionTemplate-Edit";
    }

    @PostMapping("/positions/{id}/edit")
    public String positionUpdate(@PathVariable(value = "id") Long id,
                                 @Valid Position position,
                                 BindingResult bindingResult,
                                 Model model) {
        if (bindingResult.hasErrors()) {
            Optional<Position> positions = positionRepository.findById(id);
            ArrayList<Position> res = new ArrayList<>();
            positions.ifPresent(res::add);
            model.addAttribute("position1", res);
            return "Position/PositionTemplate-Edit";
        } else {
            positionRepository.save(position);
            return "redirect:/positions";
        }
    }

    @GetMapping("/positions/{id}/delete")
    public String positionDelete(@PathVariable(value = "id") Long id,
                                 Model model) {
        Position position = positionRepository.findById(id).orElseThrow();
        positionRepository.delete(position);
        return "redirect:/positions";
    }

    @GetMapping("/workers")
    public String workerMain(Model model) {
        Iterable<Worker> workers = workerRepository.findAll();
        model.addAttribute("workers", workers);
        return "Worker/WorkerTemplate";
    }

    @GetMapping("/workers/add")
    public String workerGet(Worker worker, Model model) {
        Iterable<Position> positions = positionRepository.findAll();
        model.addAttribute("positions", positions);
        return "Worker/WorkerTemplate-Add";
    }

    @PostMapping("/workers/add")
    public String workerPost(@Valid Worker worker,
                             BindingResult bindingResult,
                             @RequestParam String positionName) {
        if (bindingResult.hasErrors())
            return "Worker/WorkerTemplate-Add";
        else {
            Position position = positionRepository.findByPositionName(positionName);
            worker.setPosition_(position);
            workerRepository.save(worker);
            return "redirect:/workers";
        }
    }

    @GetMapping("/workers/{id}/edit")
    public String workerEdit(@PathVariable(value = "id") Long id,
                             Worker worker, Model model) {
        if (!workerRepository.existsById(id))
            return "redirect:/workers";
        Iterable<Position> positions = positionRepository.findAll();
        Optional<Worker> workers = workerRepository.findById(id);
        ArrayList<Worker> res = new ArrayList<>();
        workers.ifPresent(res::add);
        model.addAttribute("worker1", res);
        model.addAttribute("positions", positions);
        return "Worker/WorkerTemplate-Edit";
    }

    @PostMapping("/workers/{id}/edit")
    public String workerUpdate(@PathVariable(value = "id") Long id,
                               @Valid Worker worker,
                               @RequestParam String positionName,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            Optional<Worker> workers = workerRepository.findById(id);
            ArrayList<Worker> res = new ArrayList<>();
            workers.ifPresent(res::add);
            model.addAttribute("worker1", res);
            return "Worker/WorkerTemplate-Edit";
        } else {
            Position position = positionRepository.findByPositionName(positionName);
            worker.setPosition_(position);
            workerRepository.save(worker);
            return "redirect:/workers";
        }
    }

    @GetMapping("/workers/{id}/delete")
    public String workerDelete(@PathVariable(value = "id") Long id,
                               Model model) {
        Worker worker = workerRepository.findById(id).orElseThrow();
        workerRepository.delete(worker);
        return "redirect:/workers";
    }

    @GetMapping("/patients")
    public String patientMain(Model model) {
        Iterable<Patient> patients = patientRepository.findAll();
        model.addAttribute("patients", patients);
        return "Patient/PatientTemplate";
    }

    @GetMapping("/patients/add")
    public String patientGet(Patient patient, Model model) {

        return "Patient/PatientTemplate-Add";
    }

    @PostMapping("/patients/add")
    public String patientPost(@Valid Patient patient,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "Patient/PatientTemplate-Add";
        else {
            patientRepository.save(patient);
            return "redirect:/patients";
        }
    }

    @GetMapping("/patients/{id}/edit")
    public String patientEdit(@PathVariable(value = "id") Long id,
                              Patient patient, Model model) {
        if (!patientRepository.existsById(id))
            return "redirect:/patients";
        Optional<Patient> patients = patientRepository.findById(id);
        ArrayList<Patient> res = new ArrayList<>();
        patients.ifPresent(res::add);
        model.addAttribute("patient1", res);
        return "Patient/PatientTemplate-Edit";
    }

    @PostMapping("/patients/{id}/edit")
    public String patientUpdate(@PathVariable(value = "id") Long id,
                                @Valid Patient patient,
                                BindingResult bindingResult,
                                Model model) {
        if (bindingResult.hasErrors()) {
            Optional<Patient> patient1 = patientRepository.findById(id);
            ArrayList<Patient> res = new ArrayList<>();
            patient1.ifPresent(res::add);
            model.addAttribute("patient1", res);
            return "Patient/PatientTemplate-Edit";
        } else {
            patientRepository.save(patient);
            return "redirect:/patients";
        }
    }

    @GetMapping("/patients/{id}/delete")
    public String patientDelete(@PathVariable(value = "id") Long id,
                                Model model) {
        Patient patient = patientRepository.findById(id).orElseThrow();
        patientRepository.delete(patient);
        return "redirect:/patients";
    }
}
