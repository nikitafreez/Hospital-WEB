package com.example.medicom.Models;

import net.bytebuddy.implementation.bind.annotation.Empty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;

@Entity
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Поле не может быть пустым")
    @NotEmpty(message = "Поле не может быть пустым")
    private String Name;

    @NotNull(message = "Поле не может быть пустым")
    @NotEmpty(message = "Поле не может быть пустым")
    private String Surname;

    private String Patronymic;

    @NotNull(message = "Поле не может быть пустым")
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 4, max = 4, message = "Серия должна содержать 4 символа")
    private String PassSeria;

    @NotNull(message = "Поле не может быть пустым")
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 6, max = 6, message = "Номер должен содержать 6 символов")
    private String PassNum;

    @NotNull(message = "Поле не может быть пустым")
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 12, max = 12, message = "ИНН должен содержать 12 символов")
    private String INN;

    @NotNull(message = "Поле не может быть пустым")
    @NotEmpty(message = "Поле не может быть пустым")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String birthDate;

    @ManyToOne(optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "position_id")
    private Position position_;

    @OneToMany(mappedBy = "worker_", fetch = FetchType.EAGER)
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

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public Position getPosition_() {
        return position_;
    }

    public void setPosition_(Position position_) {
        this.position_ = position_;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Worker(String name, String surname, String patronymic, String passSeria, String passNum, String INN, String birthDate, Position position_) {
        Name = name;
        Surname = surname;
        Patronymic = patronymic;
        PassSeria = passSeria;
        PassNum = passNum;
        this.INN = INN;
        this.birthDate = birthDate;
        this.position_ = position_;
    }

    public Worker() {
    }
}
