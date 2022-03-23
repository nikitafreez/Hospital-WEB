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
    private String Name;

    @NotNull(message = "Поле не может быть пустым")
    @NotEmpty(message = "Поле не может быть пустым")
    private String Surname;

    @NotNull(message = "Поле не может быть пустым")
    @NotEmpty(message = "Поле не может быть пустым")
    private String Patronymic;

    @Pattern(regexp = "\\d{4}",
            message = "Серия паспорта должна содержать 4 цифры")
    private String PassSeria;

    @Pattern(regexp = "\\d{6}",
            message = "Номер паспорта должен содержать 6 цифр")
    private String PassNum;

    @Pattern(regexp = "\\d{16}",
            message = "Номер ОМС должен содержать 16 цифр")
    private String OMS;

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
        return PassSeria;
    }

    public void setPassSeria(String passSeria) {
        PassSeria = passSeria;
    }

    public String getPassNum() {
        return PassNum;
    }

    public void setPassNum(String passNum) {
        PassNum = passNum;
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

    public Patient(String name, String surname, String patronymic, String passSeria, String passNum, String OMS, Date birthDate) {
        Name = name;
        Surname = surname;
        Patronymic = patronymic;
        PassSeria = passSeria;
        PassNum = passNum;
        this.OMS = OMS;
        this.birthDate = birthDate;
    }

    public Patient() {
    }
}
