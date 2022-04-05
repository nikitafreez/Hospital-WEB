package com.example.medicom.Models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Поле не может быть пустым")
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 2, max = 20, message = "Имя должно быть от 2 до 20 символов")
    private String Name;

    @NotNull(message = "Поле не может быть пустым")
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 2, max = 20, message = "Фамилия должна быть от 2 до 20 символов")
    private String Surname;

    @Size(max = 20, message = "Отчество должно быть до 20 символов")
    private String Patronymic;

    @Pattern(regexp = "\\d{4}",
            message = "Серия паспорта должна содержать 4 цифры")
    private String passSeria;

    @Pattern(regexp = "\\d{6}",
            message = "Номер паспорта должен содержать 6 цифр")
    private String passNum;

    @Pattern(regexp = "\\d{16}",
            message = "Номер ОМС должен содержать 16 цифр")
    private String OMS;

    @Pattern(regexp = "[7-8]\\d{10}",
            message = "Неккоректно указан номер телефона")
    private String phoneNum;

    @Pattern(regexp = "^\\S+@\\S+\\.\\S+$",
            message = "Неккоректно указан адрес электронной почты")
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @OneToMany(mappedBy = "patient_", fetch = FetchType.EAGER)
    private Collection<Treatment> treatmentCollection;

    public Collection<Treatment> getTreatmentCollection() {
        return treatmentCollection;
    }

    public void setTreatmentCollection(Collection<Treatment> treatmentCollection) {
        this.treatmentCollection = treatmentCollection;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public void setPatronymic(String patronymic) {
        Patronymic = patronymic;
    }

    public String getPassSeria() {
        return passSeria;
    }

    public void setPassSeria(String passSeria) {
        this.passSeria = passSeria;
    }

    public String getPassNum() {
        return passNum;
    }

    public void setPassNum(String passNum) {
        this.passNum = passNum;
    }

    public String getOMS() {
        return OMS;
    }

    public void setOMS(String OMS) {
        this.OMS = OMS;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Patient(String name, String surname, String patronymic, String passSeria, String passNum, String OMS, String phoneNum, String email, Date birthDate) {
        Name = name;
        Surname = surname;
        Patronymic = patronymic;
        this.passSeria = passSeria;
        this.passNum = passNum;
        this.OMS = OMS;
        this.phoneNum = phoneNum;
        this.email = email;
        this.birthDate = birthDate;
    }

    public Patient() {
    }
}
